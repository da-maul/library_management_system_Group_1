import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AudioBookTest {

    @Test
    void testAudioBookConstructorAndGetters() {
        // Arrange & Act
        AudioBook audioBook = new AudioBook("Stephen King", "The Shining", 360, "999-9-9999-9999-9", 4);

        // Assert
        assertEquals("Stephen King", audioBook.getAuthor());
        assertEquals("The Shining", audioBook.getTitle());
        assertEquals(360, audioBook.getLengthInMinutes());
        assertEquals(4, audioBook.getIdentifier());

    }


}