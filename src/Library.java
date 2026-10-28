import java.time.LocalDate;
import java.util.ArrayList;
public class Library {

    LoanPolicy loanPolicy = new StandardLoanPolicy();

    //TODO add LoanPolicy object variable.
    private final ArrayList<Resource> resources = new ArrayList<>();
    private final ArrayList<Member> members = new ArrayList<>();
    private final ArrayList<Loan> loans = new ArrayList<>();

    //TODO loanIt must obey LoanPolicy object's rules.
    public LoanError loanIt(int resourceID, int memberID){
        //TODO initialize loan policy at this point, save params.
        // return new exit condition based on invalidity due to LoanPolicy rules
        if (!resources.contains(getResource(resourceID))) return LoanError.RESOURCE_NOT_FOUND;
        if (!members.contains(getMember(memberID))){return LoanError.MEMBER_NOT_FOUND;}
        //TODO newLoan takes params from LoanPolicy
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = loanPolicy.calculateDueDate(borrowDate);
        Loan newLoan = new Loan(getResource(resourceID), getMember(memberID), borrowDate, dueDate);
        if (loans.contains(newLoan)){return LoanError.LOANED_OUT;}
        loans.add(newLoan);
        return LoanError.SUCCESS;
    }

    public boolean returnIt(int resourceID){
        for (Loan loan : loans){
            if (loan.getResource().getIdentifier() == resourceID){
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
    public void printResources(){IO.println(resources.toString());}
    public void printMembers(){IO.println(members.toString());}
    public void printLoans(){IO.println(loans.toString());}

    //setters
    public void addResource(Resource resource){resources.add(resource);}
    public void addMember(Member member){members.add(member);}
    public void addBook(Book book){resources.add(book);}
    public void addMovie(Movie movie){resources.add(movie);}
    public void addAudiobook(AudioBook audioBook){resources.add(audioBook);}
    public void addVideoGame(VideoGame videoGame){resources.add(videoGame);}

    //getters
    public ArrayList<Resource> getResources(){return resources;}
    public ArrayList<Member> getMembers() {return members;}
    public ArrayList<Loan> getLoans() {return loans;}

    public Resource getResource(int resourceID){
        for (Resource resource : resources){
            if (resource.getIdentifier() == resourceID){
                return resource;
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
    public Loan getLoan(int resourceID){
        for (Loan loan : loans){
            if (loan.getResource().getIdentifier() == resourceID){return loan;}
        }
        return null;
    }

    @Override
    public boolean equals(Object maybeLibrary) {
        if (maybeLibrary instanceof Library otherLibrary){
            return (getResources().equals(otherLibrary.getResources()) &&
                    getMembers().equals(otherLibrary.getMembers()) &&
                    getLoans().equals(otherLibrary.getLoans()));
        }
        else {return false;}
    }
}
