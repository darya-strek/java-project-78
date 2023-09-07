package hexlet.code;

import schemas.NumberSchema;
import schemas.StringSchema;

public class Validator {
    public Validator() {
    }
    public static StringSchema string() {
        return new StringSchema();
    }
    public static NumberSchema number() {
        return new NumberSchema();
    }
}
