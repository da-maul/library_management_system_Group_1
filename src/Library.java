import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
// The library: keeps track of all materials, members and active loans.
public class Library {

    // Typed as the interface, so another policy can be swapped in here without changing the rest of Library.
    LoanPolicy loanPolicy = new StandardLoanPolicy();

    //TODO add LoanPolicy object variable.
    private final List<Resource> resources = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<Loan> loans = new ArrayList<>();

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
        // Loan.equals compares materials, so this finds an existing loan of the same material
        if (loans.contains(newLoan)){return LoanError.LOANED_OUT;}
        loans.add(newLoan);
        return LoanError.SUCCESS;
    }

    // Ends the loan of the material. Returns false if the material isn't loaned out.
    public boolean returnIt(int resourceID){
        for (Loan loan : loans){
            if (loan.getResource().getIdentifier() == resourceID){
                // return right away: removing from a list while the loop keeps going would crash
                loans.remove(loan); return true;
            }
        }
        return false;
    }

    // All active loans for one member. Returns an empty list if the member has none.
    public List<Loan> getLoansByMemberID(int memberID){
        List<Loan> returnList = new ArrayList<>();
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
    public List<Resource> getResources(){return resources;}
    public List<Member> getMembers() {return members;}
    public List<Loan> getLoans() {return loans;}

    // The material with the given ID, or null if there is none.
    public Resource getResource(int resourceID){
        for (Resource resource : resources){
            if (resource.getIdentifier() == resourceID){
                return resource;
            }
        }
        return null;
    }
    // The member with the given ID, or null if there is none.
    public Member getMember(int memberID){
        for (Member member : members){
            if (member.ID() == memberID){return member;}
        }
        return null;
    }
    // The active loan of the material, or null if it isn't loaned out.
    public Loan getLoan(int resourceID){
        for (Loan loan : loans){
            if (loan.getResource().getIdentifier() == resourceID){return loan;}
        }
        return null;
    }

    // Two libraries are equal if they have the same materials, members and loans. For the test
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
