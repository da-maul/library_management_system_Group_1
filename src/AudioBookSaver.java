import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AudioBookSaver {
    private final String delimiter = ",";

    public void saveAudioBooks(List<AudioBook> audioBooks, String filePath) throws IOException{
        Path path = Path.of(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AudioBook audioBook : audioBooks) {
                String line = audioBook.getISBN() + delimiter +
                        audioBook.getTitle() + delimiter +
                        audioBook.getCreator() + delimiter +
                        audioBook.getLengthInMinutes() + delimiter +
                        audioBook.getIdentifier();

                writer.write(line);
                writer.newLine();
            }
        }
    }
}
