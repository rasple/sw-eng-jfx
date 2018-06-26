package model;

public class Konfiguration implements Konfiguration_I{
/**
 * Rechnet die Functionpoints nach der IBM-MM Tabelle in Mannmonate um
 * Zwischen den Stützstellen wird linear interpoliert
 * @param fp, bewertete Function Points
 * @return Mannmonate passend zu den Functionpoints
 */
	public double calcmannmonate(double fp) {
		double mannmonate = 0;
		if (fp > 50 && fp <= 300) {
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
			mannmonate = -205 + (2 * fp / 50);
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
		if (mannmonate > 50 && mannmonate <= 300) {
			fp = (mannmonate - 2) * (50 / 3);
		} else if (mannmonate > 300 && mannmonate <= 1000) {
			fp = (mannmonate + 4) * (25 / 2);
		} else if (mannmonate > 1000 && mannmonate <= 1400) {
			fp = (mannmonate + 14) * (100 / 9);
		} else if (mannmonate > 1400 && mannmonate <= 1700) {
			fp = (mannmonate + 28) * (10);
		} else if (mannmonate > 1700 && mannmonate <= 2000) {
			fp = (mannmonate + 45) * (100 / 11);
		} else if (mannmonate > 2000 && mannmonate <= 2200) {
			fp = (mannmonate + 85) * (100 / 13);
		} else if (mannmonate > 2200 && mannmonate <= 2500) {
			fp = (mannmonate + 130) * (20 / 3);
		} else if (mannmonate > 2500 && mannmonate <= 2600) {
			fp = (mannmonate + 205) * (25);
		} else if (mannmonate > 2600 && mannmonate <= 2700) {
			fp = (mannmonate + 283) * (100 / 21);
		} else if (mannmonate > 2700 && mannmonate <= 2800) {
			fp = (mannmonate + 357) * (100 / 23);
		} else if (mannmonate > 2800 && mannmonate <= 2900) {
			fp = (mannmonate + 645) * (50 / 17);
		} else if (fp >= 2900) {
			fp = 2900;
		}
		return fp;
	}
}
