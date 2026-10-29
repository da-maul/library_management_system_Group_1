import java.time.LocalDate;
import java.util.List;

class TestDoubleLoanPolicy implements LoanPolicy {
    public boolean canLoanWasCalled = false;
    public boolean calculateDueDateWasCalled = false;

    @Override
    public boolean canLoan(Resource resource, int memberID, List<Loan> Loans) {
        canLoanWasCalled = true;
        return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowDate, Resource resource) {
        calculateDueDateWasCalled = true;
        return borrowDate;
    }
}