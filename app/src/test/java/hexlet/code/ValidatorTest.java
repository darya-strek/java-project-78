package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
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

    @Test
    void numberSchemaTest() {
        NumberSchema schema = validator.number();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(77));
        assertTrue(schema.isValid(-77));
        assertTrue(schema.isValid(0));
        assertFalse(schema.isValid("Hexlet"));

        schema.positive();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(77));
        assertFalse(schema.isValid(-77));
        assertFalse(schema.isValid(0));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(77));
        assertFalse(schema.isValid(-77));
        assertFalse(schema.isValid(0));

        schema.range(50, 100);

        assertTrue(schema.isValid(77));
        assertTrue(schema.isValid(50));
        assertTrue(schema.isValid(100));
        assertFalse(schema.isValid(25));
        assertFalse(schema.isValid(125));
    }
}
