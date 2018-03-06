package entities;

public abstract class Agent {
    protected String name;
    protected String id;
    protected String agentType;
    protected int priority;

    public Agent(String name, String id, String agentType, int priority) {
        this.name = name;
        this.id = id;
        this.agentType = agentType;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
