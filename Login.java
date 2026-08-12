import java.util.*;
import java.util.regex.Pattern;

public class Login {

    static Map<String, String> users = new HashMap<>(); 
    static final int MAX_ATTEMPTS = 3;


    public static void main(String[] args) {
        // Pre-populate with sample registered users
        users.put("test@example.com", "1234");
        users.put("admin@example.com", "admin123");

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== User Login ===");
            menu(sc);
        }
    }
    static void menu(Scanner sc) {
        while (true) {
            System.out.println("\n1. Login  2. Register  3. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> login(sc);
                case "2" -> register(sc);
                case "3" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void login(Scanner sc) {
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            String email = readEmail(sc);
            String password = readPassword(sc);

            if (loginUser(email, password)) {
                System.out.println("Login successful! Welcome back, " + email + ".");
                return;
            }

            attempts++;
            int remaining = MAX_ATTEMPTS - attempts;
            if (remaining > 0) {
                System.out.println("Invalid email or password. Attempts left: " + remaining);
            } else {
                System.out.println("Login failed. Too many attempts.");
            }
        }
    }

    static void register(Scanner sc) {
        String email = readEmail(sc);

        if (users.containsKey(email)) {
            System.out.println("An account with that email already exists.");
            return;
        }

        String password = readPassword(sc);
        if (password.length() < 4) {
            System.out.println("Password must be at least 4 characters.");
            return;
        }

        users.put(email, password);
        System.out.println("Registration successful! You can now log in.");
    }

    static String readEmail(Scanner sc) {
        String email;
        while (true) {
            System.out.print("Enter email: ");
            email = sc.nextLine().trim().toLowerCase();
            if (EMAIL_PATTERN.matcher(email).matches()) {
                return email;
            }
            System.out.println("Please enter a valid email address.");
        }
    }

    static String readPassword(Scanner sc) {
        System.out.print("Enter password: ");
        return sc.nextLine().trim();


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