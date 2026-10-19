package domainLogic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KuchenOperationTest {

    @Test
    void einfuegen_nullValue() {
        KuchenOperation op = new KuchenOperation();

        boolean r = op.einfuegen(null);

        assertFalse(r);
    }

    @Test
    void einfuegen_duplicate() {
        KuchenOperation op = new KuchenOperation();
        Kuchen kuchen = new Kuchen();
        op.einfuegen(kuchen);

        boolean r = op.einfuegen(kuchen);

        assertFalse(r);
    }

    @Test
    void einfuegen_keinduplicate() {
        KuchenOperation op = new KuchenOperation();
        Kuchen kuchen = new Kuchen();
        op.einfuegen(kuchen);
        Kuchen neuerKuchen = new Kuchen();

        boolean r = op.einfuegen(neuerKuchen);

        assertTrue(r);
    }

    @Test
    void aendern() {
        fail();
    }

    @Test
    void loeschen() {
        fail();
    }

    @Test
    void auflisten() {
        fail();
    }
}