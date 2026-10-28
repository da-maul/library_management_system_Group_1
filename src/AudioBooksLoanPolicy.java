import java.time.LocalDate;

public class AudioBooksLoanPolicy implements LoanPolicy{
    private static final int LOAN_DAYS = 14;
    @Override
    public boolean canLoan() {
        return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate) {
        return borrowDate.plusDays(LOAN_DAYS);
    }
}
