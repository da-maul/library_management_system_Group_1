import java.time.LocalDate;

public interface LoanPolicy {
    // true if the loan is allowed under this policy
    boolean canLoan();
    // the date the material must be returned, counted from borrowDate
    LocalDate calculateDueDate(LocalDate borrowDate);
}
