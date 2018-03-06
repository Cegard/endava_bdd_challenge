package interfaces;

import entities.Message;

import java.util.Date;

public interface MessageInterface {
    Message build(String customerID, String customerEmail, String agentID, String messageType, int accountID, Date transactionDate, double transactionValue, String transactionType);
}
