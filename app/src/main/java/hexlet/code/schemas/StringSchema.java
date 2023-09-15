package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private boolean required = false;
    private int length;
    private String substring = "";

    public StringSchema() {
        super();
    }

    public final StringSchema required() {
        this.required = true;
        return this;
    }

    public final StringSchema minLength(int checkedMinLength) {
        this.length = checkedMinLength;
        return this;
    }

    public final StringSchema contains(String checkedSubstring) {
        this.substring = checkedSubstring;
        return this;
    }

    public final boolean isRequired(Object obj) {
        return required && (obj == null || obj.toString().equals(""));
    }

    public final boolean isMinLength(Object obj) {
        return obj != null && obj.toString().length() < length;
    }

    public final boolean isContains(Object obj) {
        return obj != null && !(obj.toString().contains(substring));
    }

    @Override
    public final boolean isValid(Object obj) {
        return isInstance(obj, "String") && !isRequired(obj) && !isMinLength(obj) && !isContains(obj);
    }
}
