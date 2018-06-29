# K.L.A.U.S
 **K**ann **L**egitime **A**nforderungen **U**nd **S**onstiges

Dieses Projekt dient der Erstellung von Anforderungsanalysen und Aufwandsabschätzungen für Softwareprojekte.

[Spezifikation](https://github.com/rasple/sw-eng-jfx/tree/master/spezifikation.pdf)

# Anforderungen
## Produktfunktionen
* Beim Anlegen festlegen ob Eingabe, Ausgabe oder Abfrage
* Bekannte FTRs und DETs eingeben
## Datenbestände
* Interner oder externer Datenbestand
* RETs und DETs abfragen
## Schätzkonfiguration
* Seite 15 Spezifikation
* Auswahl von dem User ob Standard oder berechnete Schätzfaktoren.
Des alten Projektes übernommen werden.
## Selbstoptimierte Nachkalkulation 
* Es wird ein Algo übergeben. Wird angewendet.
* Verändert zunächst einen Parameter bis Soll und Ist gleich sind.
 In den Einstellung kann verändert werden welcher Algo verwendet werden soll
* Muss modular als eigenes Jar-File austauschbar sein

So macht man Quellcode: (Nicht die Sprache vergessen)
```Java
// Hello World
System.out.println("Hello World");
```
 
Contributors:
* Frank Meier
* Simon Frank
* Johannes Lange