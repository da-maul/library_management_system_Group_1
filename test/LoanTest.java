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
        Loan loan = new Loan(book1,joe, LocalDate.now());
        assertEquals(book1,loan.getResource());
        assertEquals(joe,loan.getBorrower());
        assertEquals(LocalDate.now(),loan.borrowDate);
    }
}
