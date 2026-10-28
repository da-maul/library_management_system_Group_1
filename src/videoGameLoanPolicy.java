import java.time.LocalDate;

public class videoGameLoanPolicy implements LoanPolicy{
    private static final int LOAN_DAYS = 30;
    @Override
    public boolean canLoan() {
        if (loans > 3){
            return false;
        }
       else {
           return true;
        }
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate) {
        return borrowDate.plusDays(LOAN_DAYS);
    }
}
