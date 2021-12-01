import inter.Command;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quit implements Command {
    Scanner scanner = new Scanner(System.in);
    List<Command> commands = new ArrayList<>();

    public String name() {
        return "quit";
    }

    public boolean run(Scanner scanner) {
        return scanner.nextLine().equals("quit");
    }
}
