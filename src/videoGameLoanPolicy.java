import java.time.LocalDate;

public class videoGameLoanPolicy implements LoanPolicy{
    private static final int LOAN_DAYS = 30;
    private int currentCount;
    private int maxAllowed;

    public videoGameLoanPolicy(int currentCount, int maxAllowed){
        this.currentCount = currentCount;
        this.maxAllowed = maxAllowed;
    }

    @Override
    public boolean canLoan() {return currentCount < maxAllowed;}

    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate) {
        return borrowDate.plusDays(LOAN_DAYS);
    }
}
