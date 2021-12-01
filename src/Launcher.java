import inter.Command;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Launcher {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Command> commands = new ArrayList<>();
        commands.add(new Freq());
        commands.add(new Quit());
        commands.add(new Fibo());
        commands.add(new Predict());
        System.out.println("Entrez une commande");
        String command = scanner.nextLine();
        boolean fin=false;
        do {
            for (int i=0; i<commands.size();i++) {
                if (commands.get(i).name().equals(command)) {
                    fin = commands.get(i).run(scanner);
                }
            }
        }
        while (!fin);
        System.out.println("Unknown command");
        scanner.nextLine();
    }
}