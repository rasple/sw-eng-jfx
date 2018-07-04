package model;
/**
 * Diese Klasse wird verwendet, wenn der User keine eigene Klasse für die Nachkalkulation verwendet
 *
 *
 */
public class DefaultOptimierung implements Optimieren_I {

	
	@Override
	
	public Faktoren optimieren(double istfp, double sollfp, double[] factors) {
		// TODO Auto-generated method stub <- professionalism.avi
		final double unbewertetefp= Faktoren.calcunbewertefp(istfp, factors);
		int pos=0, maxpos= factors.length;
		double dif=istfp-sollfp, currentfp;
		boolean groesser;
		if(sollfp>istfp){
			groesser=true;
		}
		else if( sollfp==istfp){
			return new Faktoren(factors);
		}
		else{
			groesser=false;
		}
		//hier kannst du bei dem testen ein wenig rumspielen, was am besten ist
		while(Math.abs(dif)>0.2 && pos<maxpos){
			if(groesser){
				factors[pos]+=0.1;
				if(factors[pos]>=5){
					factors[pos]=5;
					pos++;
				}
			}
			else{
				factors[pos]-=0.1;
				if(factors[pos]<=0){
					factors[pos]=0;
					pos++;
				}
			}
			currentfp= Faktoren.calcbewertefp(unbewertetefp, factors);
			dif= currentfp-sollfp;
		}
		return new Faktoren(factors);
	}
	
	
}
