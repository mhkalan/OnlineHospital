public class Doctor extends Person{
    static int DID = 1;
    protected int did;
    protected String specialty;
    protected int medicalCode;
    public Doctor(String name,int nationalCode,int medicalCode){
        super(name,nationalCode);
        this.medicalCode=medicalCode;
        this.did = DID;
        DID++;
    }
    public Doctor(String name,int nationalCode,String specialty){
        super(name,nationalCode);
        this.specialty=specialty;
        this.did = DID;
        DID++;
    }
    public Doctor(String name,int nationalCode,int medicalCode,String specialty){
        super(name,nationalCode);
        this.medicalCode=medicalCode;
        this.specialty=specialty;
        this.did = DID;
        DID++;
    }

    public Doctor(String name, int nationalCode){
        super(name,nationalCode);
        this.did = DID;
        DID++;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(int medicalCode) {
        this.medicalCode = medicalCode;
    }
    public String toString(){
        return did + "." + name + "," + nationalCode + "," + specialty + "," + medicalCode;
    }
    public void save(){
        MFile.save(this);
    }
    public void remove(){
        MFile.remove(this);
    }
    public void show(){
        System.out.println(toString());
    }
}
