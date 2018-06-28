package model;
import java.util.HashMap;
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
    public int calcFp(HashMap<String, int[][]> fpmatrix){
        return fpmatrix.get(this.type)[this.calcPos()[0]][this.calcPos()[1]];
    }
    /**
     * Prüft ob alle relevanten Informaionen gesetzt sind
     * @return true wenn ein Typ ausgewählt ist und DET größer null ist
     */
    public boolean isvalid(){
        return !(this.type.isEmpty()) && (this.det>0) && (this.ftr>-1);
    }

    /**
     * Wird nur dann ausgeführt wenn isvalid true liefert
     * @return Array an Stelle 0 die FTR Position an Stelle 1 die DET Position der Functionspointsmatrix
     */
    public int[] calcPos(){
        int[] pos = new int[2];
        if(this.type.equals("EI")){
            pos[0]=this.calcFTRposEI();
            pos[1]=this.calcDETposEI();
            return pos;
        }
        else{
            pos[0]=this.calcFTRpos();
            pos[1]=this.calcDETpos();
            return pos;
        }
    }
    private int calcFTRposEI(){
        if(this.ftr<2){
            return 0;
        }
        else if (this.ftr==2){
            return 1;
        }
        else{
            return 2;
        }
    }
    private int calcDETposEI(){
        if(this.det<5){
            return 0;
        }
        else if(this.det <16){
            return 1;
        }
        else return 2;
    }
    private int calcFTRpos(){
        if(this.ftr<2){
            return 0;
        }
        else if(this.ftr<4){
            return 1;
        }
        else {
            return 2;
        }
    }
    private int calcDETpos(){
        if(this.det<6){
            return 0;
        }
        else if(this.det<20){
            return 1;
        }
        else return 2;
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
