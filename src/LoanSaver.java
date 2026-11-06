import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LoanSaver {
    private final String delimiter = ",";

    public void saveLoans(List<Loan> loans, String filePath) throws IOException {
        Path path = Path.of(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Loan loan : loans) {
                String line = loan.getResource().getIdentifier() + delimiter +
                        loan.getBorrower().ID() + delimiter +
                        loan.borrowDate + delimiter +
                        loan.getDueDate();
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
