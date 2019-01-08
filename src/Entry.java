import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Entry {
    String user;
    String body;

    public Entry(String user, String body) {
        this.user = user;
        this.body = body;
    }

    public void writeFile() throws IOException {
        String file = user.toLowerCase().replace(" ", "_") + ".txt";
        if (file.matches(file)) {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(file, true));
            DateFormat df = new SimpleDateFormat("EEE, MMM d yyyy h:mm:ss aa");
            Date today = Calendar.getInstance().getTime();
            String reportDate = df.format(today);
            out.write(reportDate + "\n");
            out.write(body + "\n\n");
            out.close();
        } else {
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.println(body);
            writer.close();
        }
    }
}
