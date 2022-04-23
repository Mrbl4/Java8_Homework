import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth);
    }
}
