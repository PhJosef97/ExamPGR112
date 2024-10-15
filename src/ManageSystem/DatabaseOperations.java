package ManageSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Personal.Staff;
import Personal.Student;
public class DatabaseOperations {

    DatabaseSystemConnection databaseConnection;

    public DatabaseOperations() {
        databaseConnection = new DatabaseSystemConnection();
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try {
            Connection connection = databaseConnection.getUniversityConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Students");

            while(resultSet.next()) {
                int id = resultSet.getInt("studentID");
                String name = resultSet.getString("name");
                int programId = resultSet.getInt("programID");
                students.add(new Student(id, name, programId));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch(SQLException e) {
            System.out.println("Failed to retrieve students from the database.");
            e.printStackTrace();
        }

        return students;
    }

    public List<Staff> getAllStaff() {
        List<Staff> staffs = new ArrayList<>();

        try {
            Connection connection = databaseConnection.getUniversityConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Staff");

            while(resultSet.next()) {
                int id = resultSet.getInt("staffID");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                int programId = resultSet.getInt("programID");
                staffs.add(new Staff(id, name, role, programId));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch(SQLException e) {
            System.out.println("Failed to retrieve staff from the database.");
            e.printStackTrace();
        }

        return staffs;
    }

    public List<Program> getAllPrograms() {
        List<Program> programs = new ArrayList<>();

        try {
            Connection connection = databaseConnection.getUniversityConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Programs");

            while(resultSet.next()) {
                int id = resultSet.getInt("programID");
                String programName = resultSet.getString("programName");
                int programResponsibleId = resultSet.getInt("programResponsibleID");
                programs.add(new Program(id, programName, programResponsibleId));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch(SQLException e) {
            System.out.println("Failed to retrieve programs from the database.");
            e.printStackTrace();
        }

        return programs;
    }

    public void registerEvent(int registrationID, int studentId, String guestName) {
        try {
            Connection connection = databaseConnection.getEventConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO EventRegistrations (registrationID, studentID, guestName) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, registrationID);
            preparedStatement.setInt(2, studentId);
            preparedStatement.setString(3, guestName);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch(SQLException e) {
            System.out.println("Failed to register event.");
            e.printStackTrace();
        }
    }

    public Program getProgramById(int programId) {
        Program program = null;

        try {
            Connection connection = databaseConnection.getUniversityConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Programs WHERE programID = ?");
            preparedStatement.setInt(1, programId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("programID");
                String programName = resultSet.getString("programName");
                int programResponsibleId = resultSet.getInt("programResponsibleID");
                program = new Program(id, programName, programResponsibleId);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch(SQLException e) {
            System.out.println("Failed to retrieve program from the database.");
            e.printStackTrace();
        }

        return program;
    }

    public Student getStudentById(int id) {
        Student student = null;

        try {
            Connection connection = databaseConnection.getUniversityConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Students WHERE studentID = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                String name = resultSet.getString("name");
                int programId = resultSet.getInt("programID");
                student = new Student(id, name, programId);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch(SQLException e) {
            System.out.println("Failed to retrieve student by id from the database.");
            e.printStackTrace();
        }

        return student;
    }

    public List<Student> getStudentsByProgramId(int programId) {
        List<Student> students = new ArrayList<>();

        try {
            Connection connection = databaseConnection.getUniversityConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Students WHERE programID = ?");
            preparedStatement.setInt(1, programId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int id = resultSet.getInt("studentID");
                String name = resultSet.getString("name");
                students.add(new Student(id, name, programId));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch(SQLException e) {
            System.out.println("Failed to retrieve students by program id from the database.");
            e.printStackTrace();
        }

        return students;
    }

}
