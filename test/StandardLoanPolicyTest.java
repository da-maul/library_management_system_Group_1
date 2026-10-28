import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class StandardLoanPolicyTest {
    StandardLoanPolicy LoanPolicy = new StandardLoanPolicy();
    @Test
    void test(){
        LocalDate borrowDate = LocalDate.now();
        Book book = new Book("Allan B. Downey", "Think Java", "999-9-9999-9999-9", 324,1);
        Member joe = new Member("Joe Mama", 1337);
        Loan loan = new Loan(book,joe,);
    }
}
