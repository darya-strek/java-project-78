package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    public boolean required = false;
    private int length;
    private String substring = "";

    public StringSchema() {
        super();
    }

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int checkedMinLength) {
        this.length = checkedMinLength;
        return this;
    }

    public StringSchema contains(String checkedSubstring) {
        this.substring = checkedSubstring;
        return this;
    }

    private boolean isRequired(Object obj) {
        return required && (obj == null || obj.toString().equals(""));
    }

    private boolean isMinLength(Object obj) {
        return obj != null && obj.toString().length() < length;
    }

    private boolean isContains(Object obj) {
        return obj != null && !(obj.toString().contains(substring));
    }

    @Override
    public boolean isValid(Object obj) {
        if (!isInstance(obj, "String") || isRequired(obj) || isMinLength(obj) || isContains(obj)) {
            return false;
        }
        return true;
    }
}
