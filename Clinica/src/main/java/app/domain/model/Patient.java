package app.domain.model;

public class Patient {
    private long id;
    private String name;
    private int age;
    private String medicalRecord;
    private Role role;

    public Patient(long id, String name, int age, String healthRecord, Role role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.medicalRecord = healthRecord;
        this.role = role;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getMedicalRecord(){
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord){
        this.medicalRecord = medicalRecord;
    }

    public Role getRole(){
        return role;
    }

    public void setRole (Role role){
        this.role = role;
    }
}
