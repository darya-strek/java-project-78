package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {

    Validator validator = new Validator();

    @Test
    void stringSchemaTest() {
        StringSchema schema = validator.string();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid("Hexlet"));
        assertFalse(schema.isValid(5));

        schema.required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("Hexlet"));

        schema.minLength(5);

        assertTrue(schema.isValid("Hexlet"));
        assertFalse(schema.isValid("Hex"));

        schema.contains("Hex");
        assertTrue(schema.isValid("Hexlet"));

        schema.contains("xle");
        assertTrue(schema.isValid("Hexlet"));

        schema.contains("hello");
        assertFalse(schema.isValid("Hexlet"));
    }
}
