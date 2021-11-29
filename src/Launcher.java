import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue, tapez 'quit' pour quitter le programme");
        String quit = scanner.nextLine();
        if (!quit.equals("quit")) {
            System.out.println("Unknown command");
        }
    }
}