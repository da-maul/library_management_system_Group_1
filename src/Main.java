
void main() {

    LoanPolicy loanPolicy = new StandardLoanPolicy();
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


    AudioBook audioBook = new AudioBook("Stephen King", "The Shining", 360, "999-9-9999-9999-9", 4);
    library.addResource(audioBook);

    library.addResource(book1); library.addResource(book2); library.addResource(book3);

    Member joe = new Member("Joe Mama", 1337);
    Member hugh = new Member("Hugh Janus", 6969);
    Member ben = new Member("Ben Dover", 8008);

    library.addMember(joe); library.addMember(hugh); library.addMember(ben);

    ConsoleUI console = new ConsoleUI(library);

    console.run();

}