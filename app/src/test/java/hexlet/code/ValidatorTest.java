package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    final void setUp() {
        validator = new Validator();
    }

    @Test
    void testStringSchema() {
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
    void testNumberSchema() {
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

    @Test
    void testMapSchema() {
        MapSchema schema = validator.map();
        Map<String, String> testMap = new HashMap<>();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(testMap));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(testMap));

        testMap.put("key1", "value1");
        assertTrue(schema.isValid(testMap));

        schema.sizeof(2);

        assertFalse(schema.isValid(testMap));

        testMap.put("key2", "value2");
        assertTrue(schema.isValid(testMap));
    }

    @Test
    void testMapSchemaWithInsertedMap() {
        MapSchema schema = validator.map();

        Map<String, BaseSchema> schemas = new HashMap<>();

        schemas.put("name", validator.string().required().minLength(2));
        schemas.put("age", validator.number().positive());

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Alice");
        human1.put("age", 21);
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Alex");
        human2.put("age", null);
        assertTrue(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", null);
        human3.put("age", null);
        assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "");
        human4.put("age", null);
        assertFalse(schema.isValid(human4));

        Map<String, Object> human5 = new HashMap<>();
        human5.put("name", "A");
        human5.put("age", null);
        assertFalse(schema.isValid(human5));

        Map<String, Object> human6 = new HashMap<>();
        human6.put("name", "Marina");
        human6.put("age", -8);
        assertFalse(schema.isValid(human6));

        schemas.put("age", validator.number().positive().range(18, 35));
        schemas.put("hobbies", validator.map().required());

        schema.shape(schemas);

        Map<String, Object> human7 = new HashMap<>();
        human7.put("name", "Lora");
        human7.put("age", 25);
        human7.put("hobbies", Map.of("one", "ride a bike"));
        assertTrue(schema.isValid(human7));

        Map<String, Object> human8 = new HashMap<>();
        human8.put("name", "Helena");
        human8.put("age", 30);
        human8.put("hobbies", null);
        assertFalse(schema.isValid(human8));

        Map<String, Object> human9 = new HashMap<>();
        human9.put("name", "Fred");
        human9.put("age", 10);
        human9.put("hobbies", Map.of("one", "read books"));
        assertFalse(schema.isValid(human9));
    }

    @Test
    void testIsInstanceDefault() {
        BaseSchema schema = new BaseSchema() {
            @Override
            public boolean isValid(Object obj) {
                return false;
            }
        };
        assertFalse(schema.isInstance(new Object(), "List"));
    }

}
