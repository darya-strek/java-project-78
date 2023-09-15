package hexlet.code.schemas;

import java.util.Map;

public abstract class BaseSchema {
    public BaseSchema() {
    }

    public abstract boolean isValid(Object obj);

    public final boolean isInstance(Object obj, String instance) {
        if (obj != null) {
            return switch (instance) {
                case "String" -> obj instanceof String;
                case "Number" -> obj instanceof Number;
                case "Map" -> obj instanceof Map;
                default -> false;
            };
        }
        return true;
    }
}
