import org.junit.jupiter.api.Test;
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

}