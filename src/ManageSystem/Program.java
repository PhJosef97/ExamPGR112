package ManageSystem;


public class Program {
    private int programID;
    private String programName;
    private int programResponsibleID;

    public Program(int programID, String programName, int programResponsibleID) {
        this.programID = programID;
        this.programName = programName;
        this.programResponsibleID = programResponsibleID;
    }

    public int getProgramID() {
        return programID;
    }

    public String getProgramName() {
        return programName;
    }

    public int getProgramResponsibleID() {
        return programResponsibleID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public void setProgramResponsibleID(int programResponsibleID) {
        this.programResponsibleID = programResponsibleID;
    }
}

