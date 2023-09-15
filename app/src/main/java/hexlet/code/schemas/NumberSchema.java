package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    private boolean required = false;
    private boolean positive = false;
    private boolean range = false;
    private int minOfRange;
    private int maxOfRange;

    public NumberSchema() {
        super();
    }

    public final NumberSchema required() {
        this.required = true;
        return this;
    }

    public final NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public final NumberSchema range(int min, int max) {
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
    public final boolean isValid(Object obj) {
        return isInstance(obj, "Number") && !isRequired(obj) && !isPositive(obj) && !isRange(obj);
    }
}
