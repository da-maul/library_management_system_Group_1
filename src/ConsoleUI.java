import java.util.ArrayList;

public class ConsoleUI {

    private final Library library;

    public ConsoleUI(Library library){
        this.library = library;
    }

    public void run(){
        boolean running = true;
        while (running){
            showMenu();
            int choice = Integer.parseInt(IO.readln("Input your choice:"));
            switch (choice){
                case 1 -> loanBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
                case 0 -> running = false;
                default -> IO.println("invalid input");
            }
        }
    }

    public void showLoans(){
        int memberID = Integer.parseInt(IO.readln("Please input your member ID:"));
        if (library.getLoansByMemberID(memberID).equals(new ArrayList<>())){
            IO.println("You have no active loans!");
        }
        else {
            IO.println(library.getLoansByMemberID(memberID));
        }
    }

    public void returnBook(){
        int bookID = Integer.parseInt(IO.readln("Please input the ID of the book to be returned:"));
        String returnerName = "";
        if (library.getLoan(bookID) != null){
        returnerName = library.getLoan(bookID).getBorrower().name();}
        if (library.returnBook(bookID)){
            IO.println(String.format("Thank you %s! %s was successfully returned!", returnerName,library.getBook(bookID).getTitle()));
        }
        else {IO.println("Sorry, that book is not loaned out, or there was some other error...");}
    }

    public void loanBook(){
        int bookID = Integer.parseInt(IO.readln("Input the book ID:"));
        int memberID = Integer.parseInt(IO.readln("Input your Membership ID:"));
        if (library.loanBook(bookID,memberID)){
            IO.println(String.format("Thank you for loaning %s, %s!",
                    library.getBook(bookID).getTitle(), library.getMember(memberID).name()));
        }
        else {IO.println("Sorry, there was an error, or that book is not available...");}
    }

    public void showMenu(){
        IO.println("""
                1: Loan Book
                2: Return Book
                3: Show all loans
                0: End Program""");
    }


}
