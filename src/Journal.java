import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public abstract class Journal {
    static Scanner input;
    static Entry entry;
    public static void main(String[] args) throws IOException {
        operations();
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
    public static void operations() throws IOException {
        System.out.println("Name? ");
        String name = getInput();
        System.out.println("[R]ead or [W]rite? ");
        String choice = getInput();
        if (choice.equals("R")) {
            read(name);
        }else if (choice.equals("W")){
            write(name);
        } else{
            System.exit(0);
        }
    }
    public static void read(String name) throws IOException{
        String fileName = name.toLowerCase();
        File file = new File(fileName.replace(" ", "_") + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) !=null) System.out.println(st);
    }
    public static void write(String name) throws IOException {
        System.out.println("Entry? ");
        String body = getInput();
        entry = new Entry(name, body);
        showEntry(name, body);
    }
}
