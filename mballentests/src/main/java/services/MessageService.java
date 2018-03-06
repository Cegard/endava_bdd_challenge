package services;

import entities.Message;
import systems.AuditModule;
import systems.Marketing;
import systems.TransactionsSubject;

public class MessageService {
    private TransactionsSubject transactionsSubject;
    private AuditModule auditModule;
    private Marketing marketing;
    private static MessageService messageService = null;

    public static MessageService getMessageService(){
        if(messageService == null){
            messageService = new MessageService();
        }
        return messageService;
    }
    public MessageService(){
        this.transactionsSubject = new TransactionsSubject();
        this.auditModule = new AuditModule();
        this.marketing = new Marketing();
        this.transactionsSubject.addObserver(this.auditModule);
        this.transactionsSubject.addObserver(this.marketing);
    }

    public void sendMessage(Message message){
        this.transactionsSubject.notifyObservers(message);
    }
}
