import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//TODO A valid loan succeeds ✓
//TODO unknown resource ID cannot be loaned out ✓
//TODO unknown member ID cannot loan ✓
//TODO loaned-out material cannot be loaned again ✓
//TODO loaned-out material can be returned and loaned ✓
//TODO loaned-out material can only be returned if a loan exists ✓
//TODO invalid operations do not corrupt library
class LibraryTests {

    Library testLibrary = new Library();

    @BeforeEach
    void resetLibrary(){
        testLibrary = new Library();
    }

    @Test
    void validLoanSucceeds() {
        testLibrary.addBook(new Book("Author","Title","999-9-9999-9999-9",100,1));
        testLibrary.addMember(new Member("Name",1));
        LoanError loanResult = testLibrary.loanIt(1,1);
        assertEquals(LoanError.SUCCESS, loanResult);
    }

    @Test
    void invalidResourceCannotBeLoaned(){
        testLibrary.addBook(new Book("Author","Title","999-9-9999-9999-9",100,1));
        testLibrary.addMember(new Member("Name",1));
        LoanError loanResult = testLibrary.loanIt(2,1);
        assertEquals(LoanError.RESOURCE_NOT_FOUND, loanResult);
    }

    @Test
    void invalidMemberCannotLoan(){
        testLibrary.addBook(new Book("Author","Title","999-9-9999-9999-9",100,1));
        testLibrary.addMember(new Member("Name",1));
        LoanError loanResult = testLibrary.loanIt(1,2);
        assertEquals(LoanError.MEMBER_NOT_FOUND, loanResult);
    }

    @Test
    void loanedResourceCannotBeLoaned(){
        testLibrary.addBook(new Book("Author","Title","999-9-9999-9999-9",100,1));
        testLibrary.addMember(new Member("Name",1));
        testLibrary.loanIt(1,1);
        LoanError loanResult = testLibrary.loanIt(1,1);
        assertEquals(LoanError.LOANED_OUT, loanResult);
    }

    @Test
    void returnedResourceCanBeLoaned(){
        testLibrary.addBook(new Book("Author","Title","999-9-9999-9999-9",100,1));
        testLibrary.addMember(new Member("Name",1));
        testLibrary.loanIt(1,1);
        testLibrary.returnIt(1);
        LoanError loanResult = testLibrary.loanIt(1,1);
        assertEquals(LoanError.SUCCESS, loanResult);
    }

    @Test
    void resourceCanOnlyBeReturnedIfLoaned() {
        testLibrary.addBook(new Book("Author", "Title", "999-9-9999-9999-9", 100, 1));
        testLibrary.addMember(new Member("Name", 1));
        boolean loanResult = testLibrary.returnIt(1);
        assertFalse(loanResult);
    }

    @Test
    void invalidOperationsDoNotCorruptLibrary() {
        Library patternLibrary = new Library();
        patternLibrary.addBook(new Book("Author","Title","999-9-9999-9999-9",100,1));
        patternLibrary.addMember(new Member("Name",1));

        testLibrary.addBook(new Book("Author","Title","999-9-9999-9999-9",100,1));
        testLibrary.addMember(new Member("Name",1));

        testLibrary.loanIt(3,1);
        testLibrary.loanIt(1,3);
        testLibrary.returnIt(1);

        assertEquals(patternLibrary, testLibrary);
    }

}