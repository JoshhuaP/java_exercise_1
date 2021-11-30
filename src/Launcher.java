import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Launcher {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue, \ntapez 'quit' pour quitter le programme \nTapez 'fibo' pour découvrir la suite de Fibonacci\nTapez 'freq' pour découvrir les trois mots les plus fréquents dans un fichier texte");
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
            if (quit.equals("freq")) {
                System.out.println("Entrez un chemin de fichier");
                String file = scanner.nextLine();
                Path PathFile = Paths.get(file);
                String word=null;
                ArrayList<String> wordsTab = new ArrayList<String>();
                try {
                    word = Files.readString(PathFile);
                }
                catch (IOException e) {
                    System.out.println("Unreadable file: IOException ");
                    e.printStackTrace();
                    return;
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
                scanner.nextLine();
            }
            else {
                System.out.println("Unknown command");
            }
                quit = scanner.nextLine();
        }
    }
}