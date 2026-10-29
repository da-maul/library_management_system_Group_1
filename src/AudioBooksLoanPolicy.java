import java.time.LocalDate;
import java.util.List;

public class AudioBooksLoanPolicy implements LoanPolicy{
   int AUDIOBOOK_LOAN_DAYS = 14;
   int STANDARD_LOAN_DAYS = 30;

    @Override
    public boolean canLoan(Resource resource,int memberID, List<Loan> Loans) {
        return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate,Resource resource) {
        if (resource instanceof AudioBook){
            return borrowDate.plusDays(AUDIOBOOK_LOAN_DAYS);
        }
        return borrowDate.plusDays(STANDARD_LOAN_DAYS);
    }
}
