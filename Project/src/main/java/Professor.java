import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Professor {
    @XmlAttribute
    int id;

    @XmlElement(name = "name")
    String name;

    Double telephone;
    String BirthDate;
    String Address;

    ArrayList<Student> Students;

    public Professor(int id, String name, Double telephone, String birthDate, String address) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        BirthDate = birthDate;
        Address = address;
        Students = new ArrayList<>();
    }

    public Professor(int id, String name, Double telephone, String birthDate, String address, ArrayList<Student> students) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        BirthDate = birthDate;
        Address = address;
        Students = students;
    }
    public Professor(){
        Students = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTelephone() {
        return telephone;
    }

    public void setTelephone(Double telephone) {
        this.telephone = telephone;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public ArrayList<Student> getStudents() {
        return Students;
    }

    public void setStudents(ArrayList<Student> students) {
        Students = students;
    }

    public void AddStudent(Student s){
        Students.add(s);
    }
}
