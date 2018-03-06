package controllers;

import entities.Agent;
import entities.Client;
import factory.AgentFactory;
import utils.Utils;

import java.util.*;

public class Bank {
    private List<Client> clientsList;
    private AgentFactory agentFactory;
    private Queue<Agent> agentPriorityQueue;
    private Dispatcher dispatcher;

    public Bank() {
        this.clientsList = new ArrayList<>();
        this.agentFactory = new AgentFactory();
        this.agentPriorityQueue = new PriorityQueue<>(100, (agentOne, agentTwo) -> new Integer(agentOne.getPriority()).compareTo(agentTwo.getPriority()));
        this.createClients();
        this.createAgents();
        this.dispatcher = Dispatcher.getDispatcher(clientsList, (PriorityQueue) agentPriorityQueue);
        this.dispatcher.attend();
    }

    public String getTransactionValue(String operation){
        return operation.equals("Solve issue") ? "I have a problem with my account..." : String.valueOf(Utils.getRandom().nextInt() * 100000);
    }

    public void createClients() {
        for(int i = 0; i < 15; ++i ) {
            String name = Utils.randomClientNameGenerator();
            Client client = new Client(name, Utils.randomIDGenerator(), Utils.getRandom().nextInt(1000000),String.valueOf(Utils.getRandom().nextInt(10000)),name.replace(" ","")+"@banco.com");
            client.setTransactionValue(getTransactionValue(client.getIssue()));
            clientsList.add(client);
        }
    }

    public void createAgents() {
        for(int i = 0; i < 5; i++){
            agentPriorityQueue.add(agentFactory.buildAgent(Utils.randomClientNameGenerator(), Utils.randomIDGenerator(), "cashier"));
        }
        for(int i = 0; i < 3; i++){
            agentPriorityQueue.add(agentFactory.buildAgent(Utils.randomClientNameGenerator(), Utils.randomIDGenerator(), "supervisor"));
        }
        for(int i = 0; i < 2; i++){
            agentPriorityQueue.add(agentFactory.buildAgent(Utils.randomClientNameGenerator(), Utils.randomIDGenerator(), "director"));
        }
    }
}
