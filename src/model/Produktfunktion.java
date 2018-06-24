package model;

public class Produktfunktion {
    private String id;
    private String desc;
    private int ftr;
    private int det;


    public Produktfunktion() {
        this.setId("");
        this.setDesc("");
        this.setFtr(0);
        this.setDet(0);
    }

    public Produktfunktion(String desc, String id, int ftr, int det) {
        this.setId(id);
        this.setDesc(desc);
        this.setFtr(ftr);
        this.setDet(det);
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
}
