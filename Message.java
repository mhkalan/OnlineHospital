public class Message {
    static int MID = 1;
    protected int mid;
    protected Doctor doctor;
    protected Patient patient;
    protected String subject;
    protected String date;
    protected boolean visited;
    public Message(Doctor doctor){
        this.doctor=doctor;
        this.mid = MID;
        MID++;
    }
    public Message(Doctor doctor,Patient patient){
        this.doctor=doctor;
        this.patient=patient;
        this.mid = MID;
        MID++;
    }
    public Message(Doctor doctor,Patient patient,String subject){
        this.doctor=doctor;
        this.patient=patient;
        this.subject=subject;
        this.mid = MID;
        MID++;
    }

    public Message(Doctor doctor,Patient patient,String subject,String date){
        this.doctor=doctor;
        this.patient=patient;
        this.subject=subject;
        this.date=date;
        this.mid = MID;
        MID++;
    }

    public Message(Doctor doctor,Patient patient,String subject,String date,boolean visited){
        this.doctor=doctor;
        this.patient=patient;
        this.subject=subject;
        this.date=date;
        this.visited=visited;
        this.mid = MID;
        MID++;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String toString(){
        return mid + ":" + doctor + "/" + patient + "/" + subject + "," + date + "," + visited;
    }
    public void save(){
        MFile.save(this);
    }
    public void remove(){
        MFile.remove(this);
    }
}
