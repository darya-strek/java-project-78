package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public boolean required = false;
    private boolean size = false;
    private int checkedSize;
    private boolean shape = false;
    public Map<String, BaseSchema> schemas;

    public MapSchema() {
        super();
    }

    public MapSchema required() {
        this.required = true;
        return this;
    }

    public MapSchema sizeof(int number) {
        this.size = true;
        this.checkedSize = number;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> checkedSchemas) {
        this.shape = true;
        this.schemas = checkedSchemas;
        return this;
    }

    private boolean isRequired(Object obj) {
        return required && obj == null;
    }

    private boolean isSizeof(Object obj) {
        return size && obj != null && ((Map<?, ?>) obj).size() != checkedSize;
    }

    private boolean isValidation(Object obj) {
        Map<?, ?> checkedMap = (Map<?, ?>) obj;
        for (Map.Entry<String, BaseSchema> entry : this.schemas.entrySet()) {
            String key = entry.getKey();
            if (!checkedMap.containsKey(key) || !entry.getValue().isValid(checkedMap.get(key))) {
                return false;
            }
        }
        return true;
    }

    private boolean isShape(Object obj) {
        return shape && obj != null && !isValidation(obj);
    }

    @Override
    public boolean isValid(Object obj) {
        return isInstance(obj, "Map") && !isRequired(obj) && !isSizeof(obj) && !isShape(obj);
    }
}
