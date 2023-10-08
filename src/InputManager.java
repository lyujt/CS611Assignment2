import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    private final Scanner scanner;

    // default constructor
    public InputManager() {
        scanner = new Scanner(System.in);
    }

    // handle input type error for int
    public int getInt() {
        while(true) {
            try {
                int ret = scanner.nextInt();
                scanner.nextLine();
                return ret;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format. Try again.");
                scanner.nextLine();
            }
        }
    }

    // handle input type error for string
    public String getString() {
        while(true) {
            try {
                return scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format. Try again.");
            }
        }
    }
}
