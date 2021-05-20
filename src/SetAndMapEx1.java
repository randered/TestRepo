import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetAndMapEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        int numberOfEntries = Integer.parseInt(scanner.nextLine());
        while (numberOfEntries!=0){
            String entry = scanner.nextLine();
            if(!usernames.contains(entry)){
             usernames.add(entry);
            }
            numberOfEntries--;
        }
        for (String user: usernames) {
            System.out.println(user);
        }


    }
}
