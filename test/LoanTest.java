import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

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
        LocalDate borrowDate = LocalDate.of(2026, 11, 27);
        LocalDate dueDate = LocalDate.of(2026, 11, 26);
        Loan loan = new Loan(book1, joe, borrowDate, dueDate);
        assertEquals(book1,loan.getResource());
        assertEquals(joe,loan.getBorrower());
        assertEquals(LocalDate.now(),loan.borrowDate);
    }

    @Test
    void LoanDateComparatorTest(){
        Book book1 = new Book("J.K. Rowling", "Harry Potter", "999-9-9999-9999-9", 100, 1);
        Member anton = new Member("Anton", 1336);
        LocalDate borrowDate1 = LocalDate.of(2026, 11, 27);
        LocalDate dueDate1 = LocalDate.of(2026, 11, 26);

        Book book2 = new Book("William Shakespeare", "Hamlet", "999-9-9999-9999-9", 200, 2);
        Member alex = new Member("Alex", 1338);
        LocalDate borrowDate2 = LocalDate.of(2026, 11, 2);
        LocalDate dueDate2 = LocalDate.of(2026, 11, 23);

        Book book3 = new Book("Stephen King", "IT", "999-9-9999-9999-9", 300, 3);
        Member marcus = new Member("Marcus", 1339);
        LocalDate borrowDate3 = LocalDate.of(2026, 11, 7);
        LocalDate dueDate3 = LocalDate.of(2026, 11, 28);

        Book book4 = new Book("Agatha Christie", "Queen of crime", "999-9-9999-9999-9", 400, 4);
        Member mads = new Member("Mads", 1340);
        LocalDate borrowDate4 = LocalDate.of(2026, 12, 25);
        LocalDate dueDate4 = LocalDate.of(2027, 1, 16);

        ArrayList<Loan> Loandate = new ArrayList<>();
        Loandate.add(new Loan(book1, anton, borrowDate1, dueDate1));
        Loandate.add(new Loan(book2, alex, borrowDate2, dueDate2));
        Loandate.add(new Loan(book3, marcus, borrowDate3, dueDate3));
        Loandate.add(new Loan(book4, mads, borrowDate4, dueDate4));

        IO.print("Før: " + Loandate.toString());

        Collections.sort(Loandate, new LoanDateComparator());
        Loandate.sort(new LoanDateComparator());

        IO.print("\nEfter: " + Loandate.toString());
    }
}
