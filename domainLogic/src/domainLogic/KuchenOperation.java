package domainLogic;

import kuchen.Allergen;
import verwaltung.Hersteller;

import java.util.*;

public class KuchenOperation {

    private final List<VerwaltbarerKuchen> kuchenListe = new ArrayList<>();
    private final int kapazitaet;
    private final List<Hersteller> herstellerList = new ArrayList<>();



    public boolean einfugen(VerwaltbarerKuchen kuchen) {
        if (kuchen == null) {
            return false;
        }
        if (kuchenListe.contains(kuchen)) {
            return false;
        }
        if (kuchenListe.size() >= kapazitaet) {
            return false;
        }
        if (kuchen.getHersteller() == null|| kuchen.getHersteller().getName() == null) {
            return false;
        }
        boolean herstellerVorhanden = false;

        for (Hersteller hersteller : herstellerList) {
            if (hersteller.getName() != null && hersteller.getName().equals(kuchen.getHersteller().getName())) {
                herstellerVorhanden = true;
                break;
            }
        }
        if (!herstellerVorhanden) {
            return false;
        }

        int fachnummer = 1;
        while (fachnummer <= kapazitaet) {
            boolean belegt = false;

            for (VerwaltbarerKuchen vorhandenerKuchen : kuchenListe) {
                if (vorhandenerKuchen.getFachnummer() == fachnummer) {
                    belegt = true;
                    break;
                }
            }
            if (!belegt) {
                break;
            }
            fachnummer++;
        }

        if (fachnummer > kapazitaet) {
            return false;
        }

        kuchen.setFachnummer(fachnummer);
        kuchen.setEinfuegedatum(new Date());
        kuchenListe.add(kuchen);
        return true;
    }

    //QUELLE : OpenAI Gpt-6,26.10.2026
    public VerwaltbarerKuchen[] auflisten(Class<?> kuchensorte) {
        if (kuchensorte == null) {
            return auflisten();
        }

        List<VerwaltbarerKuchen> gefiltert = new ArrayList<>();

        for (VerwaltbarerKuchen kuchen : kuchenListe) {
            if (kuchensorte.isInstance(kuchen)) {
                gefiltert.add(kuchen);
            }
        }

        return gefiltert.toArray(new VerwaltbarerKuchen[0]);
    }
    // QUELLE ENDE

    public boolean aendern(VerwaltbarerKuchen kuchen, Date inspektionsDatum) {
        if (kuchen == null || inspektionsDatum == null) {
            return false;
        }
        if (!kuchenListe.contains(kuchen)) {
            return false;
        }
        kuchen.setInspektionsdatum(inspektionsDatum);
        return true;
    }

    public boolean loeschen(VerwaltbarerKuchen kuchen) {
        if (kuchen == null) {
            return false;
        }

        return kuchenListe.remove(kuchen);
    }

    public VerwaltbarerKuchen[] auflisten() {
        return kuchenListe.toArray(new VerwaltbarerKuchen[0]);
    }

    public int getKapazitaet(){
        return kapazitaet;
    }

    public KuchenOperation(int kapazitaet) {
        if (kapazitaet < 0) {
            throw new IllegalArgumentException("Kapazitaet darf nicht negativ sein.");
        }
        this.kapazitaet = kapazitaet;
    }

    public boolean herstellerEinfuegen(Hersteller hersteller) {
        if (hersteller == null || hersteller.getName() == null) {
            return false;
        }

        for (Hersteller vorhandenerHersteller : herstellerList) {
            if (vorhandenerHersteller.getName().equals(hersteller.getName())) {
                return false;
            }
        }
        herstellerList.add(hersteller);
        return true;
    }


    //QUELLE : OpenAI Gpt-6,26.10.2026

    public Map<Hersteller, Integer> herstellerAuflisten() {
        Map<Hersteller, Integer> ergebnis = new LinkedHashMap<>();

        for (Hersteller hersteller : herstellerList) {
            ergebnis.put(hersteller, 0);
        }

        for (VerwaltbarerKuchen kuchen : kuchenListe) {
            Hersteller hersteller = kuchen.getHersteller();

            for (Hersteller registriert : herstellerList) {
                if (registriert.getName().equals(hersteller.getName())) {
                    ergebnis.put(registriert, ergebnis.get(registriert) + 1);
                    break;
                }
            }
        }

        return ergebnis;
    }
    // QUELLE ENDE

    public Set<Allergen> allergeneVorhanden() {
        Set<Allergen> vorhanden = new HashSet<>();

        for (VerwaltbarerKuchen kuchen : kuchenListe) {
            Collection<Allergen> allergene = kuchen.getAllergene();

            if (allergene != null) {
                vorhanden.addAll(allergene);
            }
        }

        return vorhanden;
    }

    public Set<Allergen> allergeneAbwesend() {
        Set<Allergen> abwesend = new HashSet<>();

        for (Allergen allergen : Allergen.values()) {
            abwesend.add(allergen);
        }

        abwesend.removeAll(allergeneVorhanden());

        return abwesend;
    }

    //QUELLE : OpenAI Gpt-6,26.10.2026
    public boolean herstellerLoeschen(Hersteller hersteller) {
        if (hersteller == null || hersteller.getName() == null) {
            return false;
        }
        Hersteller registrierterHersteller = null;

        for (Hersteller vorhandenerHersteller : herstellerList) {
            if (vorhandenerHersteller.getName().equals(hersteller.getName())) {
                registrierterHersteller = vorhandenerHersteller;
                break;
            }
        }

        if (registrierterHersteller == null) {
            return false;
        }

        String herstellerName = registrierterHersteller.getName();

        kuchenListe.removeIf(kuchen -> kuchen.getHersteller() != null && kuchen.getHersteller().getName() != null
                && kuchen.getHersteller().getName().equals(herstellerName)
        );

        herstellerList.remove(registrierterHersteller);
        return true;
    }
    // QUELLE ENDE




}
