import java.time.LocalDate;

// The standard lending rule: everything can be borrowed, for 30 days.
public class StandardLoanPolicy implements LoanPolicy {
    private static final int LOAN_DAYS = 30;

    @Override
    public boolean canLoan(Resource resource){
    return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate,Resource resource) {
        return borrowDate.plusDays(LOAN_DAYS);
    }
}
