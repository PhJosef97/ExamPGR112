package ManageSystem;

import Personal.Staff;
import Personal.Student;

import java.util.List;
import java.util.Scanner;

public class Application {
    private static final PersonalManagementSystem managementSystem = new PersonalManagementSystem();
    private static final InputValidator inputValidator = new InputValidator();

    private static final DatabaseOperations dbOperations = new DatabaseOperations(); // Add this line to create an instance of DatabaseOperations

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to universityDB! Choose one of the number.");
            System.out.println("1. Log in as Staff");
            System.out.println("2. Log in as student");
            System.out.println("3. Create new person");
            System.out.println("4. Exit");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    logInAsStaffMember(dbOperations); // Pass the instance to the method
                    break;
                case "2":
                    logInAsStudent();
                    break;
                case "3":
                    System.out.println("Create student or staff?");
                    String personType = scanner.nextLine();
                    if (personType.equalsIgnoreCase("student")) {
                        createNewStudent(scanner);
                    } else if (personType.equalsIgnoreCase("staff")) {
                        createNewStaffMember(scanner);
                    } else {
                        System.out.println("Try again");
                    }
                    break;
                case "4":
                    System.out.println("Exit...");
                    return;
                default:
                    System.out.println("Try again");
            }
        }
    }

    private static void logInAsStaffMember(DatabaseOperations dbOperations) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your staff ID: ");
        String inputIdString = scanner.nextLine();

        // Validate the input
        if (!inputValidator.isValidString(inputIdString)) {
            System.out.println("Invalid input. Please try again.");
            return;
        }

        int inputId = Integer.parseInt(inputIdString);

        if (!inputValidator.isValidId(inputId)) {
            System.out.println("Invalid ID. Please try again.");
            return;
        }

        List<Staff> allStaffMembers = dbOperations.getAllStaff();

        for (Staff staff : allStaffMembers) {
            if (staff.getId() == inputId) {
                System.out.println("Logged in as: " + staff.getName());
                return;
            }
        }

        System.out.println("No staff member found with the entered ID.");
    }

    private static void logInAsStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your staff ID: ");
        String inputIdString = scanner.nextLine();

        // Validate the input
        if (!inputValidator.isValidString(inputIdString)) {
            System.out.println("Invalid input. Please try again.");
            return;
        }

        int inputId = Integer.parseInt(inputIdString);

        if (!inputValidator.isValidId(inputId)) {
            System.out.println("Invalid ID. Please try again.");
            return;
        }

        Student loggedInStudent = dbOperations.getStudentById(inputId);
        if (loggedInStudent == null) {
            System.out.println("No student found with the entered ID.");
            return;
        }

        while(true) {
            System.out.println("Welcome, " + loggedInStudent.getName() + "! Here are your options:");
            System.out.println("1. Edit registration for the event");
            System.out.println("2. See all participants");
            System.out.println("3. See participants from your program");
            System.out.println("4. Search for participant");
            System.out.println("5. See overall program");
            System.out.println("6. Exit");
            int option = scanner.nextInt();
            switch(option) {
                case 1:
                    int registrationID = 0; // Startverdi for registrationID
                    System.out.print("Enter the name of your guest: ");
                    String guestName = scanner.nextLine();
                    dbOperations.registerEvent(registrationID, loggedInStudent.getId(), guestName);
                    System.out.println("You have successfully registered for the event with your guest, " + guestName + ".");
                    break;
                case 2:
                    List<Student> allStudents = dbOperations.getAllStudents();
                    System.out.println("All Participants:");
                    for (Student student : allStudents) {
                        System.out.println("Student ID: " + student.getId() + ", Student Name: " + student.getName());
                    }
                    break;
                case 3:
                    List<Student> studentsFromProgram = dbOperations.getStudentsByProgramId(loggedInStudent.getProgramId());
                    System.out.println("Participants from Your Program:");
                    for (Student student : studentsFromProgram) {
                        System.out.println("Student ID: " + student.getId() + ", Student Name: " + student.getName());
                    }
                    break;
                case 4:
                    System.out.print("Enter the ID of the student you want to search for: ");
                    int searchId = scanner.nextInt();
                    Student searchedStudent = dbOperations.getStudentById(searchId);
                    if (searchedStudent == null) {
                        System.out.println("No student found with the entered ID.");
                    } else {
                        System.out.println("Student ID: " + searchedStudent.getId() + ", Student Name: " + searchedStudent.getName());
                    }
                    break;
                case 5:
                    Program program = dbOperations.getProgramById(loggedInStudent.getProgramId());
                    System.out.println("Program Name: " + program.getProgramName());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        }
    }

    private static void createNewStudent(Scanner scanner) {
        System.out.print("Enter the new student's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline leftover

        System.out.print("Enter the new student's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the new student's program ID: ");
        int programId = scanner.nextInt();
        scanner.nextLine();  // Consume newline leftover

        Student newStudent = new Student(id, name, programId);
        managementSystem.addStudent(newStudent);


        System.out.println("New student created successfully!");
    }

    private static void createNewStaffMember(Scanner scanner) {
        System.out.print("Enter the new staff member's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline leftover

        System.out.print("Enter the new staff member's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the new staff member's role: ");
        String role = scanner.nextLine();

        System.out.print("Enter the new staff member's program ID: ");
        int programId = scanner.nextInt();
        scanner.nextLine();  // Consume newline leftover

        Staff newStaff = new Staff(id, name, role, programId);
        managementSystem.addStaff(newStaff);

        System.out.println("New staff member created successfully!");
    }


}
