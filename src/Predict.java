import inter.Command;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Predict implements Command {

    public String name() {
        return "predict";
    }
    public boolean run(Scanner scanner) {
        System.out.println("Entrez un chemin de fichier");
        String file = scanner.nextLine();
        Path PathFile = Paths.get(file);
        String word=null;
        try {
            word = Files.readString(PathFile);
        }
        catch (IOException e) {
            System.out.println("Unreadable file: "+e.getClass().getSimpleName()+" "+e.getMessage());
            return false;
        }

        return false;
    }
}
