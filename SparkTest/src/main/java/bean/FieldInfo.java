package bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class FieldInfo {
    private String name;
    private String type;
    private Boolean nullable;
    private Map<String, Object> metadata;
}
