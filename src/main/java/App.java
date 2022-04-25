import java.io.*;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.Month.of;

public class App {

    private List<Person> persons = new ArrayList<>();

    /**
     * reads from an input file and creates Person entities with every line read &
     * writes the first and last name of the Persons born on the specified month, ordered ascending by FirstName
     * line output in the input file must be: Firstname, LastName, DateOfBirth
     * DateOfBirth format must be YYYY-M-D
     * @param input the file from where the app reads the information
     * @param month the month used to filter the Persons
     * @param output the file in which the app writes the results.
     *
     */
    public void run(File input, int month, File output) {
        readPersons(input);
        writePersons(of(month), output);
    }

    /**
     * reads lines from an input file and creates Person entities with the information found in every line
     * FirstName, LastName and DateOfBirth must be separated by ","
     * DateOfBirth format must be "YYYY-M-D"
     */
    private void readPersons(File input) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
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
     * writes in out.txt file the FirstName and LastName of the Persons born in the specified month.
     * the information written is Ascending ordered by the FirstName
     * @param month the month the ordered Persons are born in
     */
    private void writePersons(Month month, File output) {

        PrintWriter out = null;

        try {

            List<Person> sorted;

            out = new PrintWriter(new FileWriter(output));
            PrintWriter finalOut = out;

            sorted = persons.stream()
                    .filter(p -> p.getDateOfBirth().getMonth().equals(month))
                    .sorted((p1, p2) -> {
                       return p1.getFirstName().compareTo(p2.getFirstName());
                    })
                    .collect(Collectors.toList());

            sorted.stream()
                    .forEach(p -> finalOut.write(p.getFirstName() + ", " + p.getLastName() + System.getProperty( "line.separator" )));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}

