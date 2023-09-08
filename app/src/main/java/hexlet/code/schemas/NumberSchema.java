package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    private boolean required = false;
    private boolean positive = false;
    private int minOfRange = Integer.MIN_VALUE;
    private int maxOfRange = Integer.MAX_VALUE;

    public NumberSchema() {
    }

    public NumberSchema required() {
        this.required = true;
        return this;
    }
    public NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public NumberSchema range(int min, int max) {
        this.minOfRange = min;
        this.maxOfRange = max;
        return this;
    }

    @Override
    public boolean isValid(Object obj) {
        if (!isInstance(obj, "Number")) {
            return false;
        }
        if (required && obj == null) {
            return false;
        }
        if (positive && obj != null && (Integer) obj <= 0) {
            return false;
        }
        if (obj != null && !(minOfRange <= (Integer) obj && (Integer) obj <= maxOfRange)) {
            return false;
        }
        return true;
    }
}
