package model;

public class Produktdaten {

    private String id;
    private String desc;
    private int ret;
    private int det;

    public Produktdaten() {
        this.setId("");
        this.setDesc("");
        this.setRet(0);
        this.setDet(0);
    }

    public Produktdaten(String id, String desc, int ret, int det) {
        this.setId(id);
        this.setDesc(desc);
        this.setRet(ret);
        this.setDet(det);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
}
