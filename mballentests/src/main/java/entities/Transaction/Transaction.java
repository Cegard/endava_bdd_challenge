package entities;

import java.util.Date;

public abstract class Transaction {
    protected Client client;
    protected Agent agent;
    protected Date transactionDate;
    protected double transactionValue;
    protected String type;

    public Transaction(Client client, Agent agent, Date transactionDate, double transactionValue, String type) {
        this.client = client;
        this.agent = agent;
        this.transactionDate = transactionDate;
        this.transactionValue = transactionValue;
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(double transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract boolean attend(Client client);
}
