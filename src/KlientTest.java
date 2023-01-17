import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Vector;
import org.junit.experimental.categories.Category;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//@RunWith(Parameterized.class)
public class KlientTest {
    private Klient klient;

    @Before
    public void setUp(){
      klient= new Klient("J","W",007,997,"woj@wp.pl");
    }
    final Transakcja transakcja = new Transakcja(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1), 10.0f,
            new Vector(List.of(new Produkt("nazwa", 1.0f, 0, 'a'))), 0.0f);


    @Category({KlientTest.class})
    @Test
    public void TestgetEmail() {
        Assert.assertEquals("woj@wp.pl", klient.getEmail());
    }

    @Category({KlientTest.class})
    @Test
    public void TestsetEmail() {
        klient.setEmail("nowy@gmail.com");
        Assert.assertEquals("nowy@gmail.com",klient.getEmail());
    }


    //dziesiejsza data przed rezerwacją
    @Category({KlientTest.class})
    @Test
    public void testAnulujRezerwacje() {
        final boolean result = klient.anulujRezerwacje(transakcja, LocalDate.of(2019, 1, 1));
        assertTrue(result);
    }
    //dziesiejsza data po rezerwacji
    @Category({KlientTest.class})
    @Test
    public void testAnulujRezerwacje1() {
        final boolean result = klient.anulujRezerwacje(transakcja, LocalDate.of(2020, 1, 1));
        assertFalse(result);
    }


}