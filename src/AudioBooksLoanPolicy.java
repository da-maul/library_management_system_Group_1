import java.time.LocalDate;

public class AudioBooksLoanPolicy implements LoanPolicy{
    private static final int LOAN_DAYS = 14;

    @Override
    public boolean canLoan() {
        return true;
    }

    //TODO check if resource to be loaned is AudioBook, loan period set to 14 days if so. Otherwise 30 days as normal.
    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate) {
        return borrowDate.plusDays(LOAN_DAYS);
    }
}
