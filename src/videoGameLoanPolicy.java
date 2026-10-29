import java.time.LocalDate;
import java.util.List;

public class videoGameLoanPolicy implements LoanPolicy{
    private static final int LOAN_DAYS = 30;
    private final int maxAllowed = 3;

    private final Library library;
    private final int memberID;
    private final LibrarySearchHelper searchHelper;

    //Konstruktøren tager imod SeachHelper og medlemmets specifikke lån
    public videoGameLoanPolicy(Library library, int memberID) {
        this.library = library;
        this.memberID = memberID;
        this.searchHelper = new LibrarySearchHelper(library);

    }
    //TODO check if resource to be loaned is a VideoGame or not, enforce max limit only on games.
    @Override
    public boolean canLoan(Resource resource) {
        if(resource instanceof VideoGame){
            //Vi henter bare lånene direkte fra library
            List<Loan> memberLoans = library.getLoansByMemberID(memberID);
            int currentGameCount = searchHelper.countLoansByResourceType(memberLoans, VideoGame.class);
            return currentGameCount < maxAllowed;
        }
        return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate,Resource resource) {
        return borrowDate.plusDays(LOAN_DAYS);
    }
}
