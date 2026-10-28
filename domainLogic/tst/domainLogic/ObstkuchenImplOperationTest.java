package domainLogic;

import kuchen.Kuchen;
import kuchen.Obstkuchen;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import verwaltung.Hersteller;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObstkuchenImplOperationTest {

    @Test
    void einfugenReturnsFalseWhenKuchenIsNull(){
        //Arrange
       KuchenOperation kuchenOperation = new KuchenOperation(5);
        //Act
        boolean result = kuchenOperation.einfugen(null);

        //Assert
        assertFalse(result);
    }

    @Test
    void einfugenReturnsFalseWhenHerstellerIsNull() {
        // Arrange
        KuchenOperation operation = new KuchenOperation(5);

        VerwaltbarerKuchen kuchen = mock(VerwaltbarerKuchen.class);
        when(kuchen.getHersteller()).thenReturn(null);

        // Act
        boolean resultat = operation.einfugen(kuchen);

        // Assert
        assertFalse(resultat);
    }

    @Test
    void herstellerEinfuegenReturnsFalseWhenHerstellerIsNull() {
        // Arrange
        KuchenOperation kuchenOperation = new KuchenOperation(5);

        // Act
        boolean resultat = kuchenOperation.herstellerEinfuegen(null);

        // Assert
        assertFalse(resultat);
    }

}