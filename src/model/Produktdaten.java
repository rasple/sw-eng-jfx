package model;

public class Produktdaten {

    private String id;
    private String desc;
    private int ert;
    private int det;

    public Produktdaten() {
        this.setId("");
        this.setDesc("");
        this.setErt(0);
        this.setDet(0);
    }

    public Produktdaten(String id, String desc, int ert, int det) {
        this.setId(id);
        this.setDesc(desc);
        this.setErt(ert);
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

    public int getErt() {
        return ert;
    }

    public void setErt(int ert) {
        this.ert = ert;
    }

    public int getDet() {
        return det;
    }

    public void setDet(int det) {
        this.det = det;
    }
}
