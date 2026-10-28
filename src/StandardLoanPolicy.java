import java.time.LocalDate;

// The standard lending rule: everything can be borrowed, for 30 days.
public class StandardLoanPolicy implements LoanPolicy {
    private static final int LOAN_DAYS = 30;

    @Override
    public boolean canLoan(){
    return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate) {
        return borrowDate.plusDays(LOAN_DAYS);
    }
}
