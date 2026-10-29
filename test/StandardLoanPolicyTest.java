import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StandardLoanPolicyTest {
    LoanPolicy policy = new StandardLoanPolicy();


    @Test
    void canLoanAlwaysReturnsTrue(){
        Resource dummyResource = null; //da den er altid er true, kan man bare sende null
        int dummyMemberID = 1;
        List<Loan> dummyLoans = new ArrayList<>(); //En tom liste af lån
        assertTrue(policy.canLoan(dummyResource, dummyMemberID, dummyLoans));
    }

    @Test
    void dueDateIs30DaysAfterBorrowDate(){
        LocalDate borrowDate = LocalDate.of(2026, 10, 28);
        LocalDate expected = LocalDate.of(2026, 11, 27);
        assertEquals(expected, policy.calculateDueDate(borrowDate, null));
    }
}
