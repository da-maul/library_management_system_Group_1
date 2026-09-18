import java.time.LocalDate;
import java.util.ArrayList;
public class Library {

    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<Member> members = new ArrayList<>();
    private final ArrayList<Loan> loans = new ArrayList<>();

    public boolean loanBook(int bookID, int memberID){
        if (!books.contains(getBook(bookID))) return false;
        if (!members.contains(getMember(memberID))){return false;}
        Loan newLoan = new Loan(getBook(bookID),getMember(memberID),LocalDate.now());
        if (loans.contains(newLoan)){return false;}
        loans.add(newLoan);
        return true;
    }

    public boolean returnBook(int bookID){
        for (Loan loan : loans){
            if (loan.getBook().ID() == bookID){
                loans.remove(loan); return true;
            }
        }
        return false;
    }

    public ArrayList<Loan> getLoansByMemberID(int memberID){
        ArrayList<Loan> returnList = new ArrayList<>();
        for (Loan loan : loans){
            if (loan.getBorrower().ID() == memberID){
                returnList.add(loan);
            }
        }
        return returnList;
    }

    //printers
    public void printBooks(){IO.println(books.toString());}
    public void printMembers(){IO.println(members.toString());}
    public void printLoans(){IO.println(loans.toString());}

    //setters
    public void addBook(Book book){books.add(book);}
    public void addMember(Member member){members.add(member);}
    //getters
    public ArrayList<Book> getBooks(){return books;}
    public ArrayList<Member> getMembers() {return members;}
    public ArrayList<Loan> getLoans() {return loans;}

    public Book getBook(int bookID){
        for (Book book : books){
            if (book.ID() == bookID){
                return book;
            }
        }
        return null;
    }
    public Member getMember(int memberID){
        for (Member member : members){
            if (member.ID() == memberID){return member;}
        }
        return null;
    }
    public Loan getLoan(int bookID){
        for (Loan loan : loans){
            if (loan.getBook().ID() == bookID){return loan;}
        }
        return null;
    }
}
