package model;

public interface Optimieren_I {
	Faktoren optimieren(double istfp, double sollfp, double[] factors);
	String getBeschreibung();

    String getName();

    //String toString(); <- unnötig, wird von Klasse Object geerbt
}
