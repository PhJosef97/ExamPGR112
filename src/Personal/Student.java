package Personal;

public class Student extends Person {
    private int programId;

    public Student(int id, String name, int programId) {
        this.id = id;
        this.name = name;
        this.programId = programId;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }
}

