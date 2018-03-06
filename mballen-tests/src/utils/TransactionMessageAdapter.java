package utils;

import entities.Message;
import entities.TransactionMessage;

public class TransactionMessageAdapter {
    public static TransactionMessage getTransactionMessage(Message message) {
        TransactionMessage transactionMessage = (TransactionMessage) message;
        return transactionMessage;
    }
}
