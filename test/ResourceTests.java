import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceTests {
    Movie testMovie = new Movie("TestStudio", "TestTitle", 9999999999999L, "Test Director", 100, 3);
    VideoGame testGame = new VideoGame("TestStudio","TestTitle",9999999999999L,"TestConsole",4);

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

}