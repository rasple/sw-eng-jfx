package nachkalkulation;

public class Faktoren {
	private double verfechtung;
	private double dezentrale_daten;
	private double tranksaktionsrate;
	private double rechnenoperationen;
	private double kontrollverfahren;
	private double ausnahmeregelung;
	private double logik;
	private double wiederverwendbarkeit;
	private double datenbestandskonvertierung;
	private double anpassbarkeit;
	private double[] faktoren;
	
	public Faktoren(){
		this.faktoren= new double[10];
	}
	public Faktoren(double[] faktoren){
		int pos=0;
		this.faktoren= new double[10];
		for(double faktor: faktoren){
			this.faktoren[pos]=faktor;
			pos++;
		}
	}
	public double getVerfechtung() {
		return verfechtung;
	}
	public void setVerfechtung(double verfechtung) {
		this.verfechtung = verfechtung;
	}
	public double getDezentrale_daten() {
		return dezentrale_daten;
	}
	public void setDezentrale_daten(double dezentrale_daten) {
		this.dezentrale_daten = dezentrale_daten;
	}
	public double getTranksaktionsrate() {
		return tranksaktionsrate;
	}
	public void setTranksaktionsrate(double tranksaktionsrate) {
		this.tranksaktionsrate = tranksaktionsrate;
	}
	public double getRechnenoperationen() {
		return rechnenoperationen;
	}
	public void setRechnenoperationen(double rechnenoperationen) {
		this.rechnenoperationen = rechnenoperationen;
	}
	public double getKontrollverfahren() {
		return kontrollverfahren;
	}
	public void setKontrollverfahren(double kontrollverfahren) {
		this.kontrollverfahren = kontrollverfahren;
	}
	public double getAusnahmeregelung() {
		return ausnahmeregelung;
	}
	public void setAusnahmeregelung(double ausnahmeregelung) {
		this.ausnahmeregelung = ausnahmeregelung;
	}
	public double getLogik() {
		return logik;
	}
	public void setLogik(double logik) {
		this.logik = logik;
	}
	public double getWiederverwendbarkeit() {
		return wiederverwendbarkeit;
	}
	public void setWiederverwendbarkeit(double wiederverwendbarkeit) {
		this.wiederverwendbarkeit = wiederverwendbarkeit;
	}
	public double getDatenbestandskonvertierung() {
		return datenbestandskonvertierung;
	}
	public void setDatenbestandskonvertierung(double datenbestandskonvertierung) {
		this.datenbestandskonvertierung = datenbestandskonvertierung;
	}
	public double getAnpassbarkeit() {
		return anpassbarkeit;
	}
	public void setAnpassbarkeit(double anpassbarkeit) {
		this.anpassbarkeit = anpassbarkeit;
	}

	public double[] getFaktoren() {
		this.faktoren[0]=this.verfechtung;
		this.faktoren[1]=this.dezentrale_daten;
		this.faktoren[2]=this.tranksaktionsrate;
		this.faktoren[3]=this.rechnenoperationen;		
		this.faktoren[4]=this.kontrollverfahren;
		this.faktoren[5]=this.ausnahmeregelung;
		this.faktoren[6]=this.logik;
		this.faktoren[7]=this.wiederverwendbarkeit;
		this.faktoren[8]=this.datenbestandskonvertierung;
		this.faktoren[9]=this.anpassbarkeit;
		return faktoren;
	}
	
}
