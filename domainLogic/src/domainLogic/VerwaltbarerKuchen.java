package domainLogic;

import kuchen.Kuchen;
import verwaltung.Verkaufsobjekt;
import java.util.Date;

public interface VerwaltbarerKuchen extends Kuchen, Verkaufsobjekt {
    void setFachnummer(int fachnummer);
    void setInspektionsdatum(Date datum);
    void setEinfuegedatum(Date datum);
}