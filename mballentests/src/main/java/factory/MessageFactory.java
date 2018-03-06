package factory;

import entities.*;
import interfaces.MessageInterface;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MessageFactory {
    private Map<String, MessageInterface> mapa = new HashMap<String, MessageInterface>();

    public MessageFactory() {
        this.addOperations();
    }

    public void addOperations() {
        this.mapa.put("transactionMessage", (customerID, customerEmail, agentID, messageType, accountID, transactionDate, transactionValue, transactionType) -> new TransactionMessage(customerID, customerEmail, agentID, messageType, accountID, transactionDate, transactionValue, transactionType));
    }

    public Message buildMessage(String customerID, String customerEmail, String agentID, String messageType, int accountID, Date transactionDate, double transactionValue, String transactionType){
        return this.mapa.get(messageType).build(customerID, customerEmail, agentID, messageType, accountID, transactionDate, transactionValue, transactionType);
    }
}
