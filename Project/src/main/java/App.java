import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class App {

    public static void main(String[] args) {

        JAXBContext jaxbContext = null;
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

            ProfessorsList professorsList1 = new ProfessorsList();
            System.out.println("------- Students Set 1\n");
            System.out.println(studentNames_set1);
            System.out.println("\n------ Professors Set 1\n");
            System.out.println(professorNames_set1);
            for (Professor professor : professorNames_set1) {
                professorsList1.addProfessor(professor);
            }

            ProfessorsList professorsList2 = new ProfessorsList();
            System.out.println("\n\n\n------ Students Set 2\n");
            System.out.println(studentNames_set2);
            System.out.println("\n------ Professors Set 2\n");
            System.out.println(professorNames_set2);
            for (Professor professor : professorNames_set2) {
                professorsList2.addProfessor(professor);
            }


            ProfessorsList professorsList3 = new ProfessorsList();
            System.out.println("\n\n\n------ Students Set 3\n");
            System.out.println(studentNames_set3);
            System.out.println("\n------ Professors Set 3\n");
            System.out.println(professorNames_set3);
            for (Professor professor : professorNames_set3) {
                professorsList3.addProfessor(professor);
            }

            // -------------------------------------
            jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[] { ProfessorsList.class }, null);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // output to a xml file
            jaxbMarshaller.marshal(professorsList1, new File("Result_set1.xml"));

            // output to a xml file
            jaxbMarshaller.marshal(professorsList2, new File("Result_set2.xml"));

            // output to a xml file
            jaxbMarshaller.marshal(professorsList3, new File("Result_set3.xml"));

            // output to console
            //jaxbMarshaller.marshal(students, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}