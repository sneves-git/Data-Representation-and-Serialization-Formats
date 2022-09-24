import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Professors")
@XmlAccessorType(XmlAccessType.FIELD)
public class Holder {
    @XmlElement(name = "Professor")
    ArrayList<Professor> professors = new ArrayList<>();

    public Holder(){}

    public Holder(ArrayList<Professor> prof){
        professors = prof;
    }

    public ArrayList<Professor> getProfessors(){
        return professors;
    }

    public void setProfessors(ArrayList<Professor> prof){
        professors = prof;
    }


    @Override
    public String toString() {
        return "Holder{" +
                "professors=" + professors +
                '}';
    }
}
