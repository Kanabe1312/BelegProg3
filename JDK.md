# JDK einrichten

Die Vorlage ist für JDK 25 eingerichtet. JDK 25 ist eine LTS-Version (Long-Term Support) und wird über Jahre mit Sicherheits- und Fehlerkorrekturen versorgt.

**Eine LTS-Version wird unbedingt empfohlen.** Neuere Versionen ohne LTS (z.B. 26 oder 27) erhalten nur ein halbes Jahr Updates und können sich mit JavaFX, Mockito oder IntelliJ IDEA anders verhalten als die Version, mit der bewertet wird.

Ältere Versionen (z.B. die LTS-Version 21) werden ebenfalls nicht empfohlen:

- Die Vorlage ist auf Sprachniveau 25 eingestellt; ein älteres JDK kann das Projekt so nicht übersetzen.
- JavaFX 25 setzt mindestens JDK 23 voraus.
- Sprachmittel, die erst nach JDK 21 fertiggestellt wurden (z.B. unbenannte Variablen `_`, Javadoc-Kommentare in Markdown), fehlen dort.
- Versionen, die keine Updates mehr erhalten (z.B. 22 bis 24 oder sehr alte JDKs), bekommen auch keine Sicherheitskorrekturen; bekannte Sicherheitslücken bleiben dort offen.

## Installation über IntelliJ IDEA

1. File > Project Structure > Platform Settings > SDKs
2. `+` > Download JDK
3. Version 25, Anbieter mit LTS-Updates wählen, z.B. Eclipse Temurin
4. Unter Project Settings > Project dieses JDK als SDK auswählen

Die Builds „Oracle OpenJDK“ (jdk.java.net) erhalten keine LTS-Updates und sind daher weniger geeignet.

## Meldung „Project JDK is not defined“

Die Vorlage erwartet ein JDK mit dem Namen `temurin-25` (so benennt IntelliJ IDEA ein heruntergeladenes Eclipse Temurin 25). Ist das eigene JDK anders benannt, zeigt IntelliJ IDEA diese Meldung. Über „Setup SDK“ das installierte JDK 25 auswählen; damit ist das Projekt eingerichtet.

## Warnung beim Ausführen von Tests mit Mockito

Ab Java 21 erscheint beim Ausführen von Tests, die Mockito verwenden, u.a. folgende Warnung:

```text
WARNING: A Java agent has been loaded dynamically (…byte-buddy-agent-….jar)
WARNING: Dynamic loading of agents will be disallowed by default in a future release
```

Die Warnung ist harmlos, die Tests laufen korrekt. Wer sie ausblenden möchte, trägt die VM-Option `-XX:+EnableDynamicAgentLoading` in die Vorlage für JUnit-Konfigurationen ein:

1. Run > Edit Configurations > Edit configuration templates > JUnit
2. Modify options > Add VM options
3. `-XX:+EnableDynamicAgentLoading` eintragen

Die Einstellung gilt dann für alle neu angelegten JUnit-Konfigurationen in diesem Projekt.

Hintergrund zur Warnung: [JEP 451: Prepare to Disallow the Dynamic Loading of Agents](https://openjdk.org/jeps/451)
