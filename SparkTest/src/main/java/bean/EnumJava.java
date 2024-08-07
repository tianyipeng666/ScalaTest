package bean;

public enum EnumJava {
    INSERT("insert"),
    UPDATE("update"),
    EMPTY("empty"),
    DELETE("delete");

    private String name;

    EnumJava(String name) {
        this.name = name;
    }
}
