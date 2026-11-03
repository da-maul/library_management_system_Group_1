import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class AudioBookSaver {
    private final String delimiter = ",";

    public void saveAudioBooks(List<AudioBook> audioBooks, String filename) throws IOException{
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AudioBook audioBook : audioBooks) {
                String line = audioBook.getCreator() + delimiter +
                        audioBook.getTitle() + delimiter +
                        audioBook.getLengthInMinutes() + delimiter +
                        audioBook.getISBN() + delimiter +
                        audioBook.getIdentifier();
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
