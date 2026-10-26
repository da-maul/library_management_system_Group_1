import java.time.LocalDate;

public class StandardLoanPolicy implements LoanPolicy {
    private static final int LOAN_DAYS = 30;
    @Override
    public boolean canLoan(){
    return true;
    }

    @Override
    public LocalDate calculateDueDate() {
        dueDate = borrowDate.plusDays(LOAN_DAYS);
    }
}
