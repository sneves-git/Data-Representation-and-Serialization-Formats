import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

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
    static Helper marshallHelper = new Helper();
    static Helper unmarshallHelper = new Helper();

    public static void main(String[] args) throws Exception {

        try {
            int numberOfSets = 3, numberOfTests = 30;

            // ------ number of students and professors
            int set_1_students = 100, set_2_students = 1000, set_3_students = 10000;
            int set_1_professors = 10, set_2_professors = 100, set_3_professors = 1000;

            // int set_1_students = 2, set_2_students = 4, set_3_students = 6;
            // int set_1_professors = 1, set_2_professors = 2, set_3_professors = 3;

            // ------ initialize data
            Input inputRandomLetters = new Input(1, set_1_students, set_2_students, set_3_students, set_1_professors,
                    set_2_professors, set_3_professors);
            Input inputSameLetters = new Input(2, set_1_students, set_2_students, set_3_students, set_1_professors,
                    set_2_professors, set_3_professors);

            // ---- set 1 ------
            ArrayList<Professor> professorNames_set1_1 = inputRandomLetters.getProfessorNames_set1();
            ArrayList<Professor> professorNames_set1_2 = inputSameLetters.getProfessorNames_set1();

            // ---- set 2 ------
            ArrayList<Professor> professorNames_set2_1 = inputRandomLetters.getProfessorNames_set2();
            ArrayList<Professor> professorNames_set2_2 = inputSameLetters.getProfessorNames_set2();

            // ---- set 3 ------
            ArrayList<Professor> professorNames_set3_1 = inputRandomLetters.getProfessorNames_set3();
            ArrayList<Professor> professorNames_set3_2 = inputSameLetters.getProfessorNames_set3();

            ArrayList<Professor>[] arrayProfessors_1 = wrapper(numberOfSets, professorNames_set1_1,
                    professorNames_set2_1, professorNames_set3_1);
            ArrayList<Professor>[] arrayProfessors_2 = wrapper(numberOfSets, professorNames_set1_2,
                    professorNames_set2_2, professorNames_set3_2);

            for (int i = 0; i < numberOfTests; ++i) {
                System.out.println("Run number " + (i+1));
                // XML
                marshall("'RandomText'", numberOfSets, arrayProfessors_1, "results\\XML\\RandomText");
                unmarshall("'RandomText'", "results\\XML\\RandomText");

                marshall("'SameText'", numberOfSets, arrayProfessors_2, "results\\XML\\SameText");
                unmarshall("'SameText'", "results\\XML\\SameText");

                // Gzip
                marshallWithGzip("'RandomText'", numberOfSets, arrayProfessors_1,
                        "results\\XML+Gzip\\RandomText\\Xml_Marshalling",
                        "results\\XML+Gzip\\RandomText\\Xml+Gzip_Marshalling");
                unmarshallWithGzip("'RandomText'", "results\\XML+Gzip\\RandomText\\Xml+Gzip_Marshalling",
                        "results\\XML+Gzip\\RandomText\\Xml+Gzip_Unmarshalling");

                marshallWithGzip("'SameText'", numberOfSets, arrayProfessors_2,
                        "results\\XML+Gzip\\SameText\\Xml_Marshalling",
                        "results\\XML+Gzip\\SameText\\Xml+Gzip_Marshalling");
                unmarshallWithGzip("'SameText'", "results\\XML+Gzip\\SameText\\Xml+Gzip_Marshalling",
                        "results\\XML+Gzip\\SameText\\Xml+Gzip_Unmarshalling");

                // Protobuf
                marshallProtobuf(1, 1, "results\\Protobuf\\RandomText\\Marshalling_set1", set_1_professors, set_1_students);
                time = time + "\n";
                unmarshallProtobuf(1, "'RandomText'", "results\\Protobuf\\RandomText\\Marshalling_set1",
                        "results\\Protobuf\\RandomText\\Unmarshalling_set1", set_1_professors, set_1_students);
                time = time + "\n";


                marshallProtobuf(2, 1, "results\\Protobuf\\RandomText\\Marshalling_set2", set_2_professors, set_2_students);
                time = time + "\n";
                unmarshallProtobuf(2, "'RandomText'", "results\\Protobuf\\RandomText\\Marshalling_set2",
                        "results\\Protobuf\\RandomText\\Unmarshalling_set2", set_2_professors, set_2_students);
                time = time + "\n";

                marshallProtobuf(3, 1, "results\\Protobuf\\RandomText\\Marshalling_set3", set_3_professors, set_3_students);
                time = time + "\n";
                unmarshallProtobuf(3, "'RandomText'", "results\\Protobuf\\RandomText\\Marshalling_set3",
                        "results\\Protobuf\\RandomText\\Unmarshalling_set3", set_3_professors, set_3_students);
                time = time + "\n";

                marshallProtobuf(1, 2, "results\\Protobuf\\SameText\\Marshalling_set1", set_1_professors, set_1_students);
                time = time + "\n";
                unmarshallProtobuf(1, "'SameText'", "results\\Protobuf\\SameText\\Marshalling_set1",
                        "results\\Protobuf\\SameText\\Unmarshalling_set1", set_1_professors, set_1_students);
                time = time + "\n";

                marshallProtobuf(2, 2, "results\\Protobuf\\SameText\\Marshalling_set2", set_2_professors, set_2_students);
                time = time + "\n";
                unmarshallProtobuf(2, "'SameText'", "results\\Protobuf\\SameText\\Marshalling_set2",
                        "results\\Protobuf\\SameText\\Unmarshalling_set2", set_2_professors, set_2_students);
                time = time + "\n";
                marshallProtobuf(3, 2, "results\\Protobuf\\SameText\\Marshalling_set3", set_3_professors, set_3_students);
                time = time + "\n";

                unmarshallProtobuf(3, "'SameText'", "results\\Protobuf\\SameText\\Marshalling_set3",
                        "results\\Protobuf\\SameText\\Unmarshalling_set3", set_3_professors, set_3_students);
                time = time + "\n";
            }


            PrintStream stream = new PrintStream("results/times6.txt");
            System.setOut(stream);
            marshallHelper.printer("Marshall");
            unmarshallHelper.printer("Unmarshall");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Professor>[] wrapper(int numberOfSets, ArrayList<Professor> professorNames_set1,
                                                 ArrayList<Professor> professorNames_set2, ArrayList<Professor> professorNames_set3) {
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
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                        .createContext(new Class[]{Holder.class}, null);

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
                printer(i + 1, type, "Xml", "Marshall", totalTime);

            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        time = time + "\n";
    }

    public static Long unmarshall(String type, String fileName) {
        JAXBContext jaxbContext = null;
        int numberOfSets = 3;
        time = time + "================== Unmarshalling " + type + " with XML ================== \n";

        long startTime = 0, totalTime = 0;
        for (int i = 0; i < numberOfSets; ++i) {
            try {
                // -------------------------------------
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                        .createContext(new Class[]{Holder.class}, null);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                File file = new File(fileName + "_set" + (i + 1) + ".xml");

                startTime = System.nanoTime();

                // output to a xml file
                Holder profs = (Holder) jaxbUnmarshaller.unmarshal(file);

                totalTime = System.nanoTime() - startTime;

                time = time + "Set " + (i + 1) + ": " + totalTime + "\n";
                printer(i + 1, type, "Xml", "Unmarshall", totalTime);

            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        time = time + "\n";
        return totalTime;
    }

    public static void marshallWithGzip(String type, int numberOfSets, ArrayList<Professor>[] arrays,
                                        String xmlInputFileName, String xmlWithGzipFileName) {

        JAXBContext jaxbContext = null;

        time = time + "================== Marshalling " + type + " with Gzip ================== \n";
        Holder holdProfessors = new Holder();
        long startTime = 0, totalTime = 0;
        for (int i = 0; i < numberOfSets; ++i) {
            try {
                // -------------------------------------
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                        .createContext(new Class[]{Holder.class}, null);

                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                File file = new File(xmlInputFileName + "_set" + (i + 1) + ".xml");
                holdProfessors.setProfessors(arrays[i]);

                startTime = System.nanoTime();
                // output to a xml file
                jaxbMarshaller.marshal(holdProfessors, file);
                totalTime = System.nanoTime() - startTime;

                // Open Gzip resources
                FileInputStream fis = new FileInputStream(xmlInputFileName + "_set" + (i + 1) + ".xml");
                FileOutputStream fos = new FileOutputStream(xmlWithGzipFileName + "_set" + (i + 1) + ".gzip");
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

                time = time + "Set " + (i + 1) + ": " + totalTime + "\n";

                // close resources
                gzipOS.close();
                fos.close();
                fis.close();
                printer((i + 1), type, "Gzip", "Marshall", totalTime);


            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
        }
        time = time + "\n";

    }

    public static void unmarshallWithGzip(String type, String xmlWithGzipFileName,
                                          String unmarshallXmlWithGzipFileName) {
        JAXBContext jaxbContext = null;
        int numberOfSets = 3;
        time = time + "================== Unmarshalling " + type + " with Gzip ================== \n";

        long startTime, totalTime;
        for (int i = 0; i < numberOfSets; ++i) {
            try {
                // -------------------------------------
                jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                        .createContext(new Class[]{Holder.class}, null);

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
                while ((len = gis.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                // output to a xml file
                Holder profs = (Holder) jaxbUnmarshaller.unmarshal(file);

                // Time
                totalTime = System.nanoTime() - startTime;

                time = time + "Set " + (i + 1) + ": " + totalTime + "\n";
                printer(i + 1, type, "Gzip", "Unmarshall", totalTime);

                // Close Gzip resources
                fos.close();
                gis.close();

            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
        }
        time = time + "\n";

    }

    public static Long marshallProtobuf(int set, int type, String fileName, int numberOfProfessors,
                                        int numberOfStudents) throws Exception {
        String typeOfText = "";
        if (type == 1) {
            time = time + "================== Marshalling 'RandomText' with Protobuf ================== \n";
            typeOfText = "'RandomText'";
        } else if (type == 2) {
            time = time + "================== Marshalling 'SameText' with Protobuf ================== \n";
            typeOfText = "'SameText'";
        }
        AddSchool.totalTime = 0;
        School schoolBuilder = AddSchool.PromptForSchool(type, numberOfProfessors, numberOfStudents);

        time = time + "Set " + set + ": " + AddSchool.getTotalTime() + "\n";
        printer(set, typeOfText, "Protobuf", "Marshall", AddSchool.getTotalTime());
        // Write the new address book back to disk.
        FileOutputStream output = new FileOutputStream(fileName);
        long start = System.nanoTime();
        schoolBuilder.writeTo(output);
        long writer = System.nanoTime() - start;
        printer(set, typeOfText, "Protobuf Writer","Marshall", writer);
        printer(set, typeOfText, "Protobuf Total", "Marshall", (writer+AddSchool.getTotalTime()));
        output.close();
        return AddSchool.getTotalTime();
    }

    public static void unmarshallProtobuf(int set, String type, String inputFileName, String outputFileName,
                                          int numberOfProfessors, int numberOfStudents) throws Exception {

        time = time + "================== Unmarshalling " + type + " with Protobuf ================== \n";

        long startTime, totalTime;

        // Read the existing address book.
        FileInputStream f = new FileInputStream(inputFileName);
        startTime = System.nanoTime();
        School school = School.parseFrom(f);
        totalTime = System.nanoTime() - startTime;

        long unbuild = protoObjectToJavaObject(school, numberOfProfessors, numberOfStudents);
        printer(set, type, "Protobuf Writer","Unmarshall", unbuild);
        printer(set, type, "Protobuf Total", "Unmarshall", (unbuild+totalTime));
        printer(set, type, "Protobuf", "Unmarshall", totalTime);

    }

    public static long protoObjectToJavaObject(School school, int numberOfProfessors, int numberOfStudents) {
        long startTime = System.nanoTime();

        Holder newSchool = new Holder();
        List<generated.protobuf.classes.Professor> professors = school.getProfessorsList();

        ArrayList<Professor> newProfessors = new ArrayList<>();
        for (int i = 0; i < numberOfProfessors; ++i) {

            List<generated.protobuf.classes.Student> students = professors.get(i).getStudentsList();

            ArrayList<Student> newStudents = new ArrayList<>();
            for (int j = 0; j < numberOfStudents / numberOfProfessors; ++j) {
                Student s = new Student(students.get(j).getId(),
                        students.get(j).getName(),
                        (long) students.get(j).getTelephone(),
                        students.get(j).getGender(),
                        students.get(j).getBirthDate(),
                        students.get(j).getRegistrationDate(),
                        students.get(j).getAddress());
                newStudents.add(s);
            }
            Professor professor = new Professor(professors.get(i).getId(),
                    professors.get(i).getName(),
                    (long) professors.get(i).getTelephone(),
                    professors.get(i).getBirthDate(),
                    professors.get(i).getAddress(),
                    newStudents);
            newProfessors.add(professor);

        }
        newSchool.setProfessors(newProfessors);

        return System.nanoTime() - startTime;
    }

    public static void printer(int set, String typeOfText, String format, String typeOfEncoding, long totalTime) {
        if (typeOfEncoding.compareTo("Marshall") == 0) {
            if (format.compareTo("Xml") == 0) {
                if (typeOfText.compareTo("'RandomText'") == 0) {
                    switch (set) {
                        case 1 -> marshallHelper.addLongToXmlSet1RandomText(totalTime);
                        case 2 -> marshallHelper.addLongToXmlSet2RandomText(totalTime);
                        case 3 -> marshallHelper.addLongToXmlSet3RandomText(totalTime);
                    }
                } else if (typeOfText.compareTo("'SameText'") == 0) {
                    switch (set) {
                        case 1 -> marshallHelper.addLongToXmlSet1SameText(totalTime);
                        case 2 -> marshallHelper.addLongToXmlSet2SameText(totalTime);
                        case 3 -> marshallHelper.addLongToXmlSet3SameText(totalTime);
                    }
                }
            } else if (format.compareTo("Gzip") == 0) {
                if (typeOfText.compareTo("'RandomText'") ==0) {
                    switch (set) {
                        case 1 -> marshallHelper.addLongToGzipSet1RandomText(totalTime);
                        case 2 -> marshallHelper.addLongToGzipSet2RandomText(totalTime);
                        case 3 -> marshallHelper.addLongToGzipSet3RandomText(totalTime);
                    }
                } else if (typeOfText.compareTo("'SameText'") == 0) {
                    switch (set) {
                        case 1 -> marshallHelper.addLongToGzipSet1SameText(totalTime);
                        case 2 -> marshallHelper.addLongToGzipSet2SameText(totalTime);
                        case 3 -> marshallHelper.addLongToGzipSet3SameText(totalTime);
                    }
                }

            } else if (format.compareTo("Protobuf") == 0) {
                if (typeOfText.compareTo("'RandomText'") == 0) {
                    switch (set) {
                        case 1 -> marshallHelper.addLongToProtobufSet1RandomText(totalTime);
                        case 2 -> marshallHelper.addLongToProtobufSet2RandomText(totalTime);
                        case 3 -> marshallHelper.addLongToProtobufSet3RandomText(totalTime);
                    }
                } else if (typeOfText.compareTo("'SameText'") == 0) {
                    switch (set) {
                        case 1 -> marshallHelper.addLongToProtobufSet1SameText(totalTime);
                        case 2 -> marshallHelper.addLongToProtobufSet2SameText(totalTime);
                        case 3 -> marshallHelper.addLongToProtobufSet3SameText(totalTime);
                    }
                }
            }
            else if (format.compareTo("Protobuf Writer") == 0) {
                if (typeOfText.compareTo("'RandomText'") == 0) {
                    switch (set) {
                        case 1 -> marshallHelper.addLongToProtobufSet1RandomTextWrite(totalTime);
                        case 2 -> marshallHelper.addLongToProtobufSet2RandomTextWrite(totalTime);
                        case 3 -> marshallHelper.addLongToProtobufSet3RandomTextWrite(totalTime);
                    }
                } else if (typeOfText.compareTo("'SameText'") == 0) {
                    switch (set) {
                        case 1 -> marshallHelper.addLongToProtobufSet1SameTextWrite(totalTime);
                        case 2 -> marshallHelper.addLongToProtobufSet2SameTextWrite(totalTime);
                        case 3 -> marshallHelper.addLongToProtobufSet3SameTextWrite(totalTime);
                    }
                }
            }else if (format.compareTo("Protobuf Total") == 0) {
                if (typeOfText.compareTo("'RandomText'") == 0) {
                    switch (set) {
                        case 1 -> marshallHelper.addLongToProtobufSet1RandomTextTotal(totalTime);
                        case 2 -> marshallHelper.addLongToProtobufSet2RandomTextTotal(totalTime);
                        case 3 -> marshallHelper.addLongToProtobufSet3RandomTextTotal(totalTime);
                    }
                } else if (typeOfText.compareTo("'SameText'") == 0) {
                    switch (set) {
                        case 1 -> marshallHelper.addLongToProtobufSet1SameTextTotal(totalTime);
                        case 2 -> marshallHelper.addLongToProtobufSet2SameTextTotal(totalTime);
                        case 3 -> marshallHelper.addLongToProtobufSet3SameTextTotal(totalTime);
                    }
                }
            }
        } else if (typeOfEncoding.compareTo("Unmarshall") == 0) {
            if (format.compareTo("Xml") == 0) {
                if (typeOfText.compareTo("'RandomText'") == 0) {
                    switch (set) {
                        case 1 -> unmarshallHelper.addLongToXmlSet1RandomText(totalTime);
                        case 2 -> unmarshallHelper.addLongToXmlSet2RandomText(totalTime);
                        case 3 -> unmarshallHelper.addLongToXmlSet3RandomText(totalTime);
                    }
                } else if (typeOfText.compareTo("'SameText'") == 0) {
                    switch (set) {
                        case 1 -> unmarshallHelper.addLongToXmlSet1SameText(totalTime);
                        case 2 -> unmarshallHelper.addLongToXmlSet2SameText(totalTime);
                        case 3 -> unmarshallHelper.addLongToXmlSet3SameText(totalTime);
                    }
                }
            } else if (format.compareTo("Gzip") == 0) {
                if (typeOfText.compareTo("'RandomText'") == 0) {
                    switch (set) {
                        case 1 -> unmarshallHelper.addLongToGzipSet1RandomText(totalTime);
                        case 2 -> unmarshallHelper.addLongToGzipSet2RandomText(totalTime);
                        case 3 -> unmarshallHelper.addLongToGzipSet3RandomText(totalTime);
                    }
                } else if (typeOfText.compareTo("'SameText'") == 0) {
                    switch (set) {
                        case 1 -> unmarshallHelper.addLongToGzipSet1SameText(totalTime);
                        case 2 -> unmarshallHelper.addLongToGzipSet2SameText(totalTime);
                        case 3 -> unmarshallHelper.addLongToGzipSet3SameText(totalTime);
                    }
                }

            } else if (format.compareTo("Protobuf") == 0) {
                if (typeOfText.compareTo("'RandomText'") == 0) {
                    switch (set) {
                        case 1 -> unmarshallHelper.addLongToProtobufSet1RandomText(totalTime);
                        case 2 -> unmarshallHelper.addLongToProtobufSet2RandomText(totalTime);
                        case 3 -> unmarshallHelper.addLongToProtobufSet3RandomText(totalTime);
                    }
                } else if (typeOfText.compareTo("'SameText'") == 0) {
                    switch (set) {
                        case 1 -> unmarshallHelper.addLongToProtobufSet1SameText(totalTime);
                        case 2 -> unmarshallHelper.addLongToProtobufSet2SameText(totalTime);
                        case 3 -> unmarshallHelper.addLongToProtobufSet3SameText(totalTime);
                    }
                }
            }else if (format.compareTo("Protobuf Writer") == 0) {
                if (typeOfText.compareTo("'RandomText'") == 0) {
                    switch (set) {
                        case 1 -> unmarshallHelper.addLongToProtobufSet1RandomTextWrite(totalTime);
                        case 2 -> unmarshallHelper.addLongToProtobufSet2RandomTextWrite(totalTime);
                        case 3 -> unmarshallHelper.addLongToProtobufSet3RandomTextWrite(totalTime);
                    }
                } else if (typeOfText.compareTo("'SameText'") == 0) {
                    switch (set) {
                        case 1 -> unmarshallHelper.addLongToProtobufSet1SameTextWrite(totalTime);
                        case 2 -> unmarshallHelper.addLongToProtobufSet2SameTextWrite(totalTime);
                        case 3 -> unmarshallHelper.addLongToProtobufSet3SameTextWrite(totalTime);
                    }
                }
            }else if (format.compareTo("Protobuf Total") == 0) {
                if (typeOfText.compareTo("'RandomText'") == 0) {
                    switch (set) {
                        case 1 -> unmarshallHelper.addLongToProtobufSet1RandomTextTotal(totalTime);
                        case 2 -> unmarshallHelper.addLongToProtobufSet2RandomTextTotal(totalTime);
                        case 3 -> unmarshallHelper.addLongToProtobufSet3RandomTextTotal(totalTime);
                    }
                } else if (typeOfText.compareTo("'SameText'") == 0) {
                    switch (set) {
                        case 1 -> unmarshallHelper.addLongToProtobufSet1SameTextTotal(totalTime);
                        case 2 -> unmarshallHelper.addLongToProtobufSet2SameTextTotal(totalTime);
                        case 3 -> unmarshallHelper.addLongToProtobufSet3SameTextTotal(totalTime);
                    }
                }
            }
        }
    }



}

