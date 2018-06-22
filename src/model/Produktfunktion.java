package model;

public class Produktfunktion {
    private int ret;
    private int det;
    private String desc;
    private String id;

    public Produktfunktion() {
        this.ret = 0;
        this.det = 0;
        this.desc = "";
        this.id = "";
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public int getDet() {
        return det;
    }

    public void setDet(int det) {
        this.det = det;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
