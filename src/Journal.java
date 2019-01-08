import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Journal {
    static Scanner input;
    static Entry entry;
    public static void main(String[] args) throws IOException {
        System.out.println("Name? ");
        String name = getInput();
        System.out.println("Entry? ");
        String body = getInput();
        entry = new Entry(name, body);
        showEntry(name, body);
    }
    public static String getInput() {
        input = new Scanner(System.in);
        String data = input.nextLine();
        String[] pieces = data.split("\\s+");
        String line = String.join(" ", pieces);
        return line;
    }
//    public static String getBody() {
//        input = new Scanner(System.in);
//        String data = input.nextLine();
//        String[] pieces = data.split("\\s+");
//        String line = String.join(" ", pieces);
//        return line;
//    }
    private static void showEntry(String user, String body) throws IOException {
        String userformatString = "%-4s\n";
        String bodyformatString = "%-4s";
        entry.writeFile();
        System.out.printf(userformatString, user);
        System.out.printf(bodyformatString, body);
    }
}
