import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import generated.protobuf.classes.School;

public class App {
    static String time = "";

    public static void main(String[] args) throws Exception {
        

        try {
            int numberOfSets = 3;
          
            // ------ number of students and professors
            int set_1_students = 100, set_2_students = 1000, set_3_students = 10000;
            int set_1_professors = 10, set_2_professors = 100, set_3_professors = 1000;

            //int set_1_students = 2, set_2_students = 4, set_3_students = 6;
            //int set_1_professors = 1, set_2_professors = 2, set_3_professors = 3;
            
            
            // ------ initialize data
            Input inputRandomLetters = new Input(1, set_1_students, set_2_students, set_3_students, set_1_professors, set_2_professors, set_3_professors);
            Input inputSameLetters = new Input(2, set_1_students, set_2_students, set_3_students, set_1_professors, set_2_professors, set_3_professors);

            // ---- set 1 ------
            ArrayList<Professor> professorNames_set1_1 = inputRandomLetters.getProfessorNames_set1();
            ArrayList<Professor> professorNames_set1_2 = inputSameLetters.getProfessorNames_set1();

            // ---- set 2 ------
            ArrayList<Professor> professorNames_set2_1 = inputRandomLetters.getProfessorNames_set2();
            ArrayList<Professor> professorNames_set2_2 = inputSameLetters.getProfessorNames_set2();

            // ---- set 3 ------
            ArrayList<Professor> professorNames_set3_1 = inputRandomLetters.getProfessorNames_set3();
            ArrayList<Professor> professorNames_set3_2 = inputSameLetters.getProfessorNames_set3();


            ArrayList<Professor>[] arrayProfessors_1 = wrapper(numberOfSets, professorNames_set1_1, professorNames_set2_1, professorNames_set3_1);
            ArrayList<Professor>[] arrayProfessors_2 = wrapper(numberOfSets, professorNames_set1_2, professorNames_set2_2, professorNames_set3_2);

            // XML 
            marshall("'RandomText'", numberOfSets, arrayProfessors_1, "results\\XML\\RandomText");
            unmarshall("'RandomText'", "results\\XML\\RandomText");

            marshall("'SameText'", numberOfSets, arrayProfessors_2, "results\\XML\\SameText");
            unmarshall("'RandomText'", "results\\XML\\SameText");

            // Gzip
            marshallWithGzip("'RandomText'", numberOfSets, arrayProfessors_1, "results\\XML+Gzip\\RandomText\\Xml_Marshalling", "results\\XML+Gzip\\RandomText\\Xml+Gzip_Marshalling");
            unmarshallWithGzip("'RandomText'", "results\\XML+Gzip\\RandomText\\Xml+Gzip_Marshalling", "results\\XML+Gzip\\RandomText\\Xml+Gzip_Unmarshalling");

            marshallWithGzip("'SameText'", numberOfSets, arrayProfessors_2, "results\\XML+Gzip\\SameText\\Xml_Marshalling", "results\\XML+Gzip\\SameText\\Xml+Gzip_Marshalling");
            unmarshallWithGzip("'RandomText'", "results\\XML+Gzip\\SameText\\Xml+Gzip_Marshalling", "results\\XML+Gzip\\SameText\\Xml+Gzip_Unmarshalling");

            // Protobuf
            marshallProtobuf(1, 1, "results\\Protobuf\\RandomText\\Marshalling_set1",  set_1_professors,set_1_students);
            time = time + "\n";
            unmarshallProtobuf(1,"'SameText'", "results\\Protobuf\\RandomText\\Marshalling_set1", "results\\Protobuf\\RandomText\\Unmarshalling_set1");
            time = time + "\n";


            marshallProtobuf(2, 1, "results\\Protobuf\\RandomText\\Marshalling_set2",  set_2_professors, set_2_students);
            time = time + "\n";
            unmarshallProtobuf(2,"'SameText'",  "results\\Protobuf\\RandomText\\Marshalling_set2", "results\\Protobuf\\RandomText\\Unmarshalling_set2");
            time = time + "\n";


            marshallProtobuf(3, 1, "results\\Protobuf\\RandomText\\Marshalling_set3",  set_3_professors, set_3_students);
            time = time + "\n";
            unmarshallProtobuf(3, "'SameText'", "results\\Protobuf\\RandomText\\Marshalling_set3", "results\\Protobuf\\RandomText\\Unmarshalling_set3");
            time = time + "\n";

            marshallProtobuf(1, 2, "results\\Protobuf\\SameText\\Marshalling_set1",  set_1_professors, set_1_students);
            time = time + "\n";
            unmarshallProtobuf(1, "'SameText'", "results\\Protobuf\\SameText\\Marshalling_set1", "results\\Protobuf\\SameText\\Unmarshalling_set1");
            time = time + "\n";

            marshallProtobuf(2, 2, "results\\Protobuf\\SameText\\Marshalling_set2", set_2_professors, set_2_students);
            time = time + "\n";
            unmarshallProtobuf(2,"'SameText'",  "results\\Protobuf\\SameText\\Marshalling_set2", "results\\Protobuf\\SameText\\Unmarshalling_set2");
            time = time + "\n";

            marshallProtobuf(3, 2, "results\\Protobuf\\SameText\\Marshalling_set3", set_3_professors, set_3_students);
            time = time + "\n";
            unmarshallProtobuf(3, "'SameText'", "results\\Protobuf\\SameText\\Marshalling_set3", "results\\Protobuf\\SameText\\Unmarshalling_set3");
            time = time + "\n";

            PrintStream stream = new PrintStream("results/times.txt");
            System.setOut(stream);
            System.out.println(time);
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

    public static void marshall(String type, int numberOfSets, ArrayList<Professor>[] arrays, String fileName) {
        JAXBContext jaxbContext = null;

        time = time + "================== Marshalling " + type + " with XML ==================\n";
        Holder holdProfessors = new Holder();
        long startTime = 0, totalTime = 0;
        for (int i = 0; i < numberOfSets; ++i) {
            try {
                // -------------------------------------
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[]{Holder.class}, null);

                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                File file = new File(fileName + "_set" + (i + 1) + ".xml");
                holdProfessors.setProfessors(arrays[i]);

                startTime = System.nanoTime();

                // output to a xml file
                jaxbMarshaller.marshal(holdProfessors, file);

                totalTime = System.nanoTime() - startTime;

                time = time + "Set " + (i + 1) + ": " + totalTime + "\n";

            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        time = time + "\n";
    }

    public static void unmarshall(String type, String fileName) {
        JAXBContext jaxbContext = null;
        int numberOfSets = 3;
        time = time + "================== Unmarshalling " + type + " with XML ================== \n";

        long startTime = 0, totalTime = 0;
        for (int i = 0; i < numberOfSets; ++i) {
            try {
                // -------------------------------------
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[]{Holder.class}, null);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                File file = new File(fileName + "_set" + (i + 1) + ".xml");

                startTime = System.nanoTime();

                // output to a xml file
                Holder profs = (Holder) jaxbUnmarshaller.unmarshal(file);

                totalTime = System.nanoTime() - startTime;

                time = time + "Set " + (i + 1) + ": " + totalTime + "\n";
            
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        time = time + "\n";
    }

    public static void marshallWithGzip(String type, int numberOfSets, ArrayList<Professor>[] arrays, String xmlInputFileName, String xmlWithGzipFileName) {

        JAXBContext jaxbContext = null;

        time = time + "================== Marshalling " + type + " with Gzip ================== \n";
        Holder holdProfessors = new Holder();
        long startTime = 0, totalTime = 0;
        for (int i = 0; i < numberOfSets; ++i) {
            try {
                // -------------------------------------
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[]{Holder.class}, null);

                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                File file = new File(xmlInputFileName + "_set" + (i + 1) + ".xml");
                holdProfessors.setProfessors(arrays[i]);


                System.out.println(totalTime);
                startTime = System.nanoTime();
                // output to a xml file
                jaxbMarshaller.marshal(holdProfessors, file);
                totalTime = System.nanoTime() - startTime;
                System.out.println(totalTime);



                // Open Gzip resources
                FileInputStream fis = new FileInputStream(xmlInputFileName + "_set" + (i + 1) + ".xml");
                FileOutputStream fos = new FileOutputStream( xmlWithGzipFileName + "_set" + (i + 1) + ".gzip");
                GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
                byte[] buffer = new byte[1024];
                int len;



                startTime = System.nanoTime();
                // Gzip
                while ((len = fis.read(buffer)) != -1) {
                    gzipOS.write(buffer, 0, len);
                }
                // Time
                totalTime = totalTime + (System.nanoTime() - startTime);
                System.out.println(totalTime);

                time = time + "Set " + (i + 1) + ": " + totalTime + "\n";

                //close resources
                gzipOS.close();
                fos.close();
                fis.close();

            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
        }
        time = time + "\n";

    }


    public static void unmarshallWithGzip(String type, String xmlWithGzipFileName, String unmarshallXmlWithGzipFileName) {
        JAXBContext jaxbContext = null;
        int numberOfSets = 3;
        time = time + "================== Unmarshalling " + type + " with Gzip ================== \n";

        long startTime, totalTime;
        for (int i = 0; i < numberOfSets; ++i) {
            try {
                // -------------------------------------
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[]{Holder.class}, null);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                // Open Gzip Resources
                FileInputStream fis = new FileInputStream(xmlWithGzipFileName + "_set" + (i + 1) + ".gzip");
                GZIPInputStream gis = new GZIPInputStream(fis);
                FileOutputStream fos = new FileOutputStream(unmarshallXmlWithGzipFileName + "_set" + (i + 1) + ".xml");
                byte[] buffer = new byte[1024];
                int len;



                File file = new File(unmarshallXmlWithGzipFileName + "_set" + (i + 1) + ".xml");

                startTime = System.nanoTime();

                // Gzip Decompression
                while((len = gis.read(buffer)) != -1){
                    fos.write(buffer, 0, len);
                }
                // output to a xml file
                Holder profs = (Holder) jaxbUnmarshaller.unmarshal(file);

                // Time
                totalTime = System.nanoTime() - startTime;

                time = time + "Set " + (i + 1) + ": " + totalTime + "\n";
                
                // Close Gzip resources
                fos.close();
                gis.close();

            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
        }
        time = time + "\n";

    }

    public static void marshallProtobuf(int set, int type, String fileName, int numberOfProfessors, int numberOfStudents) throws Exception {
         if(type == 1){
            time = time + "================== Marshalling 'RandomText' with Protobuf ================== \n";

        }else if(type ==2){
            time = time + "================== Marshalling 'SameText' with Protobuf ================== \n";
        }
        School schoolBuilder = AddSchool.PromptForSchool(type, numberOfProfessors, numberOfStudents);

        time = time + "Set " + set + ": " + AddSchool.getTotalTime() + "\n";
            
        // Write the new address book back to disk.
        FileOutputStream output = new FileOutputStream(fileName);
        schoolBuilder.writeTo(output);
        output.close();
    }

    public static void unmarshallProtobuf(int set, String type, String inputFileName, String outputFileName) throws Exception {
         
        time = time + "================== Unmarshalling " + type + " with Protobuf ================== \n";
        
        long startTime, endTime, totalTime;


        // Read the existing address book.
        startTime = System.nanoTime();
        School school = School.parseFrom(new FileInputStream(inputFileName));
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        
        PrintStream stream = new PrintStream(outputFileName);

        System.setOut(stream);
        System.out.println(school);
        
        time = time + "Set " + set + ": " + totalTime + "\n";
        
    }

}