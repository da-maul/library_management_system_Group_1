import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AudioBookLoader {
    private final String delimiter = ",";

    public List<AudioBook> loadAudiobooks(String filePatb) throws IOException {
        Path path = Path.of(filePatb);
        List<AudioBook> audioBooks = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter, -1);

                if (fields.length >= 5) {
                    String isbn = fields[0].trim();
                    String title = fields[1].trim();
                    String author = fields[2].trim();
                    int durationMinutes = Integer.parseInt(fields[3].trim());
                    int identifier = Integer.parseInt(fields[4].trim());
                    audioBooks.add(new AudioBook(author, title, durationMinutes, isbn, identifier));
                }
            }
        }
        return audioBooks;
    }
}
