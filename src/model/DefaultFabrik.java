package model;

/**
 * 
 * Erzeugt die Klasse DefaultOptimierung
 *
 */
public class DefaultFabrik implements Fabrik_I {

	@Override
	public Optimieren_I create() {
		return new DefaultOptimierung();
	}

}
