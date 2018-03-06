package controllers;

import entities.*;

import factory.MessageFactory;
import factory.TransactionFactory;
import services.MessageService;
import utils.IO;
import utils.Utils;

import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class Dispatcher  {
    private static Dispatcher dispatcher = null;
    private ExecutorService executorService;
    private List<Client> clientsList;
    private PriorityQueue<Agent> agentPriorityQueue;
    private String operations[] = {"deposit", "withdrawal", "issue"};
    private MessageService messageService;
    private MessageFactory messageFactory;

    public static Dispatcher getDispatcher(List clientsList, PriorityQueue<Agent> agentPriorityQueue) {
        if(dispatcher == null) {
           dispatcher = new Dispatcher(clientsList, agentPriorityQueue);
        }
        return dispatcher;
    }

    private Dispatcher(List clientsList, PriorityQueue<Agent> agentPriorityQueue) {
        this.clientsList = clientsList;
        this.agentPriorityQueue = agentPriorityQueue;
        this.executorService = Executors.newFixedThreadPool(agentPriorityQueue.size());
        this.messageService =  MessageService.getMessageService();
        this.messageFactory = new MessageFactory();

    }

    public void attend() {
        while(agentPriorityQueue.size() > 0 && clientsList.size() > 0) {
            validateThereIsAClient();
        }
    }

    private void attendTrasaction(Transaction transaction){
        IO.printMessage("Client " + transaction.getClient().getName() +
                        " will be attended by " + transaction.getAgent().getName() + " (" +
                        transaction.getAgent().getAgentType() + ")" + " for a " + transaction.getType());
        Supplier<Transaction> dispatcher = new TransactionSupplier(transaction);
        CompletableFuture.supplyAsync(dispatcher, executorService).thenAccept(finishedTransaction -> {
            this.agentPriorityQueue.add(finishedTransaction.getAgent());
            this.validateThereIsAClient();
            messageService.sendMessage(messageFactory.buildMessage(transaction.getClient().getId(), transaction.getClient().getEmail(), transaction.getAgent().getId(),"transactionMessage",Integer.parseInt(transaction.getClient().getIssue()), transaction.getTransactionDate(), transaction.getTransactionValue(), transaction.getType()));
        });
    }

    private void validateThereIsAClient(){
        if(!clientsList.isEmpty()) {
            Transaction transaction =  createTrasaction();
            clientsList.remove(0);
            attendTrasaction(transaction);
        }
        else {
            executorService.shutdown();
        }
    }

    private Transaction createTrasaction(){
        TransactionFactory transactionFactory = new TransactionFactory();
        return transactionFactory.buildTransaction(clientsList.get(0), agentPriorityQueue.poll(), new Date(), Utils.getRandom().nextInt(100000), operations[Utils.getRandom().nextInt(3)]);
    }
}
