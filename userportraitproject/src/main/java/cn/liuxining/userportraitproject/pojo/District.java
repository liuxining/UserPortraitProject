package cn.liuxining.userportraitproject.pojo;

public class District {
    private Short id;

    private String name;

    private Short pid;

    private Byte ord;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getPid() {
        return pid;
    }

    public void setPid(Short pid) {
        this.pid = pid;
    }

    public Byte getOrd() {
        return ord;
    }

    public void setOrd(Byte ord) {
        this.ord = ord;
    }
}