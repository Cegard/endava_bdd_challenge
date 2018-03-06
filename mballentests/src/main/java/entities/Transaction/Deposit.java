package entities;

import utils.IO;

import java.util.Date;

public class Deposit extends Transaction {
    public Deposit(Client client, Agent agent, Date transactionDate, double transactionValue, String type) {
        super(client, agent, transactionDate, transactionValue, type);
    }

    public boolean attend(Client client) {
        IO.printMessage(client.getName() + " deposits: " + this.transactionValue);
        this.client.setBalance(this.client.getBalance() + this.transactionValue);
        return true;
    }
}
