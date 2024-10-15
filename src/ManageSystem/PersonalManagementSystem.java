package ManageSystem;
import Personal.Student;
import Personal.Staff;
import java.util.HashMap;

public class PersonalManagementSystem {
    private HashMap<Integer, Student> students;
    private HashMap<Integer, Staff> staffs;

    public PersonalManagementSystem() {
        students = new HashMap<>();
        staffs = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void addStaff(Staff staff) {
        staffs.put(staff.getId(), staff);
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public Staff getStaffById(int id) {
        return staffs.get(id);
    }
}
