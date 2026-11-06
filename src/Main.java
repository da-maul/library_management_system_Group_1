
void main() throws IOException {
    List<Resource> resources = new ArrayList<>();

    LoanPolicy loanPolicy = new StandardLoanPolicy();
    LoanPolicy bornholmRegel = new AudioBooksLoanPolicy();
    LoanPolicy aalborgRegel = new videoGameLoanPolicy();

    Library library = new Library(loanPolicy);

    //TODO tilføj loansaver og loader
    if (Files.exists(Path.of("Loans.csv")));
        LoanLoader loanLoader = new LoanLoader();






    if (Files.exists(Path.of("books.csv"))) {
        BookLoader bookLoader = new BookLoader();
        for (Book book : bookLoader.loadBooks("books.csv")) {
            library.addResource(book);
        }
    } else {
        library.addResource(new Book("Allan B. Downey", "Think Java", "978-1-4028-9462-6", 324, 1));
        library.addResource(new Book("Rachel Cusk", "Omrids", "732-5-2817-4127-6", 240, 2));
        library.addResource(new Book("Yuval Noah Harari", "Sapiens", "832-6-9127-1258-3", 464, 3));
    }

    if (Files.exists(Path.of("audiobooks.csv"))) {
        AudioBookLoader audioBookLoader = new AudioBookLoader();
        for (AudioBook audioBook : audioBookLoader.loadAudiobooks("audiobooks.csv")) {
            library.addResource(audioBook);
        }
    } else {
        library.addResource(new AudioBook("Stephen King", "The Shining", 360, "999-9-9999-9999-9", 4));
    }

    if (Files.exists(Path.of("videogames.csv"))) {
        VideoGameLoader videoGameLoader = new VideoGameLoader();
        for (VideoGame videoGame : videoGameLoader.videoGames("videogames.csv")) {
            library.addResource(videoGame);
        }
    } else {
        library.addResource(new VideoGame("Rockstar", "GTA 5", 85566909595L, "PC", 10));
        library.addResource(new VideoGame("Rockstar", "GTA 6", 544856869L, "PC", 11));
        library.addResource(new VideoGame("Nintendo", "Zelda", 443667L, "Switch", 12));
        library.addResource(new VideoGame("CD Projekt", "Witcher 3", 43555542L, "PC", 13));
    }

    //der er ingen film i startdata, så de indlæses kun, hvis filen findes
    if (Files.exists(Path.of("movies.csv"))) {
        MovieLoader movieLoader = new MovieLoader();
        for (Movie movie : movieLoader.loadMovies("movies.csv")) {
            library.addResource(movie);
        }
    }

    if (Files.exists(Path.of("members.csv"))) {
        MemberLoader memberLoader = new MemberLoader();
        List<Member> members = memberLoader.loadMembers("members.csv");
        for (Member member : members) {
            library.addMember(member);
        }
    } else {
        Member joe = new Member("Joe Mama", 1337);
        Member hugh = new Member("Hugh Janus", 6969);
        Member ben = new Member("Ben Dover", 8008);
        library.addMember(joe); library.addMember(hugh); library.addMember(ben);
    }

    if (Files.exists(Path.of("loans.csv"))) {
        LoanLoader loanLoader = new LoanLoader();
        List<Loan> loans = loanLoader.loadLoans("loans.csv", library);
        for (Loan loan : loans) {
            int memberId = loan.getBorrower().ID();
            int resourceId = Math.toIntExact(loan.getResource().getIdentifier());
            library.loanIt(resourceId, memberId);
        }
    }


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

    int startID = 10;

    for (int id = startID; id <= 13; id++) {
        int gameLoanCount = 0;
        for (Loan loan : library.getLoansByMemberID(1337)) {
            if (loan.getResource() instanceof VideoGame) {
                gameLoanCount++;
            }
        }
        library.setLoanPolicy(aalborgRegel);
        LoanError result = library.loanIt(id, 1337);
        IO.println("Låner ID " + id + " | Spil i forvejen: " + gameLoanCount + " | Svar: " + result);
    }
    IO.println();

    // Tests -----------------------

//    ConsoleUI console = new ConsoleUI(library);
//
//    console.run();

    //gem members til csv filen til sidst, så ændringer kommer med
    MemberSaver memberSaver = new MemberSaver();
    memberSaver.saveMembers(library.getMembers(),"members.csv");

    //sorter materialerne efter type, så hver type kan gemmes i sin egen fil
    List<Book> books = new ArrayList<>();
    List<AudioBook> audioBooks = new ArrayList<>();
    List<VideoGame> videoGames = new ArrayList<>();
    List<Movie> movies = new ArrayList<>();
    for (Resource resource : library.getResources()) {
        if (resource instanceof Book book) {books.add(book);}
        else if (resource instanceof AudioBook audioBook) {audioBooks.add(audioBook);}
        else if (resource instanceof VideoGame videoGame) {videoGames.add(videoGame);}
        else if (resource instanceof Movie movie) {movies.add(movie);}
    }

    new BookSaver().saveBooks(books, "books.csv");
    new AudioBookSaver().saveAudioBooks(audioBooks, "audiobooks.csv");
    new VideoGameSaver().saveVideoGames(videoGames, "videogames.csv");
    new MovieSaver().saveMovies(movies, "movies.csv");
    new LoanSaver().saveLoans(library.getLoans(), "loans.csv");
}
