package nachkalkulation;
import aufwandsabschaetzung.*;

public class FunctionPoints {
	private double istfp;
	private double sollfp;
	private double mannmonate;
	private Konfiguration_I config;
	
	public FunctionPoints(){
		this.istfp=0;
		this.sollfp=0;
		this.config= new Konfiguration();
	}

	public double getIstfp() {
		return istfp;
	}

	public void setIstfp(double istfp) {
		this.istfp = istfp;
	}

	public double getSollfp() {
		return sollfp;
	}


	public double getMannmonate() {
		return mannmonate;
	}

	public void setMannmonate(double mannmonate) {
		this.mannmonate = mannmonate;
		this.sollfp= this.config.calcfp(mannmonate);
		
	}
}
