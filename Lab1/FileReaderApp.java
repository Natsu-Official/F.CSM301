import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class FileReaderApp {

    public static String readFile(String path) {
        return readFile(path, null, true);
    }

    public static String readFile(String path, String expectedText, boolean interactive) {
        try {
            String content = Files.readString(Paths.get(path));

            if (expectedText != null && !content.equals(expectedText)) {
                if (interactive) {
                    System.out.print("Текст таарахгүй байна. Текстийг replace хийж бичих үү? (y/n): ");
                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine().trim().toLowerCase();
                    if (choice.equals("y")) {
                        Files.writeString(Paths.get(path), expectedText);
                        return expectedText;
                    }
                }
            }

            return content;

        } catch (NoSuchFileException e) {
            return "Алдаа: Файл олдсонгүй!";
        } catch (IOException e) {
            return "Алдаа: " + e.getMessage();
        }
    }
}
