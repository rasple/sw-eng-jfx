package model;

import jdk.nashorn.internal.runtime.OptimisticReturnFilters;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.HashMap;

public interface Produktdaten_I {

    public int calcFp(HashMap<String, int[][]> fpmatrix);
    public boolean isValid();
    String getId();
    void setId(String id);
    void setType(String type);
    String getType();
    void setDesc(String desc);
    void setDet(int det);
    void setRet(int ret);
}

