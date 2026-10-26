import java.time.LocalDate;

public interface LoanPolicy {
    boolean canLoan();
    LocalDate calculateDueDate();
}
