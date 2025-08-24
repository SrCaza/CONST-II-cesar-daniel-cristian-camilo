package app.domain.model;

public class MedicalRecord {
    private long id;
    private long patientId;
    private String diagnosis;
    private String treatment;
    private String doctorNotes;

    public MedicalRecord(long id, long patientId, String diagnosis, String treatment, String doctorNotes){
        this.id = id;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.doctorNotes = doctorNotes;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getPatientId(){
        return patientId;
    }

    public void setPatientId(long patientId){
        this.patientId = patientId;
    }

    public String getDiagnosis(){
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis){
        this.diagnosis = diagnosis;
    }

    public String getTreatment(){
        return treatment;
    }

    public void setTreatment(String treatment){
        this.treatment = treatment;
    }

    public String getDoctorNotes(){
        return doctorNotes;
    }

    public void setDoctorNotes(String doctorNotes){
        this.doctorNotes = doctorNotes;
    }
}
