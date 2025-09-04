import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderAppTest {

    @Test
    public void testReadNonExistingFile() {
        String content = FileReaderApp.readFile("not_exist.txt");
        assertTrue(content.contains("Файл олдсонгүй"));
    }

    @Test
    public void testReadExistingFileCorrect() throws IOException {
        Path path = Paths.get("text.txt");
        Files.writeString(path, "Сайн байна уу?");

        String content = FileReaderApp.readFile("text.txt", "Сайн байна уу?", false);
        assertEquals("Сайн байна уу?", content);

        Files.deleteIfExists(path);
    }

    @Test
    public void testReadExistingFileMismatchNoReplace() throws IOException {
        Path path = Paths.get("text.txt");
        Files.writeString(path, "Өөр текст");

        String content = FileReaderApp.readFile("text.txt", "Сайн байна уу?", false);
        assertEquals("Өөр текст", content);

        Files.deleteIfExists(path);
    }
}
