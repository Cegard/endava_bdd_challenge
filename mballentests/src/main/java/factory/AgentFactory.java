package factory;

import entities.Cashier;
import entities.Supervisor;
import entities.Director;
import entities.Agent;
import interfaces.AgentInterface;

import java.util.HashMap;
import java.util.Map;

public class AgentFactory {
    private Map<String, AgentInterface> mapa = new HashMap<String, AgentInterface>();

    public AgentFactory() {
        this.addOperations();
    }

    public void addOperations() {
        this.mapa.put("cashier", (name, id) -> new Cashier(name, id, "cashier", 1));
        this.mapa.put("supervisor", (name, id) -> new Supervisor(name, id, "supervisor", 2));
        this.mapa.put("director", (name, id) -> new Director(name, id, "director", 3));
    }

    public Agent buildAgent(String name, String id, String type){
        return this.mapa.get(type).build(name, id);
    }
}
