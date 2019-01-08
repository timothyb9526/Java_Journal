import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Entry {
    String user;
    String body;

    public Entry(String user, String body) {
        this.user = user;
        this.body = body;
    }

//    private List<String> userArray() {
//        List<String> users = new ArrayList<String>();
//        return users;
//    }

//    public void writeFile(List<String> users) throws IOException {
//
//        if (users.contains(user)) {
//            String file = user + ".txt"
//            Files.write(file, body, Charset.forName("UTF-8"));
//        } else {
//            Path file = Paths.get(user + ".txt");
//
//        }
//    }
    public void writeFile() throws IOException {
        String file = user.replace(" ", "_") + ".txt";
        if (file.matches(file)) {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(file, true));
            out.write(body + "\n");
            out.close();
        } else {
            PrintWriter writer = new PrintWriter(file.toLowerCase(), "UTF-8");
            writer.println(body);
            writer.close();
        }
    }
}
