package model;

public class Faktoren {
	private double verfechtung;
    private double dezentraleDaten;
    private double transaktionsrate;
    private double rechenoperationen;
	private double kontrollverfahren;
	private double ausnahmeregelung;
	private double logik;
	private double wiederverwendbarkeit;
	private double datenbestandskonvertierung;
	private double anpassbarkeit;
	private double[] faktoren;
	
	public Faktoren(){
		this.faktoren= new double[10];
        this.verfechtung = 0.0;
        this.dezentraleDaten = 0.0;
        this.transaktionsrate = 0.0;
        this.rechenoperationen = 0.0;
        this.kontrollverfahren = 0.0;
        this.ausnahmeregelung = 0.0;
        this.logik = 0.0;
        this.wiederverwendbarkeit = 0.0;
        this.datenbestandskonvertierung = 0.0;
        this.anpassbarkeit = 0.0;
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

    public double getDezentraleDaten() {
        return dezentraleDaten;
    }

    public void setDezentraleDaten(double dezentraleDaten) {
        this.dezentraleDaten = dezentraleDaten;
    }

    public double getTransaktionsrate() {
        return transaktionsrate;
    }

    public void setTransaktionsrate(double transaktionsrate) {
        this.transaktionsrate = transaktionsrate;
    }

    public double getRechenoperationen() {
        return rechenoperationen;
    }

    public void setRechenoperationen(double rechenoperationen) {
        this.rechenoperationen = rechenoperationen;
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
        this.faktoren[1] = this.dezentraleDaten;
        this.faktoren[2] = this.transaktionsrate;
        this.faktoren[3] = this.rechenoperationen;
		this.faktoren[4]=this.kontrollverfahren;
		this.faktoren[5]=this.ausnahmeregelung;
		this.faktoren[6]=this.logik;
		this.faktoren[7]=this.wiederverwendbarkeit;
		this.faktoren[8]=this.datenbestandskonvertierung;
		this.faktoren[9]=this.anpassbarkeit;
		return faktoren;
	}
	public static double calcunbewertefp(double bewertetefp, double[] factors){
		double fac= Faktoren.calcfac(factors);
		double unbewertetefp=  bewertetefp/ fac;
		return unbewertetefp;
	}
	public static  double calcbewertefp(double unbewertefp, double []factors){
		double fac = Faktoren.calcfac(factors);
		return unbewertefp*fac;
		
	}
	public static double calcfac(double[] factors){
		int sumfactors=0;
		double fac;
		for( double factor :factors){
			sumfactors+=factor;
		}
		fac= sumfactors/100 +0.7;
		return fac;
	}
}
