package model;

public class Produktfunktion {
    private String id;
    private String desc;
    private int ftr;
    private int det;
    private String type;


    public Produktfunktion() {
        this.setId("");
        this.setDesc("");
        this.setFtr(0);
        this.setDet(0);
        this.setType("");
    }

    public Produktfunktion(String desc, String id, int ftr, int det, String type) {
        this.setId(id);
        this.setDesc(desc);
        this.setFtr(ftr);
        this.setDet(det);
        this.setType(type);
    }

    public int getFtr() {
        return ftr;
    }

    public void setFtr(int ftr) {
        this.ftr = ftr;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
