package handlers;

import entities.TransactionMessage;
import utils.IO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WriteAuditMessage extends AuditChain {
    public void handleMessage(TransactionMessage transactionMessage) {
        String content = getContent(transactionMessage);
        writeMessage(content);
        if(this.auditChain != null) {
            this.auditChain.handleMessage(transactionMessage);
        }
    }

    public String getContent(TransactionMessage transactionMessage) {
        String content = transactionMessage.getCustomerId() + ", " + transactionMessage.getAccountId() + ", " + transactionMessage.getTransactionValue() + "\n";
        return content;
    }

    public String getCurrentDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYYMMD");
        LocalDate localDate = LocalDate.now();
        return dateTimeFormatter.format(localDate);
    }

    public void writeMessage(String content) {
        IO.writeStringInFile(System.getProperty("user.dir") + "/resources/DEPOSITSTOREVIEW-" + getCurrentDate() + ".txt", content);
    }
}
