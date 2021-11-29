import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue, \ntapez 'quit' pour quitter le programme \nTapez 'fibo' pour découvrir la suite de Fibonacci");
        String quit = scanner.nextLine();
        while (!quit.equals("quit")) {
            if (quit.equals("fibo")) {
                System.out.println("Entrez une valeur de n");
                int n = scanner.nextInt();
                int Fibo=0;
                int F0=0;
                int F1=1;
                int F2;
                int i=2;
                if (n == 0) Fibo = F0;
                if (n == 1) Fibo = F1;
                while(i < n) {
                    F2 = F0+F1;
                    F0 = F1;
                    F1 = F2;
                    Fibo = F2;
                    i++;
                }
                System.out.println("Le résultat correspondant est le suivant : "+Fibo);
                scanner.nextLine();
            }
            else {
                System.out.println("Unknown command");
            }
                quit = scanner.nextLine();
        }
    }
}