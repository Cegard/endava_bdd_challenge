package systems;

import entities.Message;

public abstract class Observer {
    protected Subject subject;

    public abstract void update(Message message);

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
