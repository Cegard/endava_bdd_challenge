package entities;

import java.util.Date;

public class TransactionMessage extends Message {
    private String customerId;
    private String customerEmail;
    private String agentId;
    private String messageType;
    private int accountId;
    private Date transactionDate;
    private Double transactionValue;
    private String transactionType;

    public TransactionMessage(String customerId, String customerEmail, String agentId, String messageType, int accountId, Date transactionDate, Double transactionValue, String transactionType) {
        this.customerId = customerId;
        this.customerEmail = customerEmail;
        this.agentId = agentId;
        this.messageType = messageType;
        this.accountId = accountId;
        this.transactionDate = transactionDate;
        this.transactionValue = transactionValue;
        this.transactionType = transactionType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getAgentId() {
        return agentId;
    }

    public String getMessageType() {
        return messageType;
    }

    public int getAccountId() {
        return accountId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public Double getTransactionValue() {
        return transactionValue;
    }

    public String getTransactionType() {
        return transactionType;
    }
}
