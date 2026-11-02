import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanLoader {
    private final String delimiter = ",";

    public List<Loan> loadLoans(String filePatb) throws IOException {
        Path path = Path.of(filePatb);
        List<Loan> loans = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter, -1);

                if (fields.length >= 4) {
                    int memberId = Integer.parseInt(fields[0].trim());
                    int identifier = Integer.parseInt(fields[1].trim());
                    LocalDate borrowDate =  LocalDate.parse(fields[2].trim());
                    LocalDate dueDate = LocalDate.parse(fields[3].trim());

                    Member borrower = new Member("", memberId);
                    Resource resource = new Book("", "", "", 0, identifier);

                    loans.add(new Loan(resource, borrower, borrowDate, dueDate));
                }
            }
        }
        return loans;
    }
}
