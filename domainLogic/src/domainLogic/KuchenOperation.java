package domainLogic;

import kuchen.Obstkuchen;
import verwaltung.Hersteller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KuchenOperation {

    private final List<Kuchen> kuchenListe = new ArrayList<>();
    private final int kapazitaet;
    private final List<Hersteller> herstellerList = new ArrayList<>();


    public boolean einfugen(Kuchen kuchen) {
        if (kuchen == null) {
            return false;
        }

        if (kuchenListe.contains(kuchen)) {
            return false;
        }

        if (kuchenListe.size() >= kapazitaet) {
            return false;
        }

        if (kuchen.getHersteller() == null || kuchen.getHersteller().getName() == null) {
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

            for (Kuchen vorhandenerKuchen : kuchenListe) {
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


    public boolean aendern(Kuchen kuchen,Date inspektionsDatum){
        if(kuchen == null || inspektionsDatum == null){
            return false;
        }
        if(!kuchenListe.contains(kuchen)){
            return false;
        }
        kuchen.setInspektionsdatum(inspektionsDatum);
        return true;
    }

    public boolean loeschen(Kuchen kuchen) {
        if (kuchen == null) {
            return false;
        }

        return kuchenListe.remove(kuchen);
    }

    public Kuchen[]auflisten(){
        return kuchenListe.toArray(new Kuchen[0]);
    }

    public KuchenOperation(int kapazitaet) {
        if (kapazitaet < 0) {
            throw new IllegalArgumentException("Kapazitaet darf nicht negativ sein.");
        }
        this.kapazitaet = kapazitaet;
    }

    public int getKapazitaet(){
        return kapazitaet;
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




}
