import java.time.LocalDate;
import java.util.List;

public class videoGameLoanPolicy implements LoanPolicy{
    private static final int LOAN_DAYS = 30;
    private final int maxAllowed = 3;

    private final Library library;
    private final LibrarySearchHelper searchHelper;

    //Konstruktøren tager imod SeachHelper og medlemmets specifikke lån
    public videoGameLoanPolicy(Library library) {
        this.library = library;
        this.searchHelper = new LibrarySearchHelper(library);

    }
    //TODO check if resource to be loaned is a VideoGame or not, enforce max limit only on games.
    @Override
    public boolean canLoan(Resource resource,int memberID, List<Loan> Loans) {
        if(resource instanceof VideoGame){
            int currentGameCount = searchHelper.countLoansByResourceType(Loans, VideoGame.class);
            return currentGameCount < maxAllowed;
        }
        return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate,Resource resource) {
        return borrowDate.plusDays(LOAN_DAYS);
    }
}
