package services;

import kuchen.Allergen;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public interface CLICommandService {

    boolean addHersteller(String name);

    boolean addKuchen(Hersteller hersteller, Collection<Allergen> allergene,
            int naehrwert, Duration haltbarkeit, BigDecimal preis, String obstsorte);

    boolean updateInspektionsdatum(int fachnummer, Date datum);

    boolean deleteKuchen(int fachnummer);
}
