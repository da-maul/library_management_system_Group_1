import java.time.LocalDate;

public interface LoanPolicy {
    // true if the loan is allowed under this policy
    //Todo canLoan & calculateDueDate must take in resource parameter for logic in child policies.
    boolean canLoan(Resource resource);
    // the date the material must be returned, counted from borrowDate
    LocalDate calculateDueDate(LocalDate borrowDate,Resource resource);
}
