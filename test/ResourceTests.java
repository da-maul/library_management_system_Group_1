import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class ResourceTests {
    Movie testMovie = new Movie("TestStudio", "TestTitle", 9999999999999L, "Test Director", 100, 3);
    VideoGame testGame = new VideoGame("TestStudio","TestTitle",9999999999999L,"TestConsole",4);
    Book testBook = new Book("TestStudio", "TestTitle", "999-9-9999-9999-9", 100, 1);
    AudioBook audiotestBook = new AudioBook("TestStudio", "TestTitle", 100000, "999-9-9999-9999-9", 1);

    //reminder to add a .equals() method override in Book & Movie, Mads
    //you can find a good example in Movie & VideoGame =w=

    // book og audiobook har brug for en assertequals

    @Test
    void movieTest(){
        Movie newTestMovie = new Movie("TestStudio", "TestTitle", 9999999999999L, "Test Director", 100, 3);
        assertEquals(testMovie,newTestMovie);
    }

    @Test
    void gameTest(){
        VideoGame newTestGame = new VideoGame("TestStudio","TestTitle",9999999999999L,"TestConsole",4);
        assertEquals(testGame,newTestGame);
    }

    @Test
    void bookTest(){
        Book newTestBook = new Book("TestStudio", "TestTitle", "999-9-9999-9999-9", 100, 1);
        assertEquals(testBook,newTestBook);
    }

    @Test
    void audiobookTest(){
        AudioBook newTestAudioBook = new AudioBook("TestStudio", "TestTitle", 100000, "999-9-9999-9999-9", 1);
        assertEquals(newTestAudioBook,newTestAudioBook);
    }

    @Test
    void CreatorComparatorTest(){
        ArrayList<Resource> creators = new ArrayList<>();
        creators.add(new Book("J.K. Rowling", "Harry Potter", "999-9-9999-9999-9", 100, 1));
        creators.add(new Book("William Shakespeare", "Hamlet", "999-9-9999-9999-9", 200, 2));
        creators.add(new Book("Stephen King", "IT", "999-9-9999-9999-9", 300, 3));
        creators.add(new Book("Agatha Christie", "Queen of crime", "999-9-9999-9999-9", 400, 4));

        IO.print("Før: " + creators.toString());

        Collections.sort(creators, new CreatorNameComparator());
        creators.sort(new CreatorNameComparator());

        IO.print("\nEfter: " + creators.toString());
    }

    @Test
    void TitleComparatorTest(){
        ArrayList<Resource> titles = new ArrayList<>();
        titles.add(new Book("J.K. Rowling", "Harry Potter", "999-9-9999-9999-9", 100, 1));
        titles.add(new Book("William Shakespeare", "Hamlet", "999-9-9999-9999-9", 200, 2));
        titles.add(new Book("Stephen King", "IT", "999-9-9999-9999-9", 300, 3));
        titles.add(new Book("Agatha Christie", "Queen of crime", "999-9-9999-9999-9", 400, 4));

        IO.print("Før: " + titles.toString());

        Collections.sort(titles, new TitleNameComparator());
        titles.sort(new TitleNameComparator());

        IO.print("\nEfter: " + titles.toString());
    }
}