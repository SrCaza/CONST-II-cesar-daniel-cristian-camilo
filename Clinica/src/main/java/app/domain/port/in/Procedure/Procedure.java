package app.domain.port.in.Procedure;

import app.domain.valueobject.Id;

public class Procedure {
    private Id id;
    private String name;
    private String description;
    private double cost;

    public Procedure(Id id, String name, String description, double cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public Id getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getCost() { return cost; }

    public void updateInfo(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }
}
