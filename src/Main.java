
void main() {

    LoanPolicy loanPolicy = new StandardLoanPolicy();
    LoanPolicy bornholmRegel = new AudioBooksLoanPolicy();
    //LoanPolicy aalborgRegel = new videoGameLoanPolicy(0, 3);

    Library library = new Library(loanPolicy);

    Book book1 = new Book("Allan B. Downey",
            "Think Java",
            "978-1-4028-9462-6", 324,1);
    Book book2 = new Book("Rachel Cusk",
            "Omrids",
            "732-5-2817-4127-6", 240,2);
    Book book3 = new Book("Yuval Noah Harari",
            "Sapiens",
            "832-6-9127-1258-3", 464,3);

    AudioBook audioBook = new AudioBook("Stephen King",
            "The Shining",
            360, "999-9-9999-9999-9", 4);

    //Test
    library.addResource(new VideoGame("Rockstar", "GTA 5", 85566909595L, "PC", 10));
    library.addResource(new VideoGame("Rockstar", "GTA 6", 544856869L, "PC", 11));
    library.addResource(new VideoGame("Nintendo", "Zelda", 443667L, "Switch", 12));
    library.addResource(new VideoGame("CD Projekt", "Witcher 3", 43555542L, "PC", 13));
    //Test



    library.addResource(audioBook);
    library.addResource(book1); library.addResource(book2); library.addResource(book3);

    Member joe = new Member("Joe Mama", 1337);
    Member hugh = new Member("Hugh Janus", 6969);
    Member ben = new Member("Ben Dover", 8008);

    library.addMember(joe); library.addMember(hugh); library.addMember(ben);


    //Tests -------------------
    IO.println("Standard-reglen:");
    IO.println("Resultat: " + library.loanIt(1, 1337));
    IO.println("Afleveringsfrist på lån: " + library.getLoan(1).getDueDate());
    IO.println();


    library.setLoanPolicy(bornholmRegel);
    library.returnIt(4);

    IO.println("Bornholm-reglen:");
    IO.println("Resultat: " + library.loanIt(4, 1337));
    IO.println("Afleveringsfrist på lån: " + library.getLoan(4).getDueDate());
    IO.println();
    IO.println("Aalborg-reglen (Test af mængdebegrænsning):");

    int maxCount = 3;
    int startID = 10;

    for (int id = startID; id <= 13; id++) {
        int gameLoanCount = 0;
        for (Loan loan : library.getLoansByMemberID(1337)) {
            if (loan.getResource() instanceof VideoGame || loan.getResource() instanceof Movie) {
                gameLoanCount++;
            }
        }
        //library.setLoanPolicy(new videoGameLoanPolicy(gameLoanCount, maxCount));
        LoanError result = library.loanIt(id, 1337);
        IO.println("Låner ID " + id + " | Spil i forvejen: " + gameLoanCount + " | Svar: " + result);
    }
    IO.println();

    // Tests -----------------------

    ConsoleUI console = new ConsoleUI(library);

    console.run();

}
