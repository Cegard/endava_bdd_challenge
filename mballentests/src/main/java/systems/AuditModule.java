package systems;

import entities.Message;
import entities.TransactionMessage;
import handlers.AuditChain;
import handlers.FilterAuditMessage;
import handlers.WriteAuditMessage;
import utils.TransactionMessageAdapter;

public class AuditModule extends Observer {
    AuditChain auditChainOne;
    AuditChain auditChainTwo;

    public void setChainOfResponsibility() {
        auditChainOne = new FilterAuditMessage();
        auditChainTwo = new WriteAuditMessage();
        auditChainOne.setNextChain(auditChainTwo);
    }

    public void update(Message message) {
        TransactionMessage transactionMessage = TransactionMessageAdapter.getTransactionMessage(message);
        this.setChainOfResponsibility();
        auditChainOne.handleMessage(transactionMessage);
    }
}
