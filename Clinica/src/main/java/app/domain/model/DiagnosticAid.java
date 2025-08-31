package app.domain.model;

import app.domain.valueobject.Id;

public class DiagnosticAid {
    private Id id;
    private String name;
    private String description;
    private boolean available;

    public DiagnosticAid(Id id, String name, String description, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.available = available;
    }

    public Id getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isAvailable() { return available; }

    public void updateInfo(String name, String description, boolean available) {
        this.name = name;
        this.description = description;
        this.available = available;
    }
}
