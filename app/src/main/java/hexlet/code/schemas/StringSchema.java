package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
        addCheck(
                "instanceof",
                value -> {
                    if (value != null) {
                        return value instanceof String;
                    }
                    return true;
                }
        );
    }

    public StringSchema required() {
        addCheck(
                "required",
                value -> value != null && !value.equals("")
        );

        return this;
    }

    public StringSchema minLength(int minLength) {
        addCheck(
                "minLength",
                value -> value != null && ((String) value).length() >= minLength
        );

        return this;
    }

    public StringSchema contains(String substring) {
        addCheck(
                "contains",
                value -> value != null && ((String) value).contains(substring)
        );
        return this;
    }
}
