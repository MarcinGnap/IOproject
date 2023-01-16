import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KlientTest {
    private Klient klient;

    @Before
    public void setUp(){
      klient= new Klient("J","W",007,997,"woj@wp.pl");
    }

    @Test
    public void TestgetEmail() {
        Assert.assertEquals("woj@wp.pl", klient.getEmail());
    }

    @Test
    public void TestsetEmail() {
        klient.setEmail("nowy@gmail.com");
        Assert.assertEquals("nowy@gmail.com",klient.getEmail());
    }
}