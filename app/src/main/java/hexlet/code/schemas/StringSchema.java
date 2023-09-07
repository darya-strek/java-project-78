package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private boolean required = false;
    private int length;
    private String substring = "";

    public StringSchema() {
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

    public boolean isValid(Object obj) {
        if (obj != null && !(obj instanceof String)) {
            return false;
        }
        if (required && (obj == null || obj.toString().equals(""))) {
            return false;
        }
        if (obj != null && obj.toString().length() < length) {
            return false;
        }
        if (obj != null && !(obj.toString().contains(substring))) {
            return false;
        }
        return true;
    }
}
