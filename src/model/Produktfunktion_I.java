package model;
import java.util.HashMap;

public interface Produktfunktion_I {
    public int calcFp(HashMap<String, int[][]> fpmatrix);
    public boolean isValid();
}
