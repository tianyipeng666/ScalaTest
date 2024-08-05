package bean;

public enum EnumJava {
    INSERT("insert"),
    UPDATE("update"),
    DELETE("delete");

    private String name;

    EnumJava(String name) {
        this.name = name;
    }
}
