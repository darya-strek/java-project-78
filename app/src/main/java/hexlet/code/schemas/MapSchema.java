package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    private boolean size = false;
    private int checkedSize;

    public MapSchema() {
        super();
    }

    public MapSchema sizeof(int number) {
        this.size = true;
        this.checkedSize = number;
        return this;
    }

    @Override
    public boolean isValid(Object obj) {
        if (!isInstance(obj, "Map")) {
            return false;
        }
        if (super.required && obj == null) {
            return false;
        }
        if (obj != null && size && ((Map<?, ?>) obj).size() != checkedSize) {
            return false;
        }
        return true;
    }
}
