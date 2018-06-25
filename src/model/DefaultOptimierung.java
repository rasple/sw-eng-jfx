package model;
/**
 * Diese Klasse wird verwendet, wenn der User keine eigene Klasse für die Nachkalkulation verwendet
 *
 *
 */
public class DefaultOptimierung implements Optimieren_I {

	
	@Override
	public double[] optimieren(double istfp, double sollfp, double[] factors) {
		// TODO Auto-generated method stub
		final double unbewertetefp= this.calcunbewertefp(istfp, factors);
		int pos=0, maxpos= factors.length;
		double dif=istfp-sollfp, currentfp;
		boolean groesser;
		if(sollfp>istfp){
			groesser=true;
		}
		else if( sollfp==istfp){
			return factors;
		}
		else{
			groesser=false;
		}
		//hier kannst du bei dem testen ein wenig rumspielen, was am besten ist
		while(Math.abs(dif)>0.2 && pos<maxpos){
			if(groesser){
				factors[pos]=+0.1;
				if(factors[pos]>=5){
					factors[pos]=5;
					pos++;
				}
			}
			else{
				factors[pos]=-0.1;
				if(factors[pos]<=0){
					factors[pos]=0;
					pos++;
				}
			}
			currentfp= this.calcbewertefp(unbewertetefp, factors);
			dif= currentfp-sollfp;
		}
		return factors;
	}
	private double calcunbewertefp(double bewertetefp, double[] factors){
		double fac= this.calcfac(factors);
		double unbewertetefp=  bewertetefp/ fac;
		return unbewertetefp;
	}
	private double calcbewertefp(double unbewertefp, double []factors){
		double fac = this.calcfac(factors);
		return unbewertefp*fac;
		
	}
	private double calcfac(double[] factors){
		int sumfactors=0;
		double fac;
		for( double factor :factors){
			sumfactors+=factor;
		}
		fac= sumfactors/100 +0.7;
		return fac;
	}
}
