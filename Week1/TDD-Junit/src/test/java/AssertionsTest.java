import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Exercise 3: Assertions in JUnit
public class AssertionsTest {

    @Test
    public void testAssertions() {

        // Assert equals - checks two values are equal
        assertEquals(5, 2 + 3);
        System.out.println("assertEquals passed: 2 + 3 = 5");

        // Assert true - checks condition is true
        assertTrue(5 > 3);
        System.out.println("assertTrue passed: 5 > 3");

        // Assert false - checks condition is false
        assertFalse(5 < 3);
        System.out.println("assertFalse passed: 5 is not less than 3");

        // Assert null - checks value is null
        assertNull(null);
        System.out.println("assertNull passed: value is null");

        // Assert not null - checks value is not null
        assertNotNull(new Object());
        System.out.println("assertNotNull passed: object is not null");
    }
}