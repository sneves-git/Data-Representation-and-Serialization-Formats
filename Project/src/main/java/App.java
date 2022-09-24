import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class App {

    public static void main(String[] args) {


        try {
            // ------ initialize data
            Input inputGenerator = new Input();
            // ---- set 1 ------
            ArrayList<Student> studentNames_set1 = inputGenerator.getStudentNames_set1();
            ArrayList<Professor> professorNames_set1 = inputGenerator.getProfessorNames_set1();

            // ---- set 2 ------
            ArrayList<Student> studentNames_set2 = inputGenerator.getStudentNames_set2();
            ArrayList<Professor> professorNames_set2 = inputGenerator.getProfessorNames_set2();

            // ---- set 3 ------
            ArrayList<Student> studentNames_set3 = inputGenerator.getStudentNames_set3();
            ArrayList<Professor> professorNames_set3 = inputGenerator.getProfessorNames_set3();

            System.out.println("------- Students Set 1\n");
            System.out.println(studentNames_set1);
            System.out.println("\n------ Professors Set 1\n");
            System.out.println(professorNames_set1);


            System.out.println("\n\n\n------ Students Set 2\n");
            System.out.println(studentNames_set2);
            System.out.println("\n------ Professors Set 2\n");
            System.out.println(professorNames_set2);


            System.out.println("\n\n\n------ Students Set 3\n");
            System.out.println(studentNames_set3);
            System.out.println("\n------ Professors Set 3\n");
            System.out.println(professorNames_set3);
            marshall(professorNames_set1, professorNames_set2,professorNames_set3 );
            unmarshall();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void marshall(ArrayList<Professor> professorNames_set1, ArrayList<Professor> professorNames_set2, ArrayList<Professor> professorNames_set3) {
        JAXBContext jaxbContext = null;
        int numberOfSets = 3;
        ArrayList<Professor>[] arrays = new ArrayList[numberOfSets];
        for (int i = 0; i < numberOfSets; ++i) {
            arrays[i] = new ArrayList<Professor>();
        }
        arrays[0] = professorNames_set1;
        arrays[1] = professorNames_set2;
        arrays[2] = professorNames_set3;
        System.out.println("----------------- Marshall -------------------");
        Holder holdProfessors = new Holder();
        long startTime, endTime, totalTime;
        for (int i = 0; i < numberOfSets; ++i) {

            try {
                // -------------------------------------
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[]{Holder.class}, null);

                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                File file =  new File("Result_set"+ (i+1) + ".xml");
                holdProfessors.setProfessors(arrays[i]);

                startTime = System.nanoTime();

                // output to a xml file
                jaxbMarshaller.marshal(holdProfessors, file);

                endTime= System.nanoTime();
                totalTime = endTime - startTime;
                System.out.println("------- Time Set "+ (i+1));
                System.out.println(totalTime);

            } catch (JAXBException e) {
                e.printStackTrace();
            }
           

        }


    }

    public static void unmarshall(){
        JAXBContext jaxbContext = null;
        int numberOfSets = 3;
        System.out.println("----------------- Unmarshall -------------------");

        long startTime, endTime, totalTime;
        for (int i = 0; i < numberOfSets; ++i) {

            try {
                // -------------------------------------
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[]{Holder.class}, null);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                File file =  new File("Result_set"+ (i+1) + ".xml");

                startTime = System.nanoTime();

                // output to a xml file
                Holder profs = (Holder)jaxbUnmarshaller.unmarshal(file);

                endTime= System.nanoTime();
                totalTime = endTime - startTime;
                System.out.println("------- Time Set "+ (i+1));
                System.out.println(totalTime);
                System.out.println("------- res --------------------- ");

                for(int j = 0; j < profs.getProfessors().size(); ++j){
                    System.out.println(profs.getProfessors().get(j));

                }

            } catch (JAXBException e) {
                e.printStackTrace();
            }
           
        }
    }


}