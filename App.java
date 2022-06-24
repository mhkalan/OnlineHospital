import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class App {
    public static void addPatient(){
        try {
            Scanner inputName = new Scanner(System.in);
            Scanner inputNum = new Scanner(System.in);
            String name, illness;
            int nCode;
            System.out.println("Please enter the Patient's Name");
            name = inputName.nextLine();
            System.out.println("Please enter the Patient's National code");
            nCode = inputNum.nextInt();
            System.out.println("Please enter the Patient's Illness");
            illness = inputName.nextLine();
            Patient patient = new Patient(name, nCode, illness);
            patient.save();
        }        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void addDoctor(){
        try{
        Scanner inputName = new Scanner(System.in);
        Scanner inputNum = new Scanner(System.in);
        String name , specialty;
        int nCode,mCode;
        System.out.println("Please enter the Doctor's Name");
        name = inputName.nextLine();
        System.out.println("Please enter the Doctor's National code");
        nCode = inputNum.nextInt();
        System.out.println("Please enter the Doctor's Medical code");
        mCode = inputNum.nextInt();
        System.out.println("Please enter the Doctor's Specialty");
        specialty = inputName.nextLine();
        Doctor doctor = new Doctor(name,nCode,mCode,specialty);
        doctor.save();}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void addDrug(){
        try {
        Scanner inputName = new Scanner(System.in);
        String drugName,company,drugIllness,description,mDate,eDate;
        System.out.println("Please enter the Drug's Name");
        drugName = inputName.nextLine();
        System.out.println("Please enter the Drug's Illness");
        drugIllness = inputName.nextLine();
        System.out.println("Please enter the Drug's Company Name");
        company = inputName.nextLine();
        System.out.println("Please enter the Drug's Make Date");
        mDate = inputName.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateInString = mDate;
        Date date = sdf.parse(dateInString);
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = newFormat.format(date);
        System.out.println("please enter the Drug's Expire Date");
        eDate = inputName.nextLine();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        String dateInString1 = eDate;
        Date date1 = sdf1.parse(dateInString1);
        SimpleDateFormat newFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate1 = newFormat1.format(date1);
        System.out.println("Please enter the Drug's Description");
        description = inputName.nextLine();
        Drug drug = new Drug(drugName,company,drugIllness,formatDate,formatDate1,description);
        drug.save();}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void addVisit(){
        try{
        Scanner inputName = new Scanner(System.in);
        Scanner inputNum = new Scanner(System.in);
        int patientCode,doctorCode;
        String drugName , value;
        System.out.println("Please enter the Patient's National Code");
        patientCode = inputNum.nextInt();
        System.out.println("Please enter the Date of your Visit");
        value = inputName.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateInString = value;
        Date date = sdf.parse(dateInString);
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = newFormat.format(date);
        System.out.println("Please enter the Doctor's National Code");
        doctorCode = inputNum.nextInt();
        System.out.println("PLease enter the Drug's Name");
        drugName = inputName.nextLine();
        Patient patient = MFile.getPatient(patientCode);
        Doctor doctor = MFile.getDoctor(doctorCode);
        Drug drug = MFile.getDrug(drugName);
        Visit visit =new Visit(doctor,patient,drug,formatDate);
        visit.save();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void addMessage(){
        try{
        Scanner inputNum =new Scanner(System.in);
        Scanner inputName =new Scanner(System.in);
        int patientCode;
        String subject;
        int doctorCode;
        String value;
        String visited;
        System.out.println("Please enter Patient's Subject");
        subject=inputName.nextLine();
        System.out.println("Please enter Patient's National Code");
        patientCode=inputNum.nextInt();
        System.out.println("Please enter Doctor's National code");
        doctorCode = inputNum.nextInt();
        System.out.println("Please enter Message's Date");
        value=inputName.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateInString = value;
        Date date = sdf.parse(dateInString);
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = newFormat.format(date);
        System.out.println("Did you have a appointment before?");
        visited=inputName.nextLine();
        Boolean b = visited.equalsIgnoreCase("yes")|| visited.equalsIgnoreCase("y")|| visited.equalsIgnoreCase("yep");
        Doctor doctor = MFile.getDoctor(doctorCode);
        Patient patient = MFile.getPatient(patientCode);
        Message message =new Message(doctor,patient,subject,formatDate,b);
        message.save();}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void removePatient(){
        try {
            Scanner input = new Scanner(System.in);
            int nCode;
            System.out.println("Please enter the patient's national code");
            nCode=input.nextInt();
            Patient patient = MFile.getPatient(nCode);
            Message message = MFile.getMessage(nCode);
            Visit visit = MFile.getVisit(nCode);
            patient.remove();
            visit.remove();
            message.remove();
        }  catch (Exception e){
            System.out.println("Looks like we have a problem here");
        }
    }
    public static void removeDoctor(){
        try {
            Scanner input = new Scanner(System.in);
            int nCode;
            System.out.println("Please enter the Doctor's national code");
            nCode=input.nextInt();
            Doctor doctor = MFile.getDoctor(nCode);
            Visit visit = MFile.getVisit(nCode);
            Message message = MFile.getMessage(nCode);
            doctor.remove();
            visit.remove();
            message.remove();
        }  catch (Exception e){
            System.out.println("Looks like we have a problem here");
        }
    }
    public static void removeDrug(){
        try {
            Scanner input = new Scanner(System.in);
            String  dName;
            System.out.println("Please enter the Drug's name");
            dName=input.nextLine();
            Drug drug = MFile.getDrug(dName);
            drug.remove();
        }  catch (Exception e){
            System.out.println("Looks like we have a problem here");
        }
    }
    public static void removeVisit(){
        try {
            Scanner input = new Scanner(System.in);
            int nCode;
            System.out.println("Please enter the patient's national code");
            nCode=input.nextInt();
            Visit visit = MFile.getVisit(nCode);
            Patient patient = MFile.getPatient(nCode);
            visit.remove();
            patient.remove();
        }  catch (Exception e){
            System.out.println("Looks like we have a problem here");
        }
    }
    public static void removeMessage(){
        try {
            Scanner input = new Scanner(System.in);
            int nCode;
            System.out.println("Please enter the patient's national code");
            nCode=input.nextInt();
            Message message = MFile.getMessage(nCode);
            message.remove();
        }  catch (Exception e){
            System.out.println("Looks like we have a problem here");
        }
    }
    public static void EditMenu() {
        boolean s = true;
        while (s) {
            try {
                Scanner inputNum = new Scanner(System.in);
                System.out.println("**EDIT MENU**");
                System.out.println("Please Select one of items below");
                System.out.println("1.Change Patient's Name");
                System.out.println("2.Change Doctor's Name");
                System.out.println("3.Change Drug's Name");
                System.out.println("4.Change Doctor's Specialty");
                System.out.println("5.Back to main menu");
                System.out.println("6.If you wish to exit");
                int n = inputNum.nextInt();
                switch (n){
                    case 1:
                        EditPName();
                        break;
                    case 2:
                        EditDName();
                        break;
                    case 3:
                        EditDrName();
                        break;
                    case 4:
                        EditDSpecialty();
                        break;
                    case 5:
                        s = false;
                        break;
                    case 6:
                        System.out.println("**Thanks for your Time**");
                        System.out.println("Have a nice day and Good luck");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("You have entered the wrong Number Please reconsider your option");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void EditPName(){
        try {
            Scanner input = new Scanner(System.in);
            Scanner inputName = new Scanner(System.in);
            System.out.println("Please enter the patient's national code");
            int nCode = input.nextInt();
            Patient patient = MFile.getPatient(nCode);
            System.out.println("Please enter the Patient's new Name");
            String name = inputName.nextLine();
            MFile.EpN(patient, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void EditDName(){
        try {
            Scanner input = new Scanner(System.in);
            Scanner inputName = new Scanner(System.in);
            System.out.println("Please enter the Doctor's national code");
            int nCode = input.nextInt();
            Doctor doctor = MFile.getDoctor(nCode);
            System.out.println("Please enter the Doctor's new Name");
            String name = inputName.nextLine();
            MFile.EdName(doctor, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void EditDrName() {
        try {
            Scanner inputName = new Scanner(System.in);
            Scanner inputNewName = new Scanner(System.in);
            System.out.println("Please enter the Drug's name");
            String dName = inputName.nextLine();
            Drug drug = MFile.getDrug(dName);
            System.out.println("Please enter the Drug's new Name");
            String name = inputNewName.nextLine();
            MFile.EdrN(drug, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void EditDSpecialty() {
        try {
            Scanner input = new Scanner(System.in);
            Scanner inputS = new Scanner(System.in);
            System.out.println("Please enter the Doctor's national code");
            int nCode = input.nextInt();
            Doctor doctor = MFile.getDoctor(nCode);
            System.out.println("Please enter the Doctor's new Specialty");
            String specialty = inputS.nextLine();
            MFile.EdSpecialty(doctor, specialty);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void AddMenu() {
        try {
            boolean s = true;
            while (s) {
                Scanner inputNum = new Scanner(System.in);
                System.out.println("**ADD MENU**");
                System.out.println("1.Add your Patient");
                System.out.println("2.Add your Doctor");
                System.out.println("3.Add your Drug");
                System.out.println("4.Add your Visit");
                System.out.println("5.Add your Message");
                System.out.println("6.Back to Main Menu");
                System.out.println("7.If you wish to exit");
                int n = inputNum.nextInt();
                switch (n) {
                    case 1:
                        addPatient();
                        break;
                    case 2:
                        addDoctor();
                        break;
                    case 3:
                        addDrug();
                        break;
                    case 4:
                        addVisit();
                        break;
                    case 5:
                        addMessage();
                        break;
                    case 6:
                        s = false;
                        break;
                        case 7:
                        System.out.println("**Thanks for your Time**");
                        System.out.println("Have a nice day and Good luck");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("You have entered the wrong Number Please reconsider your option");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void RemoveMenu() {
        try {
            boolean s = true;
            while (s) {
                Scanner inputNum = new Scanner(System.in);
                System.out.println("**Remove MENU**");
                System.out.println("1.Remove your Patient");
                System.out.println("2.Remove your Doctor");
                System.out.println("3.Remove your Drug");
                System.out.println("4.Remove your Visit");
                System.out.println("5.Remove your Message");
                System.out.println("6.Back to Main Menu");
                System.out.println("7.If you wish to exit");
                int n = inputNum.nextInt();
                switch (n) {
                    case 1:
                        removePatient();
                        break;
                    case 2:
                        removeDoctor();
                        break;
                    case 3:
                        removeDrug();
                        break;
                    case 4:
                        removeVisit();
                        break;
                    case 5:
                        removeMessage();
                        break;
                    case 6:
                        s = false;
                        break;
                    case 7:
                        System.out.println("**Thanks for your Time**");
                        System.out.println("Have a nice day and Good luck");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("You have entered the wrong Number Please reconsider your option");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void ShowMenu() {
        try {
            boolean s = true;
            while (s) {
                Scanner inputNum = new Scanner(System.in);
                System.out.println("**Show MENU**");
                System.out.println("1.Show your Patients");
                System.out.println("2.Show your Doctors");
                System.out.println("3.Show your Drugs");
                System.out.println("4.Show your Visits");
                System.out.println("5.Show your Messages");
                System.out.println("6.Back to Main Menus");
                System.out.println("7.If you wish to exit");
                int n = inputNum.nextInt();
                switch (n) {
                    case 1:
                        MFile.showPatients();
                        break;
                    case 2:
                        MFile.showDoctors();
                        break;
                    case 3:
                        MFile.showDrugs();
                        break;
                    case 4:
                        MFile.showVisits();
                        break;
                    case 5:
                        MFile.showMessages();
                        break;
                    case 6:
                        s = false;
                        break;
                    case 7:
                        System.out.println("**Thanks for your Time**");
                        System.out.println("Have a nice day and Good luck");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("You have entered the wrong Number Please reconsider your option");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        MFile.patientLoad();
//        MFile.doctorLoad();
//        MFile.drugLoad();
//        MFile.visitLoad();
//        MFile.messageLoad();
        while (true) {
        try {
            Scanner inputNum = new Scanner(System.in);
            System.out.println("**MENU**");
            System.out.println("Please Select one of items below");
            System.out.println("1.Add Menu");
            System.out.println("2.Remove Menu");
            System.out.println("3.Show Menu");
            System.out.println("4.Edit menu");
            System.out.println("5.If you wish to exit");
            int n = inputNum.nextInt();
            switch (n) {
                case 1:
                    AddMenu();
                    break;
                case 2:
                    RemoveMenu();
                    break;
                case 3:
                    ShowMenu();
                    break;
                case 4:
                    EditMenu();
                    break;
                case 5:
                    System.out.println("**Thanks for your Time**");
                    System.out.println("Have a nice day and Good luck");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have entered the wrong Number Please reconsider your option");
                    break;
            }
        }
                catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    }
