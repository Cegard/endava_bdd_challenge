package entities;


import utils.IO;
import utils.Utils;

import java.util.function.Supplier;

public class TransactionSupplier implements Supplier<Transaction> {
    private Transaction transaction;
    private long timeSleep;

    public TransactionSupplier(Transaction transaction) {
        this.transaction = transaction;
    }

    public Transaction get() {
        try {
            this.timeSleep = (Utils.getRandom().nextInt(5) + 10) * 1000;
            Thread.sleep(this.timeSleep);
            IO.printMessage("Client " + this.transaction.getClient().getName() + " was attended by " + this.transaction.getAgent().getName() + " (" + transaction.getAgent().getAgentType() + ")" + " in: " + ((timeSleep) * 0.001) + " seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return transaction;
    }
}
