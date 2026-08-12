import java.util.*;

public class Login {

    static Map<String, String> users = new HashMap<>(); // email -> password

    public static void main(String[] args) {
        // Pre-populate with a sample registered user
        users.put("test@example.com", "1234");

        Scanner sc = new Scanner(System.in);

        System.out.println("=== User Login ===");
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        boolean success = loginUser(email, password);

        if (success) {
            System.out.println("Login successful! Welcome back.");
        } else {
            System.out.println("Login failed: invalid email or password.");
        }

        sc.close();
    }

    static boolean loginUser(String email, String password) {
        return users.containsKey(email) && users.get(email).equals(password);
    }
}