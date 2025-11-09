package app.domain.model;

import app.domain.valueobject.Id;
import java.time.LocalDate;

public class Order {
	private String medicine;
	private String doce;
	private String type;
	private String name;
	private double cost;
	private String details;
	private LocalDate date;
	private Long id;
	private Id patientId;
	private User owner;
	private User doctor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Id getPatientId() {
		return patientId;
	}

	public void setPatientId(Id patientId) {
		this.patientId = patientId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getDoce() {
		return doce;
	}

	public void setDoce(String doce) {
		this.doce = doce;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
