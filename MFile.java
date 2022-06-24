import java.util.ArrayList;
import java.io.*;
import java.util.Date;

public class MFile {
    private static final String patientPath = "G:\\file\\patients.txt";
    private static final String doctorPath = "G:\\file\\doctors.txt";
    private static final String drugPath = "G:\\file\\drugs.txt";
    private static final String visitPath = "G:\\file\\visits.txt";
    private static final String messagePath = "G:\\file\\messages.txt";
    private static final String tempPath = "G:\\file\\temporary.txt";
    //public static ArrayList<Person> persons = new ArrayList<>();
    public static ArrayList<Patient> patients = new ArrayList<>();
    public static ArrayList<Doctor> doctors = new ArrayList<>();
    public static ArrayList<Drug> drugs = new ArrayList<>();
    public static ArrayList<Visit> visits = new ArrayList<>();
    public static ArrayList<Message> messages = new ArrayList<>();

    public static void save(Patient patient) {
        patients.add(patient);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(patientPath, true))) {
            String file = patient.toString();
            bufferedWriter.write(file);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Looks like we have a problem here!!");
        }
    }

    public static void save(Drug drug) {
        drugs.add(drug);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(drugPath, true))) {
            String file = drug.toString();
            bufferedWriter.write(file);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Looks like we have a problem here!!");
        }
    }

    public static void save(Visit visit) {
        visits.add(visit);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(visitPath, true))) {
            String file = visit.toString();
            bufferedWriter.write(file);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Looks like we have a problem here!!");
        }
    }

    public static void save(Message message) {
        messages.add(message);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(messagePath, true))) {
            String file = message.toString();
            bufferedWriter.write(file);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Looks like we have a problem here!!");
        }
    }

    public static void save(Doctor doctor) {
        doctors.add(doctor);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(doctorPath, true))) {
            String file = doctor.toString();
            bufferedWriter.write(file);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Looks like we have a problem here!!");
        }
    }

    public static void remove(Patient patient) {
        try {
            File inputFile = new File(patientPath);
            File tempFile = new File(tempPath);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String RemoveLine = patient.toString();
            String cLine;

            while ((cLine = reader.readLine()) != null) {
                String trimmedLine = cLine.trim();
                if (trimmedLine.equals(RemoveLine))
                    continue;
                writer.write(cLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            patients.remove(patient);

        } catch (IOException e) {
            System.out.println("Looks like we have a problem here");
        }
    }

    public static void remove(Doctor doctor) {
        try {
            File inputFile = new File(doctorPath);
            File tempFile = new File(tempPath);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String RemoveLine = doctor.toString();
            String cLine;

            while ((cLine = reader.readLine()) != null) {
                String trimmedLine = cLine.trim();
                if (trimmedLine.equals(RemoveLine))
                    continue;
                writer.write(cLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            doctors.remove(doctor);

        } catch (IOException e) {
            System.out.println("Looks like we have a problem here");
        }
    }

    public static void remove(Drug drug) {
        try {
            File inputFile = new File(drugPath);
            File tempFile = new File(tempPath);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String RemoveLine = drug.toString();
            String cLine;

            while ((cLine = reader.readLine()) != null) {
                String trimmedLine = cLine.trim();
                if (trimmedLine.equals(RemoveLine))
                    continue;
                writer.write(cLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            drugs.remove(drug);

        } catch (IOException e) {
            System.out.println("Looks like we have a problem here");
        }
    }

    public static void remove(Visit visit) {
        try {
            File inputFile = new File(visitPath);
            File tempFile = new File(tempPath);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String RemoveLine = visit.toString();
            String cLine;

            while ((cLine = reader.readLine()) != null) {
                String trimmedLine = cLine.trim();
                if (trimmedLine.equals(RemoveLine))
                    continue;
                writer.write(cLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            visits.remove(visit);

        } catch (IOException e) {
            System.out.println("Looks like we have a problem here");
        }
    }

    public static void remove(Message message) {
        try {
            File inputFile = new File(messagePath);
            File tempFile = new File(tempPath);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String RemoveLine = message.toString();
            String cLine;

            while ((cLine = reader.readLine()) != null) {
                String trimmedLine = cLine.trim();
                if (trimmedLine.equals(RemoveLine))
                    continue;
                writer.write(cLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            messages.remove(message);

        } catch (IOException e) {
            System.out.println("Looks like we have a problem here");
        }
    }

    public static void drugLoad() {
        int drId;
        Drug drug;
        String drugName;
        String drugIllness;
        String dCompany;
        String dMDate;
        String dEDate;
        String dDescription;
        String[] array;
        String[] array2;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(drugPath))) {
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                array = line.split(";");
                for (String s : array) {
                    array2 = s.split(",");
                    drId = Integer.parseInt(array2[0]);
                    drugName = array2[1];
                    drugIllness = array2[2];
                    dCompany = array2[3];
                    dMDate = array2[4];
                    dEDate = array2[5];
                    dDescription = array2[6];
                    Drug.DrID = drId;
                    drug = new Drug(drugName, dCompany, drugIllness, dMDate, dEDate, dDescription);
                    drugs.add(drug);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Sorry but unable to find your File");
        } catch (IOException e) {
            System.out.println("Looks like we have a problem here");
        }
    }

    public static void patientLoad() {
        int pid;
        Patient patient;
        String pName;
        int nCode;
        String pIllness;
        String[] array;
        String[] array2;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(patientPath))) {

            for (String line; (line = bufferedReader.readLine()) != null; ) {
                array = line.split(";");
                for (String s : array) {
                    array2 = s.split(",");
                    pid = Integer.parseInt(array2[0]);
                    pName = array2[1];
                    nCode = Integer.parseInt(array2[2]);
                    pIllness = array2[3];
                    Patient.PID = pid;
                    patient = new Patient(pName, nCode, pIllness);
                    patients.add(patient);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Sorry but unable to find your File");
        } catch (IOException e) {
            System.out.println("Looks like we have a problem here");
        }
    }

    public static void doctorLoad() {
        int did;
        Doctor doctor;
        String dName;
        int nCode;
        String dSpecialty;
        int dMedicalCode;
        String[] array;
        String[] array2;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(doctorPath))) {
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                array = line.split(";");
                for (String s : array) {
                    array2 = s.split(",");
                    did = Integer.parseInt(array2[0]);
                    dName = array2[1];
                    nCode = Integer.parseInt(array2[2]);
                    dSpecialty = array2[3];
                    dMedicalCode = Integer.parseInt(array2[4]);
                    Doctor.DID = did;
                    doctor = new Doctor(dName, nCode, dMedicalCode, dSpecialty);
                    doctors.add(doctor);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Sorry but unable to find your File");
        } catch (IOException e) {
            System.out.println("Looks like we have a problem here");
        }
    }

    public static void messageLoad() {
        int mid;
        Message message;
        Patient mPatient = null;
        Doctor mDoctor = null;
        String mSubject;
        String mDate;
        boolean mVisited;
        String[] array;
        String[] array2;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(messagePath))) {
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                array = line.split(";");
                for (String s : array) {
                    array2 = s.split(",");
                    mid = Integer.parseInt(array2[0]);
                    for (Doctor d : MFile.doctors) {
                        if (array2[1].equals(d.name)) {
                            mDoctor = d;
                        }
                    }
                    for (Patient p : MFile.patients) {
                        if (array2[2].equals(p.name)) {
                            mPatient = p;
                        }
                    }
                    mSubject = array2[3];
                    mDate = array2[4];
                    mVisited = Boolean.parseBoolean(array2[5]);
                    Message.MID = mid;
                    message = new Message(mDoctor, mPatient, mSubject, mDate, mVisited);
                    messages.add(message);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Sorry but unable to find your File");
        } catch (IOException e) {
            System.out.println("Looks like we have a problem here");
        }
    }

    public static void visitLoad() {
        int vid;
        Visit visit;
        Patient vPatient = null;
        Doctor vDoctor = null;
        Drug vDrug = null;
        String vDate;
        String[] array;
        String[] array2;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(doctorPath))) {
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                array = line.split(";");
                for (String s : array) {
                    array2 = s.split(",");
                    vid = Integer.parseInt(array2[0]);
                    for (Doctor d : MFile.doctors) {
                        if (array2[1].equals(d.name)) {
                            vDoctor = d;
                        }
                    }
                    for (Patient p : MFile.patients) {
                        if (array2[2].equals(p.name)) {
                            vPatient = p;
                        }
                    }
                    for (Drug d : MFile.drugs) {
                        if (array2[3].equals(d.drugName)) {
                            vDrug = d;
                        }
                    }
                    vDate =array2[4];
                    Visit.VID = vid;
                    visit = new Visit(vDoctor, vPatient, vDrug, vDate);
                    visits.add(visit);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Sorry but unable to find your File");
        } catch (IOException e) {
            System.out.println("Looks like we have a problem here");
        }
    }

    public static void showPatients() {

        for (Patient patient : MFile.patients) {

            System.out.println(patient.toString());
        }
    }

    public static void showDoctors() {

        for (Doctor doctor : MFile.doctors) {
            System.out.println(doctor.toString());
        }
    }

    public static void showDrugs() {
        for (Drug drug : drugs) {
            System.out.println(drug.toString());
        }
    }

    public static void showVisits() {
        for (Visit visit : visits) {
            System.out.println(visit.toString());
        }
    }

    public static void showMessages() {
        for (Message message : messages) {
            System.out.println(message.toString());
        }
    }

    public static Patient getPatient(int nCode) {
        Patient patient = null;
        for (Patient p : patients) {
            if (p.nationalCode == nCode) {
                patient = p;
                break;
            }
        }
        return patient;
    }

    public static Doctor getDoctor(int nCode) {
        Doctor doctor = null;
        for (Doctor d : doctors) {
            if (d.nationalCode == nCode) {
                doctor = d;
                break;
            }
        }
        return doctor;
    }

    public static Visit getVisit(int pCode) {
        Visit visit = null;
        for (Visit v : visits) {
            if (v.getPatient().getNationalCode() == pCode) {
                visit = v;
                break;
            }
        }
        return visit;
    }

    public static Drug getDrug(String name) {
        Drug drug = null;
        for (Drug d : drugs) {
            if (d.drugName.equals(name)) {
                drug = d;
                break;
            }
        }
        return drug;
    }

    public static Message getMessage(int pCode) {
        Message message = null;
        for (Message m : messages) {
            if (m.getPatient().getNationalCode() == pCode) {
                message = m;
                break;
            }
        }
        return message;
    }

    public static void EpN(Patient patient, String name) {
        try {
            String oldLine = patient.toString();
            patient.setName(name);
            String newLine = patient.toString();
            BufferedReader reader = new BufferedReader(new FileReader(patientPath));
            String line = reader.readLine();
            StringBuffer buffer = new StringBuffer();
            while (line != null) {
                buffer.append(line + System.lineSeparator());
                line = reader.readLine();
            }
            String content = buffer.toString();
            content = content.replaceAll(oldLine, newLine);
            FileWriter writer = new FileWriter(patientPath);
            writer.append(content);
            writer.close();
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void EdrN(Drug drug , String name){
        try {
            String oldLine = drug.toString();
            drug.setDrugName(name);
            String newLine = drug.toString();
            BufferedReader reader = new BufferedReader(new FileReader(drugPath));
            String line = reader.readLine();
            StringBuffer buffer = new StringBuffer();
            while (line != null) {
                buffer.append(line + System.lineSeparator());
                line = reader.readLine();
            }
            String content = buffer.toString();
            content = content.replaceAll(oldLine, newLine);
            FileWriter writer = new FileWriter(drugPath);
            writer.append(content);
            writer.close();
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void EdName(Doctor doctor , String name){
        try {
            String oldLine = doctor.toString();
            doctor.setName(name);
            String newLine = doctor.toString();
            BufferedReader reader = new BufferedReader(new FileReader(doctorPath));
            String line = reader.readLine();
            StringBuffer buffer = new StringBuffer();
            while (line != null) {
                buffer.append(line + System.lineSeparator());
                line = reader.readLine();
            }
            String content = buffer.toString();
            content = content.replaceAll(oldLine, newLine);
            FileWriter writer = new FileWriter(doctorPath);
            writer.append(content);
            writer.close();
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void EdSpecialty(Doctor doctor , String specialty){
        try {
            String oldLine = doctor.toString();
            doctor.setSpecialty(specialty);
            String newLine = doctor.toString();
            BufferedReader reader = new BufferedReader(new FileReader(doctorPath));
            String line = reader.readLine();
            StringBuffer buffer = new StringBuffer();
            while (line != null) {
                buffer.append(line + System.lineSeparator());
                line = reader.readLine();
            }
            String content = buffer.toString();
            content = content.replaceAll(oldLine, newLine);
            FileWriter writer = new FileWriter(doctorPath);
            writer.append(content);
            writer.close();
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


