package services;

import domainLogic.VerwaltbarerKuchen;
import kuchen.Allergen;
import verwaltung.Hersteller;

import java.util.Map;
import java.util.Set;

public interface CLIQueryService {
    Map<Hersteller,Integer> getHersteller();
    VerwaltbarerKuchen[] getKuchen(Class<?> kuchensorte);
    Set<Allergen> getAllergeneVorhanden();
    Set<Allergen> getAllergeneAbwesend();
}
