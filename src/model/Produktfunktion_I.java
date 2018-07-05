package model;
import java.util.HashMap;

public interface Produktfunktion_I {
    public int calcFp(HashMap<String, int[][]> fpmatrix);
    public boolean isValid();
    String getId();
    void setId(String id);
    void setType(String type);
    String getType();
    void setDesc(String desc);
    void setDet(int det);
    void setFtr(int ftr);
}
