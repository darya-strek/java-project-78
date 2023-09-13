package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private int length;
    private String substring = "";

    public StringSchema() {
        super();
    }

    public StringSchema minLength(int checkedMinLength) {
        this.length = checkedMinLength;
        return this;
    }

    public StringSchema contains(String checkedSubstring) {
        this.substring = checkedSubstring;
        return this;
    }

    @Override
    public boolean isValid(Object obj) {
        if (!isInstance(obj, "String")) {
            return false;
        }
        if (super.required && (obj == null || obj.toString().equals(""))) {
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
