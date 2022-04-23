import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {

        App app = new App();
        app.readPersons();
        app.listPersons(Month.MAY);
    }
}
