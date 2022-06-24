import java.util.Date;

public class Visit {
    static int VID = 1;
    protected int vid;
    protected Doctor doctor;
    protected Patient patient;
    protected Drug drug;
    protected String date;
    public Visit(Doctor doctor){
        this.doctor=doctor;
        this.vid = VID;
        VID++;
    }
    public Visit(Doctor doctor,Patient patient){
        this.doctor=doctor;
        this.patient=patient;
        this.vid = VID;
        VID++;
    }
    public Visit(Doctor doctor,Patient patient,Drug drug){
        this.doctor=doctor;
        this.patient=patient;
        this.drug=drug;
        this.vid = VID;
        VID++;
    }
    public Visit(Doctor doctor,Patient patient,Drug drug,String date){
        this.doctor=doctor;
        this.patient=patient;
        this.drug=drug;
        this.date=date;
        this.vid = VID;
        VID++;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String toString(){
        return vid + ":" + doctor + "/" + patient + "/" + drug + "/" + date;
    }
    public void save(){
        MFile.save(this);
    }
    public void remove(){
        MFile.remove(this);
    }
}
