package app.domain.model;

import java.sql.Date;

public class MedicalRecord {
	private long id;
	private long patientId;
	private String diagnosis;
	private String treatment;
	private String doctorNotes;
	private User user;
	private User doctor;
	private Date date;
	private String motive;
	private String Diagnosis;
	private String medicine;
	private String medicalProcedure;
	private String doce;
	private Order order;
	private String vaccinationRecord;
	private String allergies;
	private String proceddureDetail;
	private String symptoms;
	private boolean stat;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getDoctorNotes() {
		return doctorNotes;
	}

	public void setDoctorNotes(String doctorNotes) {
		this.doctorNotes = doctorNotes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMotive() {
		return motive;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getMedicalProcedure() {
		return medicalProcedure;
	}

	public void setMedicalProcedure(String medicalProcedure) {
		this.medicalProcedure = medicalProcedure;
	}

	public String getDoce() {
		return doce;
	}

	public void setDoce(String doce) {
		this.doce = doce;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getVaccinationRecord() {
		return vaccinationRecord;
	}

	public void setVaccinationRecord(String vaccinationRecord) {
		this.vaccinationRecord = vaccinationRecord;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getProceddureDetail() {
		return proceddureDetail;
	}

	public void setProceddureDetail(String proceddureDetail) {
		this.proceddureDetail = proceddureDetail;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public boolean isStat() {
		return stat;
	}

	public void setStat(boolean stat) {
		this.stat = stat;
	}

}