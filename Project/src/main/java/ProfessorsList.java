import java.util.ArrayList;

public class ProfessorsList {
    private ArrayList<Professor> professors;

    public ProfessorsList(){
        professors = new ArrayList<>();
    }

    public void addProfessor(Professor p){
        professors.add(p);
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }
}
