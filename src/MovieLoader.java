import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieLoader {
    private final String delimiter = ",";

    public List<Movie> loadMovies(String filename) throws IOException {
        Path path = Path.of(filename);
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter, -1);
                movies.add(new Movie(
                        fields[0],
                        fields[1],
                        Long.parseLong(fields[2]),
                        fields[3],
                        Integer.parseInt(fields[4]),
                        Integer.parseInt(fields[5])));
            }
        }
        return movies;
    }
}
