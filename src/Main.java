
void main() {

    Library library = new Library();

    Book book1 = new Book("Allan B. Downey",
            "Think Java",
            9781492072508L, 324,1);
    Book book2 = new Book("Rachel Cusk",
            "Omrids",
            9788763851664L, 240,2);
    Book book3 = new Book("Yuval Noah Harari",
            "Sapiens",
            9780062316097L, 464,3);


    AudioBook audioBook = new AudioBook("Stephen King", "The Shining", 360, 9780307743657L, 4);
    library.addResource(audioBook);

    library.addResource(book1); library.addResource(book2); library.addResource(book3);

    Member joe = new Member("Joe Mama", 1337);
    Member hugh = new Member("Hugh Janus", 6969);
    Member ben = new Member("Ben Dover", 8008);

    library.addMember(joe); library.addMember(hugh); library.addMember(ben);

    ConsoleUI console = new ConsoleUI(library);

    console.run();

}