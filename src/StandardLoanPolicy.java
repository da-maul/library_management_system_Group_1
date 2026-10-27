import java.time.LocalDate;

public class StandardLoanPolicy implements LoanPolicy {
    private static final int LOAN_DAYS = 30;
    private LocalDate borrowDate;

    @Override
    public boolean canLoan(){
    return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate) {
        return borrowDate.plusDays(LOAN_DAYS);
    }
}
