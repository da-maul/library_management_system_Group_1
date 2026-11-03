import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class VideoGameSaver {
    private final String delimiter = ",";

    public void saveVideoGames(List<VideoGame> videoGames, String filePath) throws IOException{
        Path path = Path.of(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (VideoGame videoGame : videoGames) {
                String line = videoGame.getStudio() + delimiter +
                        videoGame.getTitle() + delimiter +
                        videoGame.getEAN() + delimiter +
                        videoGame.getPlatform() + delimiter +
                        videoGame.getIdentifier();

                writer.write(line);
                writer.newLine();
            }
        }
    }
}