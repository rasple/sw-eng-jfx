package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

public class Konfiguration implements Konfiguration_I, Serializable {

	private int[][] kompILF;
	private int[][] kompEIF;
	private int[][] kompEI;
	private int[][] kompEO;
	private int[][] kompEQ;
	private HashMap<String, int[][]> HashMapFunktion;
	private HashMap<String, int[][]> HashMapDaten;
	/**
	 * Initialisierung der Komplexitätsmatrizen. Es werden an den entsprechenden Stellen gleich die Werte
	 * der FunctionPoints gespeichert;
	 */
	public Konfiguration(){
		int[] pos={0,0,1,2,2}, wertILF={7,10,15}, wertEIF={5,7,10}, wertEI={3,4,6}, wertEO ={4,5,7}, wertEQ={3,4,6,};
		this.kompILF= new int[3][3];
		this.kompEIF= new int[3][3];
		this.kompEI= new int[3][3];
		this.kompEO= new int[3][3];
		this.kompEQ= new int[3][3];
		for(int i=0; i<3; i++){
			for(int j=0; j<3;j++){
				this.kompILF[i][j]=wertILF[pos[j+i]];
				this.kompEIF[i][j]=wertEIF[pos[j+i]];
				this.kompEI[i][j]=wertEI[pos[j+i]];
				this.kompEO[i][j]=wertEO[pos[j+i]];
				this.kompEQ[i][j]=wertEQ[pos[j+i]];

			}
		}
		this.HashMapFunktion= new HashMap<>();
		this.HashMapFunktion.put("EO", this.kompEO);
		this.HashMapFunktion.put("EI", this.kompEI);
		this.HashMapFunktion.put("EQ", this.kompEQ);
		this.HashMapDaten= new HashMap<>();
		this.HashMapDaten.put("ILF", this.kompILF);
		this.HashMapDaten.put("EIF", this.kompEIF);
	}
	public HashMap<String, int[][]> getHashMapFunktion(){
		return this.HashMapFunktion;
	}
	public HashMap<String, int[][]> getHashMapDaten(){
		return this.HashMapDaten;
	}
/**
 * Rechnet die Functionpoints nach der IBM-MM Tabelle in Mannmonate um
 * Zwischen den Stützstellen wird linear interpoliert
 * @param fp, bewertete Function Points
 * @return Mannmonate passend zu den Functionpoints
 */
	public double calcmannmonate(double fp) {
		double mannmonate=-1;
		if(fp<0){
			mannmonate=0;
		}else if(fp<50){
			mannmonate=  fp/10;
		} else if (fp >= 50 && fp <= 300) {
			mannmonate = 2 + (3 * fp / 50);
		} else if (fp > 300 && fp <= 1000) {
			mannmonate = -4 + (fp * 2 / 25);
		} else if (fp > 1000 && fp <= 1400) {
			mannmonate = -14 + (9 * fp / 100);
		} else if (fp > 1400 && fp <= 1700) {
			mannmonate = -28 + (fp / 10);
		} else if (fp > 1700 && fp <= 2000) {
			mannmonate = -45 + (11 * fp / 100);
		} else if (fp > 2000 && fp <= 2200) {
			mannmonate = -85 + (fp * 13 / 100);
		} else if (fp > 2200 && fp <= 2500) {
			mannmonate = -130 + (3 * fp / 20);
		} else if (fp > 2500 && fp <= 2600) {
			mannmonate = -205 + (9 * fp / 50);
		} else if (fp > 2600 && fp <= 2700) {
			mannmonate = -283 + (fp * 21 / 100);
		} else if (fp > 2700 && fp <= 2800) {
			mannmonate = -357 + (23 * fp / 100);
		} else if (fp > 2800 && fp <= 2900) {
			mannmonate = -645 + (17 * fp / 50);
		} else if (fp >= 2900) {
			mannmonate = 341;
		}
		return mannmonate;
	}
/**
 * Rechnet die Mannmonate nach der IBM-MM Tabelle in Functionpoints um
 * Zwischen den Stützstellen wird linear interpoliert
 * @param mannmonate
 * @return Funtionspoints
 */
	public double calcfp(double mannmonate) {
		double fp = 0;
		if(mannmonate<0){
			fp=0;
		}else if(mannmonate<5){
			fp=mannmonate*10;
		} else if ( mannmonate <= 20) {
			fp = (mannmonate - 2)/3 * (50 );
		} else if (mannmonate <= 76) {
			fp = (mannmonate + 4)/2 * (25);
		} else if ( mannmonate <= 112) {
			fp = (mannmonate + 14)/9 * (100);
		} else if (mannmonate <= 142) {
			fp = (mannmonate + 28) * (10);
		} else if ( mannmonate <= 175) {
			fp = (mannmonate + 45)/11 * (100);
		} else if (mannmonate <= 201) {
			fp = (mannmonate + 85)/13 * (100);
		} else if ( mannmonate <= 245) {
			fp = (mannmonate + 130)/3 * (20);
		} else if (mannmonate <= 263) {
			fp = (mannmonate + 205)/9 * (50);
		} else if (mannmonate <= 284) {
			fp = (mannmonate + 283)/21 * (100);
		} else if (mannmonate <= 307) {
			fp = (mannmonate + 357)/23 * (100);
		} else if (mannmonate <= 341) {
			fp = (mannmonate + 645)/17 * (50);
		} else if (mannmonate > 341) {
			fp = 2900;
		}
		return fp;
	}

	@Override
	public String toString() {
		return "Konfiguration{" +
				"kompILF=" + Arrays.toString(kompILF) +
				", kompEIF=" + Arrays.toString(kompEIF) +
				", kompEI=" + Arrays.toString(kompEI) +
				", kompEO=" + Arrays.toString(kompEO) +
				", kompEQ=" + Arrays.toString(kompEQ) +
				", HashMapFunktion=" + HashMapFunktion +
				", HashMapDaten=" + HashMapDaten +
				'}';
	}

}
