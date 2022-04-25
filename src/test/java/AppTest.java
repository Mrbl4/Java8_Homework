import org.junit.jupiter.api.Test;

import java.io.File;

import static java.time.Month.of;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    void retrieve() {

        App app = new App();
        File input = new File("src/main/resources/in.txt");
        File output = new File("src/main/resources/out.txt");
        int month = 5;

        app.run(input, month, output);

    }
}