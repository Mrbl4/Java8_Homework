import org.junit.jupiter.api.Test;
import java.io.File;

class AppTest {

    @Test
    void testRunApp() {

        App app = new App();
        File input = new File("src/main/resources/in.txt");
        File output = new File("src/main/resources/out.txt");
        int month = 5;

        app.run(input, month, output);

    }
}