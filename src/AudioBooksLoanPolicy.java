import java.time.LocalDate;

public class AudioBooksLoanPolicy implements LoanPolicy{
   int AUDIOBOOK_LOAN_DAYS = 14;
   int STANDARD_LOAN_DAYS = 30;

    @Override
    public boolean canLoan(Resource resource) {
        return true;
    }

    //TODO check if resource to be loaned is AudioBook, loan period set to 14 days if so. Otherwise 30 days as normal.
    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate,Resource resource) {
        if (resource instanceof AudioBook){
            return borrowDate.plusDays(AUDIOBOOK_LOAN_DAYS);
        }
        return borrowDate.plusDays(STANDARD_LOAN_DAYS);
    }
}
