package nachkalkulation;
/**
 * Um die Nachkalkualtion selber zu erweitern muss die Klasse des Users, nur dieses Interface implementieren
 * Abstract Factory
 */
public interface Fabrik_I {
	Optimieren_I create();
}
