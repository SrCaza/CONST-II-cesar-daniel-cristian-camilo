package app.domain.model;

import app.domain.valueobject.Id;
import java.time.LocalDate;
import java.util.List;

public class Invoice {
    private final Id id;
    private final Id patientId;
    private final List<Order> orders;
    private final double patientCopay;
    private final double insurerAmount;
    private final LocalDate date;

    public Invoice(Id id, Id patientId, List<Order> orders, double patientCopay, double insurerAmount, LocalDate date) {
        this.id = id;
        this.patientId = patientId;
        this.orders = orders;
        this.patientCopay = patientCopay;
        this.insurerAmount = insurerAmount;
        this.date = date;
    }

    public Id getId() { return id; }
    public Id getPatientId() { return patientId; }
    public List<Order> getOrders() { return orders; }
    public double getPatientCopay() { return patientCopay; }
    public double getInsurerAmount() { return insurerAmount; }
    public LocalDate getDate() { return date; }
}
