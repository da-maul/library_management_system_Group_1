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
                case 1 -> loanIt();
                case 2 -> returnIt();
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

    public void returnIt(){
        int resourceID = Integer.parseInt(IO.readln("Please input the ID of the media to be returned:"));
        String returnerName = "";
        if (library.getLoan(resourceID) != null){
        returnerName = library.getLoan(resourceID).getBorrower().name();}
        if (library.returnIt(resourceID)){
            IO.println(String.format("Thank you %s! %s was successfully returned!", returnerName,library.getResource(resourceID).getTitle()));
        }
        else {IO.println("Sorry, that media is not loaned out, or there was some other error...");}
    }

    public void loanIt(){
        int resourceID = Integer.parseInt(IO.readln("Input the ID of the media to be borrowed:"));
        int memberID = Integer.parseInt(IO.readln("Input the Membership ID:"));
        //TODO fix this shit and make it a switch statement that uses the enums from loanIt
        switch (library.loanIt(resourceID,memberID));

            IO.println(String.format("Thank you for loaning %s, %s!",
                    library.getResource(resourceID).getTitle(), library.getMember(memberID).name()));
        }
        else {IO.println("Sorry, there was an error, or that media is not available...");}
    }

    public void showMenu(){
        IO.println("""
                1: Loan media
                2: Return media
                3: Show all loans
                0: End Program""");
    }


}
