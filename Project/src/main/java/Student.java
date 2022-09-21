import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    int id;

    @XmlElement(name = "name")
    String name;

    long telephone;

    String gender;
    String BirthDate;
    String RegistrationDate;
    String Address;

    public Student(int id, String name, long telephone, String gender, String birthDate, String registrationDate, String address) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.gender = gender;
        BirthDate = birthDate;
        RegistrationDate = registrationDate;
        Address = address;
    }

    public Student(){}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        RegistrationDate = registrationDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone=" + telephone +
                ", gender='" + gender + '\'' +
                ", BirthDate='" + BirthDate + '\'' +
                ", RegistrationDate='" + RegistrationDate + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}