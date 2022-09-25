import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import generated.protobuf.classes.School;

public class App {

    public static void main(String[] args) throws Exception {


        try {
            int numberOfSets = 3;
          
            // ------ initialize data
            Input inputGenerator = new Input(2);
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
            ArrayList<Professor>[] arrays = wrapper(numberOfSets, professorNames_set1, professorNames_set2, professorNames_set3);

            // XML 
            marshall(numberOfSets, arrays);
            unmarshall();

            // Gzip
            marshallWithGzip(numberOfSets, arrays);
            unmarshallWithGzip();

            // Protobuf
            generateProtobufInput(1, "ResultProtobuf_set1", inputGenerator.getSet_1_professors(), inputGenerator.getSet_1_students());
            generateProtobufInput(1, "ResultProtobuf_set2", inputGenerator.getSet_2_professors(), inputGenerator.getSet_2_students());
            generateProtobufInput(1, "ResultProtobuf_set3", inputGenerator.getSet_3_professors(), inputGenerator.getSet_3_students());

            generateProtobufInput(2, "ResultProtobufSameLetter_set1", inputGenerator.getSet_1_professors(), inputGenerator.getSet_1_students());
            generateProtobufInput(2, "ResultProtobufSameLetter_set2", inputGenerator.getSet_2_professors(), inputGenerator.getSet_2_students());
            generateProtobufInput(2, "ResultProtobufSameLetter_set3", inputGenerator.getSet_3_professors(), inputGenerator.getSet_3_students());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Professor>[] wrapper(int numberOfSets, ArrayList<Professor> professorNames_set1, ArrayList<Professor> professorNames_set2, ArrayList<Professor> professorNames_set3) {
        ArrayList<Professor>[] arrays = new ArrayList[numberOfSets];
        for (int i = 0; i < numberOfSets; ++i) {
            arrays[i] = new ArrayList<Professor>();
        }
        arrays[0] = professorNames_set1;
        arrays[1] = professorNames_set2;
        arrays[2] = professorNames_set3;
        return arrays;
    }

    public static void marshall(int numberOfSets, ArrayList<Professor>[] arrays) {
        JAXBContext jaxbContext = null;

        System.out.println("=============================== Marshall =============================== ");
        Holder holdProfessors = new Holder();
        long startTime, endTime, totalTime;
        for (int i = 0; i < numberOfSets; ++i) {

            try {
                // -------------------------------------
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[]{Holder.class}, null);

                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                File file = new File("Result_set" + (i + 1) + ".xml");
                holdProfessors.setProfessors(arrays[i]);

                startTime = System.nanoTime();

                // output to a xml file
                jaxbMarshaller.marshal(holdProfessors, file);

                endTime = System.nanoTime();
                totalTime = endTime - startTime;
                System.out.println("-------------------Time Set " + (i + 1));
                System.out.println(totalTime);

            } catch (JAXBException e) {
                e.printStackTrace();
            }


        }


    }

    public static void unmarshall() {
        JAXBContext jaxbContext = null;
        int numberOfSets = 3;
        System.out.println("=============================== Unmarshall =============================== ");

        long startTime, endTime, totalTime;
        for (int i = 0; i < numberOfSets; ++i) {

            try {
                // -------------------------------------
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[]{Holder.class}, null);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                File file = new File("Result_set" + (i + 1) + ".xml");

                startTime = System.nanoTime();

                // output to a xml file
                Holder profs = (Holder) jaxbUnmarshaller.unmarshal(file);

                endTime = System.nanoTime();
                totalTime = endTime - startTime;
                System.out.println("---------------------- Time Set " + (i + 1));
                System.out.println(totalTime);
                System.out.println("-> res");

                for (int j = 0; j < profs.getProfessors().size(); ++j) {
                    System.out.println(profs.getProfessors().get(j));

                }

            } catch (JAXBException e) {
                e.printStackTrace();
            }

        }
    }

    public static void marshallWithGzip(int numberOfSets, ArrayList<Professor>[] arrays) {

        JAXBContext jaxbContext = null;

        System.out.println("=============================== Marshall With Gzip =============================== ");
        Holder holdProfessors = new Holder();
        long startTime, endTime, totalTime;
        for (int i = 0; i < numberOfSets; ++i) {

            try {
                // -------------------------------------
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[]{Holder.class}, null);

                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                File file = new File("Result_set" + (i + 1) + ".xml");

                // Open Gzip resources
                FileInputStream fis = new FileInputStream("Result_set" + (i + 1) + ".xml");
                FileOutputStream fos = new FileOutputStream("ResultWithGzip_set" + (i + 1) + ".gzip");
                GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
                byte[] buffer = new byte[1024];
                int len;

                holdProfessors.setProfessors(arrays[i]);

                startTime = System.nanoTime();

                // output to a xml file
                jaxbMarshaller.marshal(holdProfessors, file);

                // Gzip
                while ((len = fis.read(buffer)) != -1) {
                    gzipOS.write(buffer, 0, len);
                }

                // Time
                endTime = System.nanoTime();
                totalTime = endTime - startTime;
                System.out.println("------- Time Set " + (i + 1));
                System.out.println(totalTime);


                //close resources
                gzipOS.close();
                fos.close();
                fis.close();

            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void unmarshallWithGzip() {
        JAXBContext jaxbContext = null;
        int numberOfSets = 3;
        System.out.println("=============================== Unmarshall With Gzip =============================== ");

        long startTime, endTime, totalTime;
        for (int i = 0; i < numberOfSets; ++i) {

            try {
                // -------------------------------------
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[]{Holder.class}, null);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                // Open Gzip Resources
                FileInputStream fis = new FileInputStream("ResultWithGzip_set" + (i + 1) + ".gzip");
                GZIPInputStream gis = new GZIPInputStream(fis);
                FileOutputStream fos = new FileOutputStream("ResultDecompressionGzip_set" + (i + 1) + ".xml");
                byte[] buffer = new byte[1024];
                int len;



                File file = new File("ResultDecompressionGzip_set" + (i + 1) + ".xml");

                startTime = System.nanoTime();

                // Gzip Decompression
                while((len = gis.read(buffer)) != -1){
                    fos.write(buffer, 0, len);
                }
                // output to a xml file
                Holder profs = (Holder) jaxbUnmarshaller.unmarshal(file);

                // Time
                endTime = System.nanoTime();
                totalTime = endTime - startTime;
                System.out.println("------- Time Set " + (i + 1));
                System.out.println(totalTime);
                System.out.println("------- res --------------------- ");

                for (int j = 0; j < profs.getProfessors().size(); ++j) {
                    System.out.println(profs.getProfessors().get(j));

                }

                // Close Gzip resources
                fos.close();
                gis.close();

            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }


        }
    }

    public static void generateProtobufInput(int type, String fileName, int numberOfProfessors, int numberOfStudents) throws Exception {
        
        School schoolBuilder = AddSchool.PromptForSchool(type, numberOfProfessors, numberOfStudents);

        System.out.println(AddSchool.getTotalTime());
            
        // Write the new address book back to disk.
        FileOutputStream output = new FileOutputStream(fileName);
        schoolBuilder.writeTo(output);
        output.close();
    }

}