import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    final Resource resource;
    final Member borrower;
    final LocalDate borrowDate;
    final private LocalDate dueDate;

    public Loan(Resource resource, Member borrower, LocalDate borrowDate){
        this.resource = resource;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        dueDate = borrowDate.plusDays(14);
    }

    //getters
    public Resource getResource(){return resource;}
    public Member getBorrower(){return borrower;}
    public LocalDate getDueDate(){return dueDate;}

    public boolean isOverdue(){
        return LocalDate.now().isAfter(dueDate);
    }

    public String toString() {
        return String.format("""
                %s
                Borrowed by: %s
                Due on: %s
                """, resource, borrower, dueDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Loan oLoan = (Loan) obj;
        return Objects.equals(resource, oLoan.resource) /*&&
                Objects.equals(borrower, oLoan.borrower)*/;
    }
}
