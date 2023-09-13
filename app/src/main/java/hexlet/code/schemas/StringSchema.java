package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private boolean required = false;
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

    public boolean isRequired(Object obj) {
        return required && (obj == null || obj.toString().equals(""));
    }

    public boolean isMinLength(Object obj) {
        return obj != null && obj.toString().length() < length;
    }

    public boolean isContains(Object obj) {
        return obj != null && !(obj.toString().contains(substring));
    }

    @Override
    public boolean isValid(Object obj) {
        return isInstance(obj, "String") && !isRequired(obj) && !isMinLength(obj) && !isContains(obj);
    }
}
