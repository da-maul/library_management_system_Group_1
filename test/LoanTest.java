import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class LoanTest {
    @Test
    void testLoanWithTitleCreatorAndID(){
        Book book1 = new Book("Allan B. Downey",
                "Think Java",
                "999-9-9999-9999-9", 324,1);
        assertEquals("Allan B. Downey",book1.getCreator());
        assertEquals("Think Java",book1.getTitle());
        assertEquals(1,book1.getIdentifier());
    }
    @Test
    void testLoanMemberAndDate(){
        Book book1 = new Book("Allan B. Downey",
                "Think Java",
                "999-9-9999-9999-9", 324,1);
        Member joe = new Member("Joe Mama", 1337);
        LocalDate borrowDate = LocalDate.of(2026, 10, 27);
        LocalDate dueDate = LocalDate.of(2026, 11, 26);
        Loan loan = new Loan(book1, joe, borrowDate, dueDate);
        assertEquals(book1,loan.getResource());
        assertEquals(joe,loan.getBorrower());
        assertEquals(LocalDate.now(),loan.borrowDate);
    }

    @Test
    void loansAreComparedByDueDate(){
        Book book1 = new Book("Allan B. Downey", "Think Java", "999-9-9999-9999-9", 324,1);
        Member joe = new Member("Joe Mama", 1337);
        LocalDate borrowDate = LocalDate.of(1900, 1, 1);
        LocalDate dueDate = LocalDate.of(1970, 1, 1);
        LocalDate dueDate2 = LocalDate.of(2000, 1, 1);
        Loan loan = new Loan(book1, joe, borrowDate, dueDate);
        Loan loan2 = new Loan(book1, joe, borrowDate, dueDate2);

        int comparisonResult = loan.compareTo(loan2);
        assertTrue(comparisonResult < 0);
    }

    @Test
    void loansOfSameDueDateAreNotSorted() {
        Book book1 = new Book("Allan B. Downey", "Think Java", "999-9-9999-9999-9", 324, 1);
        Member joe = new Member("Joe Mama", 1337);
        LocalDate borrowDate = LocalDate.of(1900, 1, 1);
        LocalDate dueDate = LocalDate.of(1970, 1, 1);
        Loan loan = new Loan(book1, joe, borrowDate, dueDate);
        Loan loan2 = new Loan(book1, joe, borrowDate, dueDate);

        int comparisonResult = loan.compareTo(loan2);
        assertEquals(0, comparisonResult);
    }


}
