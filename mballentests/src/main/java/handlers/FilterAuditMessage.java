package handlers;

import entities.TransactionMessage;

public class FilterAuditMessage extends AuditChain {
    public void handleMessage(TransactionMessage transactionMessage) {
        if(transactionMessage.getTransactionType().equals("deposit") && transactionMessage.getTransactionValue() > 1000) {
            if(this.auditChain != null) {
                this.auditChain.handleMessage(transactionMessage);
            }
        }
    }
}
