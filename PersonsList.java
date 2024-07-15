import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonsList {
    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) {
        if (!Pattern.matches("^[A-Za-z]+ [A-Za-z]+$", name)) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person clone(Person person, int newId) {
        return new Person(newId, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writePersonToFile(Person person, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}


