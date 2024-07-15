import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testSetAgeThrowsException() {
        Person person = new Person(1, "John Doe", 25, "Engineer");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-1);
        });

        String expectedMessage = "Age cannot be less than 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testFindByNameSuccess() {
        PersonsList personsList = new PersonsList();
        Person person = new Person(1, "John Doe", 25, "Engineer");
        personsList.addPerson(person);

        assertEquals(person, personsList.findByName("John Doe"));
    }

    @Test
    public void testFindByNameThrowsException() {
        PersonsList personsList = new PersonsList();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            personsList.findByName("JohnDoe");
        });

        String expectedMessage = "Name must be formatted as 'firstName lastName'";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testClonePerson() {
        Person original = new Person(1, "John Doe", 25, "Engineer");
        PersonsList personsList = new PersonsList();
        Person clone = personsList.clone(original, 2);

        assertEquals(original.getName(), clone.getName());
        assertEquals(original.getAge(), clone.getAge());
        assertEquals(original.getOccupation(), clone.getOccupation());
        assertNotEquals(original.getId(), clone.getId());
    }
}


