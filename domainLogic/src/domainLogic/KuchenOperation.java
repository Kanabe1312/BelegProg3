package domainLogic;

import verwaltung.Hersteller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KuchenOperation {

    private final List<ObstkuchenImpl> obstkuchenImplListe = new ArrayList<>();
    private final int kapazitaet;
    private final List<Hersteller> herstellerList = new ArrayList<>();


    public boolean einfugen(ObstkuchenImpl obstkuchenImpl) {
        if (obstkuchenImpl == null) {
            return false;
        }

        if (obstkuchenImplListe.contains(obstkuchenImpl)) {
            return false;
        }

        if (obstkuchenImplListe.size() >= kapazitaet) {
            return false;
        }

        if (obstkuchenImpl.getHersteller() == null || obstkuchenImpl.getHersteller().getName() == null) {
            return false;
        }

        boolean herstellerVorhanden = false;

        for (Hersteller hersteller : herstellerList) {
            if (hersteller.getName() != null && hersteller.getName().equals(obstkuchenImpl.getHersteller().getName())) {
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

            for (ObstkuchenImpl vorhandenerObstkuchenImpl : obstkuchenImplListe) {
                if (vorhandenerObstkuchenImpl.getFachnummer() == fachnummer) {
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

        obstkuchenImpl.setFachnummer(fachnummer);
        obstkuchenImpl.setEinfuegedatum(new Date());
        obstkuchenImplListe.add(obstkuchenImpl);

        return true;
    }


    public boolean aendern(ObstkuchenImpl obstkuchenImpl, Date inspektionsDatum){
        if(obstkuchenImpl == null || inspektionsDatum == null){
            return false;
        }
        if(!obstkuchenImplListe.contains(obstkuchenImpl)){
            return false;
        }
        obstkuchenImpl.setInspektionsdatum(inspektionsDatum);
        return true;
    }

    public boolean loeschen(ObstkuchenImpl obstkuchenImpl) {
        if (obstkuchenImpl == null) {
            return false;
        }

        return obstkuchenImplListe.remove(obstkuchenImpl);
    }

    public ObstkuchenImpl[]auflisten(){
        return obstkuchenImplListe.toArray(new ObstkuchenImpl[0]);
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
