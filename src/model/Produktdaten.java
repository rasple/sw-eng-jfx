package model;

import java.io.Serializable;
import java.util.HashMap;

public class Produktdaten implements Serializable {

    private String id;
    private String desc;
    private int ret;
    private int det;
    private String type;

    public Produktdaten() {
        this.setId("");
        this.setDesc("");
        this.setRet(0);
        this.setDet(0);
        this.setType("");
    }

    public Produktdaten(String id, String desc, int ret, int det, String type) {
        this.setId(id);
        this.setDesc(desc);
        this.setRet(ret);
        this.setDet(det);
        this.setType(type);
    }

    /**
     * Berechnet die Functionpoints gemäß der übergebenen Matrix
     * @param fpmatrix Komplexitätsmatrix
     * @return Functionpoints
     */
    public int calcFP(HashMap<String, int[][]> fpmatrix){
        return fpmatrix.get(this.type)[this.calcPosRet()][this.calcPosDet()];
    }

    /**
     *
     * @return true wenn alle Felder einen sinnvollen Wert besitzen
     */
    public boolean isValid(){
        return this.ret>0 && this.det>0 && !this.type.isEmpty();
    }

    /**
     *
     * @return Zeile in der Komplexitätsmatrix
     */
    private int calcPosRet(){
        if(this.ret<2){
            return 0;
        }
        else if(this.ret<6){
            return 1;
        }
        else{
            return 2;
        }
    }

    /**
     *
     * @return Spalte in der Komplexitätsmatrix
     */
    private int calcPosDet(){
        if(this.det<20){
            return 0;
        }
        else if(this.det<51){
            return 1;
        }
        else return 2;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Produktdaten{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", ret=" + ret +
                ", det=" + det +
                ", type='" + type + '\'' +
                '}';
    }
}
