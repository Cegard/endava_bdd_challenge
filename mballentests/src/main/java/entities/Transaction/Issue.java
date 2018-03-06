package entities;

import utils.IO;

import java.util.Date;

public class Issue extends Transaction {
    public Issue(Client client, Agent agent, Date transactionDate, double transactionValue, String type) {
        super(client, agent, transactionDate, transactionValue, type);
    }

    @Override
    public boolean attend(Client client) {
        IO.printMessage(client.getName() + " has an issue");
        IO.printMessage(client.getIssue() + " is being solved!");
        return true;
    }
}
