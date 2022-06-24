public class Patient extends Person{
    static int PID = 1;
    protected int pid;
    protected String illness;
    public Patient(String name, int nationalCode,String illness){
        super(name,nationalCode);
        this.illness=illness;
        this.pid = PID;
        PID++;
    }
    public Patient(String name, int nationalCode){
        super(name,nationalCode);
        this.pid = PID;
        PID++;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String toString(){
        return  pid + "." + name + "," + nationalCode + "," + illness;
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
