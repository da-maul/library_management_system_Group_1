import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AudioBookLoader {
    private final String delimiter = ",";

    public List<AudioBook> loadAudioBooks(String filename) throws IOException {
        Path path = Path.of(filename);
        List<AudioBook> audioBooks = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter, -1);
                audioBooks.add(new AudioBook(
                        fields[0],
                        fields[1],
                        Integer.parseInt(fields[2]),
                        fields[3],
                        Integer.parseInt(fields[4])));
            }
        }
        return audioBooks;
    }
}
