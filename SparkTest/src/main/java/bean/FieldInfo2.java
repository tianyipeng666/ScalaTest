package bean;

import lombok.Data;

import java.util.Map;

@Data
public class FieldInfo2 {
    private String name;
    private Object type;
    private Boolean nullable;
    private Map<String, Object> metadata;
}
