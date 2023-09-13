package hexlet.code.schemas;

import java.util.Map;

public abstract class BaseSchema {

    public BaseSchema() {
    }

    public abstract boolean isValid(Object obj);

    public boolean isInstance(Object obj, String instance) {
        if (obj != null) {
            switch (instance) {
                case "String": return obj instanceof String;
                case "Number": return obj instanceof Number;
                case "Map": return obj instanceof Map;
                default: return false;
            }
        }
        return true;
    }
}
