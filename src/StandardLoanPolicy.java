import java.time.LocalDate;
import java.util.List;

// The standard lending rule: everything can be borrowed, for 30 days.
public class StandardLoanPolicy implements LoanPolicy {
    private static final int LOAN_DAYS = 30;

    @Override
    public boolean canLoan(Resource resource,int memberID, List<Loan> Loans){
    return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate,Resource resource) {
        return borrowDate.plusDays(LOAN_DAYS);
    }
}
