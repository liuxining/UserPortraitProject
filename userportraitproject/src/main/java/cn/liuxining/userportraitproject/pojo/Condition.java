package cn.liuxining.userportraitproject.pojo;

public class Condition {
    private String key;
    private String value;
    private String logical;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLogical() {
        return logical;
    }

    public void setLogical(String logical) {
        this.logical = logical;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", logical='" + logical + '\'' +
                '}';
    }
}
