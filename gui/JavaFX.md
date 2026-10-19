# JavaFX einbinden

JavaFX ist nicht Teil des JDK und liegt der Vorlage nicht bei, weil es pro Betriebssystem unterschiedliche Pakete gibt. Es wird einmalig lokal installiert und als globale Library mit dem Namen `JavaFX` in IntelliJ IDEA eingetragen. Damit funktioniert dasselbe Projekt auf jedem Rechner, auf dem diese Library eingerichtet ist.

Bis dahin zeigt IntelliJ IDEA die Library `JavaFX` im Modul `gui` als fehlend an; das ist erwartet und verschwindet nach Schritt 2.

## 1. JavaFX SDK herunterladen

- Download: [JavaFX bei Gluon](https://gluonhq.com/products/javafx/)
- Version: 25 (passend zum JDK 25 der Vorlage)
- Typ: SDK
- Betriebssystem und Architektur passend zum eigenen Rechner wählen, bei macOS mit Apple-Chip (M1 und neuer) `aarch64`, sonst `x64`
- Archiv an einen Ort ohne Umlaute und Leerzeichen entpacken, z.B. `C:\javafx-sdk-25` oder `~/javafx-sdk-25`

## 2. Globale Library anlegen

1. In IntelliJ IDEA: File > Project Structure > Platform Settings > Global Libraries
2. `+` > Java, im entpackten SDK den Ordner `lib` auswählen
3. Library exakt `JavaFX` nennen (Groß- und Kleinschreibung beachten)

## 3. Library dem Modul zuordnen

Im Modul `gui` ist die Library `JavaFX` bereits eingetragen; sie wird gefunden, sobald sie unter dem Namen `JavaFX` angelegt ist (Schritt 2). Falls Code im Modul `belegProg3` JavaFX-Klassen direkt verwendet, muss sie dort zusätzlich eingetragen werden:

1. File > Project Structure > Project Settings > Modules > `belegProg3` > Dependencies
2. `+` > Library > `JavaFX` (unter Global Libraries), Scope `Compile`

## 4. Starten

In der Run Configuration der GUI unter Modify options > Add VM options eintragen (Pfad anpassen):

```text
--module-path "C:\javafx-sdk-25\lib" --add-modules javafx.controls,javafx.fxml
```

Unter Linux und macOS entsprechend z.B. `--module-path ~/javafx-sdk-25/lib`.

Ohne diese Option bricht der Start mit „JavaFX runtime components are missing“ ab.

## Hinweise

- Das SDK selbst gehört nicht in die Abgabe.
- JavaFX zählt nicht als zusätzliche Bibliothek im Sinne der Checkliste.
- Weitere Informationen: [Getting Started with JavaFX, IntelliJ](https://openjfx.io/openjfx-docs/#IDE-Intellij)
