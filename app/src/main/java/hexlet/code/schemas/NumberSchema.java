package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public boolean required = false;
    private boolean positive = false;
    private boolean range = false;
    private int minOfRange;
    private int maxOfRange;

    public NumberSchema() {
        super();
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
        this.range = true;
        this.minOfRange = min;
        this.maxOfRange = max;
        return this;
    }

    private boolean isRequired(Object obj) {
        return required && obj == null;
    }

    private boolean isPositive(Object obj) {
        return positive && obj != null && (Integer) obj <= 0;
    }

    private boolean isRange(Object obj) {
        return range && obj != null && !(minOfRange <= (Integer) obj && (Integer) obj <= maxOfRange);
    }

    @Override
    public boolean isValid(Object obj) {
        if (!isInstance(obj, "Number") || isRequired(obj) || isPositive(obj) || isRange(obj)) {
            return false;
        }
        return true;
    }
}
