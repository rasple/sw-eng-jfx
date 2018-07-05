package model;

import java.util.HashMap;

public interface Konfiguration_I {
	double calcmannmonate(double fp);
	double calcfp(double mannmonate);
	HashMap<String, int[][]> getHashMapFunktion();
	HashMap<String, int[][]> getHashMapDaten();
}
