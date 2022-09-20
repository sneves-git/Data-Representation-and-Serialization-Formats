import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.*;

public class App {

    public static void main(String[] args) {

        JAXBContext jaxbContext = null;
        try {

            // ------ initialize data
            Student s1 = new Student();
            Student s2 = new Student();
            Student s3 = new Student();
            s1.setName("Alberto");
            s1.setAge("21");
            s2.setName("Patricia");
            s2.setAge("22");
            s3.setName("Luis");
            s3.setAge("21");

            List<Student> students = new ArrayList<Student>();
            students.add(s1);
            students.add(s2);
            students.add(s3);

            // -------------------------------------

            jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                    .createContext(new Class[]{Student.class}, null);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            // output to a xml file
            jaxbMarshaller.marshal(students, new File("students.xml"));

            // output to console
            jaxbMarshaller.marshal(students, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}