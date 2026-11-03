import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoGameLoader {
    private final String delimiter = ",";

    public List<VideoGame> videoGames(String filePatb) throws IOException {
        Path path = Path.of(filePatb);
        List<VideoGame> videoGames = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter, -1);

                if (fields.length >= 5) {
                    String studio = fields[0].trim();
                    String title = fields[1].trim();
                    long ean = Long.parseLong(fields[2].trim());
                    String platform = fields[3].trim();
                    int identifier = Integer.parseInt(fields[4].trim());

                    videoGames.add(new VideoGame(studio, title, ean, platform, identifier));
                }
            }
        }
        return videoGames;
    }
}
