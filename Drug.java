public class Drug {
    static int DrID = 1;
    protected int drId;
    protected String drugName;
    protected String company;
    protected String drugIllness;
    protected String mDate;
    protected String eDate;
    protected String description;
    public Drug(String drugName){
        this.drugName=drugName;
        this.drId = DrID;
        DrID++;
    }
    public Drug(String drugName,String company){
        this.drugName=drugName;
        this.company=company;
        this.drId = DrID;
        DrID++;
    }
    public Drug(String drugName,String company,String drugIllness){
        this.drugName=drugName;
        this.company=company;
        this.drugIllness=drugIllness;
        this.drId = DrID;
        DrID++;
    }
    public Drug(String drugName,String company,String drugIllness,String mDate){
        this.drugName=drugName;
        this.company=company;
        this.drugIllness=drugIllness;
        this.mDate=mDate;
        this.drId = DrID;
        DrID++;
    }
    public Drug(String drugName,String company,String drugIllness,String mDate,String eDate){
        this.drugName=drugName;
        this.company=company;
        this.drugIllness=drugIllness;
        this.mDate=mDate;
        this.eDate=eDate;
        this.drId = DrID;
        DrID++;
    }
    public Drug(String drugName,String company,String drugIllness,String mDate,String eDate,String description){
        this.drugName=drugName;
        this.company=company;
        this.drugIllness=drugIllness;
        this.mDate=mDate;
        this.eDate=eDate;
        this.description=description;
        this.drId = DrID;
        DrID++;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getDrId() {
        return drId;
    }

    public void setDrId(int drId) {
        this.drId = drId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDrugIllness() {
        return drugIllness;
    }

    public void setDrugIllness(String drugIllness) {
        this.drugIllness = drugIllness;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String toString(){
        return drId + "." + drugName +  "," + drugIllness + "," + company +  "," + mDate + "," + eDate + "," + description;
    }
    public void save(){
        MFile.save(this);
    }
    public void remove(){
        MFile.remove(this);
    }
}
