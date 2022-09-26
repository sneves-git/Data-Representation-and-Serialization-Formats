import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Input {

    //private int set_1_students = 10, set_2_students = 1.000, set_3_students = 10.000;
    //private int set_1_professors = 10, set_2_professors = 100, set_3_professors = 1.000;


    private int set_1_students, set_2_students, set_3_students;
    private int set_1_professors, set_2_professors, set_3_professors;

    // ---- set 1 ------
    private ArrayList<Student> studentNames_set1;
    private ArrayList<Professor> professorNames_set1;

    // ---- set 2 ------
     private ArrayList<Student> studentNames_set2;
     private ArrayList<Professor> professorNames_set2;

    // ---- set 3 ------
    private ArrayList<Student> studentNames_set3;
    private ArrayList<Professor> professorNames_set3;

    public Input() throws IOException {
        studentNames_set1 = new ArrayList<>();
        professorNames_set1 = new ArrayList<>();
        
        studentNames_set2 = new ArrayList<>();
        professorNames_set2 = new ArrayList<>();

        studentNames_set3 = new ArrayList<>();
        professorNames_set3 = new ArrayList<>();

    }

    public Input(int type, int a, int b, int c, int d, int e, int f) throws IOException {
        studentNames_set1 = new ArrayList<>();
        professorNames_set1 = new ArrayList<>();
        
        studentNames_set2 = new ArrayList<>();
        professorNames_set2 = new ArrayList<>();

        studentNames_set3 = new ArrayList<>();
        professorNames_set3 = new ArrayList<>();
      

        set_1_students = a;
        set_2_students = b;
        set_3_students = c;
        set_1_professors = d; 
        set_2_professors = e;
        set_3_professors = f;


        if(type == 1){
            generateRandomInput();
        }else if(type == 2){
            generateInputWithTheSameLetter();
        }
    }

    
    public void generateRandomInput() throws IOException {


        // ---- Students-----
        String str = Files.readString(Path.of("src\\main\\java\\files\\StudentNames.txt"));
        String[] arrOfStr = str.split(",");
        String strAddress = Files.readString(Path.of("src\\main\\java\\files\\StudentAddress.txt"));
        String[] arrOfStrAddress = strAddress.split(",");

        for (int i = 0; i < set_3_students; i++) {
            String birthDate = generateRandomDate();
            String registrationDate = generateRandomDate();

            long telephone = generateRandomTelephone();
            Student student = new Student(i+1, arrOfStr[i], telephone, generateGender(), birthDate, registrationDate, arrOfStrAddress[i]+generateAddressType());

            if (i < set_1_students) {
                studentNames_set1.add(student);
            }

            if (i < set_2_students) {
                studentNames_set2.add(student);
            }

            studentNames_set3.add(student);
        }

        // ---- Professors-----
        String strProf = Files.readString(Path.of("src\\main\\java\\files\\ProfessorNames.txt"));
        String[] arrOfStrProf = strProf.split(",");

        String strAddressProf = Files.readString(Path.of("src\\main\\java\\files\\ProfessorAddress.txt"));
        String[] arrOfStrAddressProf = strAddressProf.split(",");
        int numberOfStudents = set_1_students / set_1_professors;

        for (int i = 0; i < set_3_professors; i++) {
            long telephone = generateRandomTelephone();
            String birthDate = generateRandomDate();

            Professor p = new Professor(i+1, arrOfStrProf[i], telephone, birthDate, arrOfStrAddressProf[i]+generateAddressType());

            for (int j = i * numberOfStudents; j < i * numberOfStudents + numberOfStudents; ++j) {
                p.AddStudent(studentNames_set3.get(j));
            }

            if (i < set_1_professors) {
                professorNames_set1.add(p);
            }
            if (i < set_2_professors) {
                professorNames_set2.add(p);
            }
            professorNames_set3.add(p);

        }


    }

    public void generateInputWithTheSameLetter() throws IOException{
        generateRandomInput();
        for(int i = 0; i < set_3_students; ++i){
            String name = studentNames_set3.get(i).getName();
            String address = studentNames_set3.get(i).getAddress();

            if (i < set_1_students) {
                studentNames_set1.get(i).setName("a".repeat(name.length()));
                studentNames_set1.get(i).setAddress("a".repeat(address.length()));
            }

            if (i < set_2_students) {
                studentNames_set2.get(i).setName("a".repeat(name.length()));
                studentNames_set2.get(i).setAddress("a".repeat(address.length()));

            }
            studentNames_set3.get(i).setName("a".repeat(name.length()));
            studentNames_set3.get(i).setAddress("a".repeat(address.length()));

        }


        for(int i = 0; i < set_3_professors; ++i){
            String name = professorNames_set3.get(i).getName();
            String address = professorNames_set3.get(i).getAddress();

            if (i < set_1_professors) {
                professorNames_set1.get(i).setName("a".repeat(name.length()));
                professorNames_set1.get(i).setAddress("a".repeat(address.length()));

            }

            if (i < set_2_professors) {
                professorNames_set2.get(i).setName("a".repeat(name.length()));
                professorNames_set2.get(i).setAddress("a".repeat(address.length()));

            }
            professorNames_set3.get(i).setName("a".repeat(name.length()));
            professorNames_set3.get(i).setAddress("a".repeat(address.length()));

        }
    }

    public String generateRandomDate(){
        int day = (int)Math.floor(Math.random()*(30-1+1)+1);
        int month = (int)Math.floor(Math.random()*(12-1+1)+1);
        int year = (int)Math.floor(Math.random()*(2022-1900+1)+1900);
        String Date = Integer.toString(day) + "-" +Integer.toString(month) + "-" +Integer.toString(year);
        return Date;
    }

    public long generateRandomTelephone(){
        long telephone = 0;
        Random rand = new Random();

        for(int j = 0; j < 9; ++j){
            int int_random = rand.nextInt(10);
            telephone = telephone *10 + int_random;
        }
        return telephone;
    }

    public String generateAddressType(){
        String[] types = new String[]{" Rue", " Route", " Avenue", " Street", " Road", " Lane", " Court", " Drive"};
        Random rand = new Random();
        int int_random = rand.nextInt(8);
        return types[int_random];
    }

    public String generateGender(){
        String[] types = new String[]{"Male", "Female", "Non-Binary"};
        Random rand = new Random();
        int int_random = rand.nextInt(3);
        return types[int_random];
    }
    public ArrayList<Student> getStudentNames_set1() {
        return studentNames_set1;
    }

    public void setStudentNames_set1(ArrayList<Student> studentNames_set1) {
        this.studentNames_set1 = studentNames_set1;
    }

    public ArrayList<Professor> getProfessorNames_set1() {
        return professorNames_set1;
    }

    public void setProfessorNames_set1(ArrayList<Professor> professorNames_set1) {
        this.professorNames_set1 = professorNames_set1;
    }

    public ArrayList<Student> getStudentNames_set2() {
        return studentNames_set2;
    }

    public void setStudentNames_set2(ArrayList<Student> studentNames_set2) {
        this.studentNames_set2 = studentNames_set2;
    }

    public ArrayList<Professor> getProfessorNames_set2() {
        return professorNames_set2;
    }

    public void setProfessorNames_set2(ArrayList<Professor> professorNames_set2) {
        this.professorNames_set2 = professorNames_set2;
    }

    public ArrayList<Student> getStudentNames_set3() {
        return studentNames_set3;
    }

    public void setStudentNames_set3(ArrayList<Student> studentNames_set3) {
        this.studentNames_set3 = studentNames_set3;
    }

    public ArrayList<Professor> getProfessorNames_set3() {
        return professorNames_set3;
    }

    public void setProfessorNames_set3(ArrayList<Professor> professorNames_set3) {
        this.professorNames_set3 = professorNames_set3;
    }

    public int getSet_1_students() {
        return set_1_students;
    }

    public void setSet_1_students(int set_1_students) {
        this.set_1_students = set_1_students;
    }

    public int getSet_2_students() {
        return set_2_students;
    }

    public void setSet_2_students(int set_2_students) {
        this.set_2_students = set_2_students;
    }

    public int getSet_3_students() {
        return set_3_students;
    }

    public void setSet_3_students(int set_3_students) {
        this.set_3_students = set_3_students;
    }

    public int getSet_1_professors() {
        return set_1_professors;
    }

    public void setSet_1_professors(int set_1_professors) {
        this.set_1_professors = set_1_professors;
    }

    public int getSet_2_professors() {
        return set_2_professors;
    }

    public void setSet_2_professors(int set_2_professors) {
        this.set_2_professors = set_2_professors;
    }

    public int getSet_3_professors() {
        return set_3_professors;
    }

    public void setSet_3_professors(int set_3_professors) {
        this.set_3_professors = set_3_professors;
    }
}
