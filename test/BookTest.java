import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBookConstructorAndGetters() {
        // Arange
        Book book = new Book("Allan B. Downey", "Think Java", "999-9-9999-9999-9", 324,1);

        // Assert
        assertEquals("Allan B. Downey", book.getCreator());
        assertEquals("Think Java", book.getTitle());
        assertEquals(324, book.getPages());
        assertEquals(1, book.getIdentifier());
    }

    @Test
    void testBookToString() {
        // Arange
        Book book = new Book("Rachel Cusk", "Omrids", "999-9-9999-9999-9", 240,2);

        // Assert
        String expected = "Omrids by Rachel Cusk, ISBN: 9788763851664. id: 2";
        assertEquals(expected, book.toString());

    }

}