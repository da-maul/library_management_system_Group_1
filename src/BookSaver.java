import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BookSaver {
    private final String delimiter = ",";

    public void saveBooks(List<Book> books, String filePath) throws IOException{
        Path path = Path.of(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Book book : books) {
                String line = book.getISBN() + delimiter +
                        book.getTitle() + delimiter +
                        book.getCreator() + delimiter +
                        book.getPages() + delimiter +
                        book.getIdentifier();

                writer.write(line);
                writer.newLine();
            }
        }
    }
}
