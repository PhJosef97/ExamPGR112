package ManageSystem;

public class EventRegistrations {
    private int registrationID;
    private int studentID;
    private String guestName;

    public EventRegistrations(int registrationID, int studentID, String guestName) {
        this.registrationID = registrationID;
        this.studentID = studentID;
        this.guestName = guestName;
    }

    // getters and setters
    public int getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(int registrationID) {
        this.registrationID = registrationID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
}
