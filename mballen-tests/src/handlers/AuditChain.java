package handlers;

import entities.TransactionMessage;

public abstract class AuditChain {
    protected AuditChain auditChain = null;

    public void setNextChain(AuditChain auditChain) {
        this.auditChain = auditChain;
    }

    public abstract void handleMessage(TransactionMessage transactionMessage);
}
