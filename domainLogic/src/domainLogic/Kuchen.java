package domainLogic;

import kuchen.Allergen;
import kuchen.Obstkuchen;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.util.Date;
import java.time.Duration;
import java.util.Collection;

public class Kuchen implements Obstkuchen {

    private final Hersteller hersteller;
    private final Collection<Allergen> allergene;
    private final int naehrwert;
    private final Duration haltbarkeit;
    private final BigDecimal preis;
    private final String obstsorte;
    private  Date einfuegedatum;

    private Date inspektionsdatum;
    private int fachnummer;

    public Kuchen(Hersteller hersteller,Collection<Allergen> allergene,int naehrwert,
                  Duration haltbarkeit,BigDecimal preis,String obstsorte,Date einfuegedatum) {
        this.hersteller = hersteller;
        this.allergene = allergene;
        this.naehrwert = naehrwert;
        this.haltbarkeit = haltbarkeit;
        this.preis = preis;
        this.obstsorte = obstsorte;
        this.einfuegedatum = einfuegedatum;
    }

    @Override
    public Hersteller getHersteller() {
        return hersteller;
    }

    @Override
    public Collection<Allergen> getAllergene() {
        return allergene;
    }

    @Override
    public int getNaehrwert() {
        return naehrwert;
    }

    @Override
    public Duration getHaltbarkeit() {
        if (einfuegedatum == null) {
            return haltbarkeit;
        }

        long start = System.currentTimeMillis() - einfuegedatum.getTime();
        Duration end = Duration.ofMillis(start);

        return haltbarkeit.minus(end);
    }

    @Override
    public BigDecimal getPreis() {
        return preis;
    }

    @Override
    public Date getInspektionsdatum() {
        return inspektionsdatum;
    }

    @Override
    public int getFachnummer() {
        return fachnummer;
    }

    @Override
    public String getObstsorte() {
        return obstsorte;
    }



    void setInspektionsdatum(Date inspektionsdatum) {
        this.inspektionsdatum = inspektionsdatum;
    }

    void setFachnummer(int fachnummer) {
        this.fachnummer = fachnummer;
    }
    public Date getEinfuegedatum() {
        return einfuegedatum;
    }

    void setEinfuegedatum(Date einfuegedatum) {
        this.einfuegedatum = einfuegedatum;
    }

}
