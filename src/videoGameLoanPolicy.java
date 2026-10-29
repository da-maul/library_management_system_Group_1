import java.time.LocalDate;

public class videoGameLoanPolicy implements LoanPolicy{
    private static final int LOAN_DAYS = 30;
    private int currentCount;
    private int maxAllowed;

    //TODO remove constructor, hard code loan policy values
    public videoGameLoanPolicy(int currentCount, int maxAllowed){
        this.currentCount = currentCount;
        this.maxAllowed = maxAllowed;
    }

    //TODO check if resource to be loaned is a VideoGame or not, enforce max limit only on games.
    @Override
    public boolean canLoan(Resource resource) {
        if(resource instanceof VideoGame){
            return currentCount < maxAllowed;
        }
        return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate,Resource resource) {
        return borrowDate.plusDays(LOAN_DAYS);
    }
}
