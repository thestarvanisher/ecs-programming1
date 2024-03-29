import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FlashCardReaderTest {

    @Test
    void readTest() {
        FlashCardReader fcr = new FlashCardReader("Questions.txt");
        assertTrue(fcr.fileIsReady(), "valid file ready to read");
        String line;

        line = fcr.getLine();
        assertEquals("By what initials was Franklin Roosevelt better known?:FDR", line, "first line successfully read");
        for(int i=0; i<9; i++) {
            line = fcr.getLine();
        }
        assertFalse(fcr.fileIsReady(), "end of file should be reached");

    }

    @Test
    void missingFileTest() {
        FlashCardReader fcr = new FlashCardReader("doenotexist.txt");
        assertFalse(fcr.fileIsReady(), "missing file should not be ready");

    }
}