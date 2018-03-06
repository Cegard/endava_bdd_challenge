package systems;

import entities.Message;

import java.util.List;

public abstract class Subject {
    protected List<Observer> observers;

    public abstract void addObserver(Observer observer);

    public abstract void removeObserver(Observer observer);

    public abstract void notifyObservers(Message message);
}
