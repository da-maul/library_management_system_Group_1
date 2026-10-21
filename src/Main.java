
void main() {

    Library library = new Library();

    Book book1 = new Book("Allan B. Downey",
            "Think Java",
            "9781492072508", 1, 324);
    Book book2 = new Book("Rachel Cusk",
            "Omrids",
            "9788763851664", 2, 240);
    Book book3 = new Book("Yuval Noah Harari",
            "Sapiens",
            "9780062316097", 3, 464);


    library.addBook(book1); library.addBook(book2); library.addBook(book3);

    Member joe = new Member("Joe Mama", 1337);
    Member hugh = new Member("Hugh Janus", 6969);
    Member ben = new Member("Ben Dover", 8008);

    library.addMember(joe); library.addMember(hugh); library.addMember(ben);

    ConsoleUI console = new ConsoleUI(library);

    console.run();

}