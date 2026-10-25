
package domainLogic;

import kuchen.Allergen;
import kuchen.Kremkuchen;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class KremkuchenImpl implements Kremkuchen, VerwaltbarerKuchen {

    private final Hersteller hersteller;
    private final Collection<Allergen> allergene;
    private final int naehrwert;
    private final Duration haltbarkeit;
    private final BigDecimal preis;
    private final String kremsorte;

    private Date einfuegedatum;
    private Date inspektionsdatum;
    private int fachnummer;

    public KremkuchenImpl(Hersteller hersteller, Collection<Allergen> allergene, int naehrwert,
            Duration haltbarkeit, BigDecimal preis, String kremsorte, Date einfuegedatum) {
        this.hersteller = hersteller;
        this.allergene = allergene;
        this.naehrwert = naehrwert;
        this.haltbarkeit = haltbarkeit;
        this.preis = preis;
        this.kremsorte = kremsorte;
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
    public String getKremsorte() {
        return kremsorte;
    }

    @Override
    public void setInspektionsdatum(Date datum) {
        this.inspektionsdatum = datum;
    }

    @Override
    public void setFachnummer(int fachnummer) {
        this.fachnummer = fachnummer;
    }

    @Override
    public void setEinfuegedatum(Date datum) {
        this.einfuegedatum = datum;
    }

    public Date getEinfuegedatum() {
        return einfuegedatum;
    }
}
