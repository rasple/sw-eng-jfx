package model;

public interface FunctionPoints_I {

    Faktoren selbstoptimierung(double mannmonate, double[] userfaktoren);
    void setIstfp(double istFp);
    double getCalcMannmonate();
    void setOpti(Optimieren_I opti);
}
