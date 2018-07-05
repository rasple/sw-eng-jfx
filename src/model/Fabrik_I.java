package model;
/**
 * Um die Nachkalkualtion selber zu erweitern muss die Klasse des Users, nur dieses Interface implementieren
 * Design Pattern: Abstract Factory
 */
public interface Fabrik_I {
	Optimieren_I create();
}
