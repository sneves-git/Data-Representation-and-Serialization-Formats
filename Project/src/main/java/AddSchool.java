import generated.protobuf.classes.School;
import generated.protobuf.classes.Professor;
import generated.protobuf.classes.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class AddSchool {

    static long totalTime = 0;

    public AddSchool() throws IOException {}


    static School PromptForSchool(int type, int numberOfProfessors, int numberOfStudents) throws IOException {
        
        School.Builder school = School.newBuilder();

        // ---- Students-----
        String str = Files.readString(Path.of("src\\main\\java\\files\\StudentNames.txt"));
        String[] arrOfStr = str.split(",");
        String strAddress = Files.readString(Path.of("src\\main\\java\\files\\StudentAddress.txt"));
        String[] arrOfStrAddress = strAddress.split(",");


        // ---- Professors-----
        String strProf = Files.readString(Path.of("src\\main\\java\\files\\ProfessorNames.txt"));
        String[] arrOfStrProf = strProf.split(",");

        String strAddressProf = Files.readString(Path.of("src\\main\\java\\files\\ProfessorAddress.txt"));
        String[] arrOfStrAddressProf = strAddressProf.split(",");
        
        int numberOfProfessorStudents = numberOfStudents / numberOfProfessors;
        long startTime = 0;
        for (int i = 0; i < numberOfProfessors; i++) {

            Professor.Builder professor = Professor.newBuilder();

            int telephone = generateRandomTelephone();
            String birthDate = generateRandomDate();
            professor.setId(i+1);
            if(type == 1){
                professor.setName(arrOfStrProf[i]);
            }else if(type == 2){
                professor.setName("a".repeat(arrOfStrProf[i].length()));
            }
            professor.setTelephone(telephone);
            professor.setBirthDate(birthDate);
            
            if(type == 1){
                professor.setAddress(arrOfStrAddressProf[i]+generateAddressType());
            }else if(type == 2){
                professor.setAddress("a".repeat((arrOfStrAddressProf[i]+generateAddressType()).length()));
            }

            for (int j = i * numberOfProfessorStudents; j < i * numberOfProfessorStudents + numberOfProfessorStudents; ++j) {
                Student.Builder student = Student.newBuilder();

                String studentBirthDate = generateRandomDate();
                String studentRegistrationDate = generateRandomDate();
                int studentTelephone = generateRandomTelephone();

                student.setId(j+1);
                if(type == 1){
                    student.setName(arrOfStr[j]);
                }else if(type == 2){
                    student.setName("a".repeat(arrOfStr[j].length()));
                }
                student.setTelephone(studentTelephone);
                student.setGender(generateGender());
                student.setBirthDate(studentBirthDate);
                student.setRegistrationDate(studentRegistrationDate);
                if(type == 1){
                    student.setAddress(arrOfStrAddress[j]+generateAddressType());
                }else if(type == 2){
                    student.setAddress("a".repeat((arrOfStrAddress[j]+generateAddressType()).length()));
                }

                startTime = System.nanoTime();
                professor.addStudents(student.build());
                totalTime = totalTime + (System.nanoTime() - startTime);
            }
            
            startTime = System.nanoTime();
            school.addProfessors(professor.build());
            totalTime = totalTime + (System.nanoTime() - startTime);
        }

        startTime = System.nanoTime();
        School s = school.build();
        totalTime = totalTime + (System.nanoTime() - startTime);
        
        return s;
    }



    public static String generateRandomDate(){
        int day = (int)Math.floor(Math.random()*(30-1+1)+1);
        int month = (int)Math.floor(Math.random()*(12-1+1)+1);
        int year = (int)Math.floor(Math.random()*(2022-1900+1)+1900);
        String Date = Integer.toString(day) + "-" +Integer.toString(month) + "-" +Integer.toString(year);
        return Date;
    }

    public static int generateRandomTelephone(){
        int telephone = 0;
        Random rand = new Random();

        for(int j = 0; j < 9; ++j){
            int int_random = rand.nextInt(10);
            telephone = telephone *10 + int_random;
        }
        return telephone;
    }

    public static String generateAddressType(){
        String[] types = new String[]{" Rue", " Route", " Avenue", " Street", " Road", " Lane", " Court", " Drive"};
        Random rand = new Random();
        int int_random = rand.nextInt(8);
        return types[int_random];
    }

    public static String generateGender(){
        String[] types = new String[]{"Male", "Female", "Non-Binary"};
        Random rand = new Random();
        int int_random = rand.nextInt(3);
        return types[int_random];
    }

    public static long getTotalTime() {
        return totalTime;
    }

    public static void setTotalTime(long totalTime) {
        AddSchool.totalTime = totalTime;
    }
}