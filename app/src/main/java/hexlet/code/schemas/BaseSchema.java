package hexlet.code.schemas;

import java.util.Map;

public abstract class BaseSchema {
    public abstract boolean isValid(Object obj);

    public boolean isInstance(Object obj, String instance) {
        if (obj != null) {
            if (instance.equals("String")) {
                return obj instanceof String;
            }
            if (instance.equals("Number")) {
                return obj instanceof Number;
            }
            if (instance.equals("Map")) {
                return obj instanceof Map;
            }
            return false;
        }
        return true;
    }
}
