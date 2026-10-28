import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class StandardLoanPolicyTest {
    LoanPolicy policy = new StandardLoanPolicy();

    @Test
    void canLoanAlwaysReturnsTrue(){
        assertTrue(policy.canLoan());
    }

    @Test
    void dueDateIs30DaysAfterBorrowDate(){
        LocalDate borrowDate = LocalDate.of(2026, 10, 28);
        LocalDate expected = LocalDate.of(2026, 11, 27);
        assertEquals(expected, policy.calculateDueDate(borrowDate));
    }
}
