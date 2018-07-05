package model;

import java.io.Serializable;

public class FunctionPoints implements Serializable, FunctionPoints_I {

	private double istfp;
	private double sollfp;
	private double calcmannmonate;
	private double istmannmonate;
	private Konfiguration_I config;
	private Optimieren_I opti;

	public FunctionPoints(){
		this.istfp=0;
		this.sollfp=0;
		this.config= new Konfiguration();
	}

	public FunctionPoints(Konfiguration_I config, Optimieren_I opti){
		this.istfp=0;
		this.sollfp=0;
		this.config= config;
		this.opti=opti;
	}

	public Faktoren selbstoptimierung(double mannmonate, double[] userfaktoren){
		this.sollfp=config.calcfp(mannmonate);
		return opti.optimieren(this.istfp, this.sollfp, userfaktoren);
	}

	public void setOpti(Optimieren_I opti){
		this.opti=opti;
	}

	public double getCalcMannmonate() {
		return this.calcmannmonate;
	}

	public double getIstfp() {
		return istfp;
	}

	public void setIstfp(double istfp) {
		this.calcmannmonate = config.calcmannmonate(istfp);
		this.istfp = istfp;
	}

	public double getSollfp() {
		return sollfp;
	}

	public void setIstMannmonate(double mannmonate) {
		this.istmannmonate = mannmonate;
		this.sollfp= this.config.calcfp(mannmonate);

	}

	@Override
	public String toString() {
		return "FunctionPoints{" +
				"istfp=" + istfp +
				", sollfp=" + sollfp +
				", calcmannmonate=" + calcmannmonate +
				", istmannmonate=" + istmannmonate +
				", config=" + config +
				", opti=" + opti +
				'}';
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj != null && obj instanceof FunctionPoints) {
			FunctionPoints other = (FunctionPoints) obj;

			if(this.istfp != other.istfp) {return false;}
			if(this.sollfp != other.sollfp) {return false;}
			if(this.calcmannmonate != other.calcmannmonate) {return false;}
			if(this.istmannmonate != other.istmannmonate) {return false;}
			if(!this.config.equals(other.config)) {return false;}
			if(!this.opti.equals(other.opti)) {return false;}


			return true;

		}
		return false;
	}

}
