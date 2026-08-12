import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Register {
   static Map<String, String> users = new HashMap<>(); // email -> password
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.println("=== User Registration ===");
        System.out.print("Enter name: ");
        String name = sc.nextLine();
 
        System.out.print("Enter email: ");
        String email = sc.nextLine();
 
        System.out.print("Enter password: ");
        String password = sc.nextLine();
 
        boolean success = registerUser(name, email, password);
 
        if (success) {
            System.out.println("Registration successful! Welcome, " + name + ".");
        } else {
            System.out.println("Registration failed: email already exists.");
        }
 
        sc.close();
    }
 
    static boolean registerUser(String name, String email, String password) {
        if (users.containsKey(email)) {
            return false;
        }
        users.put(email, password);
        return true;
    } 
}
