import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BookLoader {
    private final String delimiter = ",";

    public List<Book> loadBooks(String filePatb) throws IOException {
        Path path = Path.of(filePatb);
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter, -1);

                if (fields.length >= 4) {
                    String isbn = fields[0].trim();
                    String title = fields[1].trim();
                    String author = fields[2].trim();
                    int pages = Integer.parseInt(fields[3].trim());
                    int identifier = Integer.parseInt(fields[4].trim());
                    books.add(new Book(author, title, isbn, pages, identifier));
                }
            }
        }
        return books;
    }
}
