import java.io.*;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class App {

    List<Person> persons = new ArrayList<>();

    /**
     * reads lines from an input file, in.txt and creates Person entities with the information found in every line
     * FirstName, LastName and DateOfBirth must be separated by ","
     * DateOfBirth format "YYYY-M-D"
     */
    public void readPersons() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/in.txt"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(", ");
                persons.add(new Person(info));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * writes in out.txt file the FirstName and LastName of the Persons born in the specified month
     * @param month
     */
    public void listPersons(Month month) {

        PrintWriter out = null;

        try {

            out = new PrintWriter(new FileWriter("src/main/resources/out.txt"));
            PrintWriter finalOut = out;

            persons.stream()
                    .filter(p -> p.getDateOfBirth().getMonth().equals(month))
                    .sorted((p1, p2) -> {
                       return p1.getFirstName().compareTo(p2.getFirstName());
                    })
                    .forEach(p -> finalOut.write(p.getFirstName() + ", " + p.getLastName() + System.getProperty( "line.separator" )));

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}

