package factory;

import entities.*;
import interfaces.AgentInterface;
import interfaces.TransactionInterface;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TransactionFactory {
    private Map<String, TransactionInterface> mapa = new HashMap<String, TransactionInterface>();

    public void addToMap() {
        this.mapa.put("deposit", (client, agent, transactionDate, transactionValue, transationType) -> new Deposit(client, agent, transactionDate, transactionValue, transationType));
        this.mapa.put("withdrawal", (client, agent, transactionDate, transactionValue, transationType) -> new Withdrawal(client, agent, transactionDate, transactionValue, transationType));
        this.mapa.put("issue", (client, agent, transactionDate, transactionValue, transationType) -> new Issue(client, agent, transactionDate, transactionValue, transationType));
    }

    public Transaction buildTransaction(Client client, Agent agent, Date trasactionDate, double value, String type){
        this.addToMap();
        return this.mapa.get(type).build(client, agent, trasactionDate, value, type);
    }
}
