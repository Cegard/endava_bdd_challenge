package systems;

import entities.Message;
import utils.TransactionMessageAdapter;

import java.util.ArrayList;

public class TransactionsSubject extends Subject {
    public TransactionsSubject() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers(Message message) {
        for(Observer observer : this.observers) {
            observer.update(TransactionMessageAdapter.getTransactionMessage(message));
        }
    }
}
