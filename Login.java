import java.util.*;

public class Login {

    static Map<String, String> users = new HashMap<>(); // email -> password
    static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        // Pre-populate with a sample registered user
        users.put("test@example.com", "1234");

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== User Login ===");

            boolean loggedIn = false;
            int attempts = 0;

            while (attempts < MAX_ATTEMPTS && !loggedIn) {
                System.out.print("Enter email: ");
                String email = sc.nextLine().trim().toLowerCase();

                System.out.print("Enter password: ");
                String password = sc.nextLine().trim();

                loggedIn = loginUser(email, password);
                attempts++;

                if (loggedIn) {
                    System.out.println("Login successful! Welcome back, " + email + ".");
                } else {
                    int remaining = MAX_ATTEMPTS - attempts;
                    if (remaining > 0) {
                        System.out.println("Invalid email or password. Attempts left: " + remaining);
                    } else {
                        System.out.println("Login failed. Too many attempts.");
                    }
                }
            }
        }
    }

    static boolean loginUser(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            return false;
        }
        return users.containsKey(email) && users.get(email).equals(password);
    }
}