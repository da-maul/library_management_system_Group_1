import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanLoader {
    private final String delimiter = ",";

    public List<Loan> loadLoans(String filePath, Library library) throws IOException {
        Path path = Path.of(filePath);
        List<Loan> loans = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter, -1);

                if (fields.length >= 4) {
                    int resourceId = Integer.parseInt(fields[0].trim());
                    int memberId = Integer.parseInt(fields[1].trim());
                    LocalDate borrowDate = LocalDate.parse(fields[2].trim());
                        LocalDate dueDate = LocalDate.parse(fields[3].trim());

                    Resource resource = library.getResource(resourceId);
                    Member borrower = library.getMember(memberId);


                    // Ensure both resource and borrower exist before adding the loan
                    if (resource != null && borrower != null) {
                        loans.add(new Loan(resource, borrower, borrowDate, dueDate));
                    } else {
                        IO.println("Error loading loan: Resource or borrower not found.");
                    }
                }
            }
        }
        return loans;
    }
}
