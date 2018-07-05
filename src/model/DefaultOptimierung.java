package model;
/**
 * Diese Klasse wird verwendet, wenn der User keine eigene Klasse für die Nachkalkulation verwendet
 *
 *
 */
public class DefaultOptimierung implements Optimieren_I {
	private String beschreibung;

	public DefaultOptimierung(){
		this.beschreibung="Default Optimierung";
	}
	
	@Override
	/**
	 * Bei dem Algorithmus wird nacheinander ein Faktor vergößert oder verkleinert.
	 * Ist das Limit erreicht wird der nächste Faktor verändert
	 * @param istfp bewerteFunctionPoints der aktuellen Projektes, sollfp aus den Mannmonaten, die das tatsächlich gedauert hat, berechnet
	 *  factors Bewertungsfaktoren der bisherigen Functionpointsanalyse
	 * @return optimerte Faktoren
	 */
	public Faktoren optimieren(double istfp, double sollfp, double[] factors) {
		String bemerkung="";
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

		//Sollte der Unterschied zwischen neuen berechnter Zeit und realer Zeit immer noch zu groß sein
		//wird das dem User mitgeteilt
		if(Math.abs(dif)>0.3){
			bemerkung="Differenz ist zu groß." +
					"\nSie müssen die FunctionPoints verändern!";
		}
		return new Faktoren(factors, bemerkung);
	}

	@Override
	public String getBeschreibung() {
		return this.beschreibung;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj != null && obj instanceof DefaultOptimierung) {
			DefaultOptimierung other = (DefaultOptimierung) obj;

			if(!this.beschreibung.equals(other.beschreibung)) {return false;}

			return true;

		}
		return false;
	}

}
