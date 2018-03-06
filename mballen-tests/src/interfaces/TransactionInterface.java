package interfaces;

import entities.Agent;
import entities.Client;
import entities.Transaction;

import java.util.Date;

public interface TransactionInterface {
    Transaction build(Client client, Agent agent,Date transactionDate, double transactionValue, String transactionType);
}
