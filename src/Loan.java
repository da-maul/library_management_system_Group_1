import java.time.LocalDate;
import java.util.Objects;

// A single loan: who borrowed what, when, and when it must be returned.
// Loan only stores the values it is given; the due date is calculated
// by the LoanPolicy in Library before the Loan is created.
public class Loan {
    final Resource resource;
    final Member borrower;
    final LocalDate borrowDate;
    final private LocalDate dueDate;

    public Loan(Resource resource, Member borrower, LocalDate borrowDate,LocalDate dueDate){
        this.resource = resource;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    //getters
    public Resource getResource(){return resource;}
    public Member getBorrower(){return borrower;}
    public LocalDate getDueDate(){return dueDate;}

    // true if today is after the due date, meaning the material should be recalled
    public boolean isOverdue(){
        return LocalDate.now().isAfter(dueDate);
    }

    public String toString() {
        return String.format("""
                %s
                Borrowed by: %s
                Due on: %s
                """, resource, borrower,dueDate);
    }

    // Two loans are equal if they are for the same material, so a material can't be loaned out twice.
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Loan oLoan = (Loan) obj;
        return Objects.equals(resource, oLoan.resource) /*&&
                Objects.equals(borrower, oLoan.borrower)*/;
    }
}
