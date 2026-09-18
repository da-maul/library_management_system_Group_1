import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    final Book book;
    final Member borrower;
    final LocalDate borrowDate;
    final private LocalDate dueDate;

    public Loan(Book book, Member borrower, LocalDate borrowDate){
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        dueDate = borrowDate.plusDays(14);
    }

    //getters
    public Book getBook(){return book;}
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
                """, book, borrower, dueDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Loan oLoan = (Loan) obj;
        return Objects.equals(book, oLoan.book) /*&&
                Objects.equals(borrower, oLoan.borrower)*/;
    }
}
