import inter.Command;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Freq implements Command {

    public String name() {
        return "freq";
    }

    public boolean run(Scanner scanner) {
        System.out.println("Entrez un chemin de fichier");
        String file = scanner.nextLine();
        Path PathFile = Paths.get(file);
        String word=null;
        ArrayList<String> wordsTab = new ArrayList<String>();
        try {
            word = Files.readString(PathFile);
        }
        catch (IOException e) {
            System.out.println("Unreadable file: "+e.getClass().getSimpleName()+" "+e.getMessage());
            return false;
        }
        String [] words = word.split(" ");
        for (int i=0; i<words.length;i++) {
            if (words[i].isBlank()) {
                continue;
            }
            words[i].toLowerCase();
            wordsTab.add(words[i]);
        }
        Map<String, Long> wordsCount = wordsTab.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()));
        List<Map.Entry<String, Long>> list = new ArrayList<>(wordsCount.entrySet());
        list.sort(Comparator.comparingLong(Map.Entry::getValue));
        for (int i=Math.max(list.size()-3, 0); i<list.size();i++) {
            System.out.println(list.get(i));
        }
        return false;
    }
}
