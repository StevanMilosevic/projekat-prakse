package praksa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class LikoviTest {

	@Test
    void brojPorukaTest1(){
        var lik = new Likovi("Daenerys Stormborn", "House Targaryen", "messages82387561293.txt");
        // assertEquals ima dva parametra, (expected, actual)
        assertEquals(17, lik.brojPoruka());
    }
    @Test
    void brojPorukaTest2(){
        var lik = new Likovi("Jon Snow", "House Stark", "messages2094721612573.txt");
        assertEquals(10, lik.brojPoruka());
    }
    @Test
    void brojPorukaTest3(){
        var lik = new Likovi("Tyrion Lannister", "House Lannister", "messages9287658288370.txt");
        assertEquals(15, lik.brojPoruka());
    }
    @Test
    void brojPorukaTest4(){
        var lik = new Likovi("Cersei Lannister", "House Lannister", "messages22274950573636.txt");
        assertEquals(10, lik.brojPoruka());
    }
    @Test
    void happyTest1(){
        Likovi lik = new Likovi("Daenerys Stormborn", "House Targaryen", "messages82387561293.txt");
        assertEquals(5, Likovi.happy(lik));
    }
    @Test
    void happyTest2(){
        var lik = new Likovi("Jon Snow", "House Stark", "messages2094721612573.txt");
        assertEquals(2, Likovi.happy(lik));
    }
    @Test
    void happyTest3(){
        var lik = new Likovi("Tyrion Lannister", "House Lannister", "messages9287658288370.txt");
        assertEquals(2, Likovi.happy(lik));
    }
    @Test
    void happyTest4(){
        var lik = new Likovi("Cersei Lannister", "House Lannister", "messages22274950573636.txt");
        assertEquals(0, Likovi.happy(lik));
    }
}
