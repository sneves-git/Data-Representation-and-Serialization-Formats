import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Input {

    //private int set_1_students = 10, set_2_students = 1.000, set_3_students = 10.000;
    //private int set_1_professors = 10, set_2_professors = 100, set_3_professors = 1.000;


    private int set_1_students = 2, set_2_students = 4, set_3_students = 6;
    private int set_1_professors = 1, set_2_professors = 2, set_3_professors = 3;

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

        generateInput();
    }
    
    public void generateInput() throws IOException {


        // ---- Students-----
        String str = Files.readString(Path.of("src\\main\\java\\StudentNames.txt"));
        String[] arrOfStr = str.split(",");
        System.out.println(arrOfStr);
        String strAddress = Files.readString(Path.of("src\\main\\java\\StudentAddress.txt"));
        String[] arrOfStrAddress = strAddress.split(",");
        System.out.println(arrOfStrAddress);

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
        String strProf = Files.readString(Path.of("src\\main\\java\\ProfessorNames.txt"));
        String[] arrOfStrProf = strProf.split(",");
        System.out.println(arrOfStrProf);

        String strAddressProf = Files.readString(Path.of("src\\main\\java\\ProfessorAddress.txt"));
        String[] arrOfStrAddressProf = strAddressProf.split(",");
        System.out.println(arrOfStrAddressProf);
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
}
