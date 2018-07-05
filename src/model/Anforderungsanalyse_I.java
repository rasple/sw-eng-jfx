package model;

public interface Anforderungsanalyse_I {
    double aufwandsabschaetzung();
    Faktoren selbstoptimierung(double mannmonate)throws SelbstoptiException;

}
