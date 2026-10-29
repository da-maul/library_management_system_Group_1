import java.util.List;

public class LibrarySearchHelper {

    public LibrarySearchHelper() {
    }

    // Gennemser en liste af eksisterende lån og tæller, hvor mange der matcher en specifik ressourcetype.
    public int countLoansByResourceType(List<Loan> memberLoans, Class<? extends Resource> resourceType) {
        int count = 0;
        for (Loan loan : memberLoans) {
            //Tjekker om lånets resouce matcher den specifikke type (f.eks. videoGame)
            if (loan.getResource() != null && resourceType.isInstance(loan.getResource())) {
                count++;
            }
        }
        return count;
    }
}

