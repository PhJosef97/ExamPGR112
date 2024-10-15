package Personal;

public class Staff extends Person {
    private String role;
    private int programId;

    public Staff(int id, String name, String role, int programId) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.programId = programId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }
}

