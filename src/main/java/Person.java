import java.io.Serializable;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Person(String[] details) {
        this.firstName = details[0];
        this.lastName = details[1];
        String[] array1 = (details[2]).split("-");
        this.dateOfBirth = LocalDate.of(parseInt(array1[0]), parseInt(array1[1]), parseInt(array1[2]));
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
