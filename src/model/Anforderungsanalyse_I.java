package model;

public interface Anforderungsanalyse_I {
    public double aufwandsabschaetzung();
    public Faktoren selbstoptimierung(double mannmonate)throws SelbstoptiException;

}
