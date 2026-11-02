import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MovieSaver {
    private final String delimiter = ",";

    public void saveMovies(List<Movie> movies, String filename) throws IOException{
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Movie movie : movies) {
                writer.write(movie.getTitle() + delimiter + movie.getLengthInMinutes() + delimiter + movie.getDirector() + delimiter + movie.getCreator());
                writer.newLine();
            }
        }
    }
}
