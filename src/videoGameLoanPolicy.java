import java.time.LocalDate;

public class videoGameLoanPolicy implements LoanPolicy{
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
        return borrowDate.plusDays(30);
    }
}
