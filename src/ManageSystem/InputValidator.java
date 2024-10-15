package ManageSystem;

public class InputValidator {
    public boolean isValidString(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Input cannot be null or empty.");
            return false;
        }
        return true;
    }

    public boolean isValidId(int id) {
        if (id < 0) {
            System.out.println("ID cannot be less than 0.");
            return false;
        }
        return true;
    }
}
