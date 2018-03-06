package interfaces;

import entities.Cashier;
import entities.Agent;

public interface AgentInterface {
    Agent build(String name, String id);
}
