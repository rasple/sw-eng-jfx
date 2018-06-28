package model;
import java.util.HashMap;
public interface Konfiguration_I {
	public double calcmannmonate(double fp);
	public double calcfp(double mannmonate);
	public HashMap<String, int[][]> getHashMapFunktion();
	public HashMap<String, int[][]> getHashMapDaten();
}
