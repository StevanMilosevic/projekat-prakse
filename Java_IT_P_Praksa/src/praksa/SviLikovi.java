package praksa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* za potrebe ispitivanja koliko koji lik ima emoji-a
* metode iz klase Likovi najpozitivnijiKarakter() i najnegativnijiKarakter() su za sad ostali u klasi Likovi
* */

public class SviLikovi {
    private Map<String, Likovi> likovi;

    public SviLikovi(){
        likovi = new HashMap<>();
    }

    public void putCharacter(Likovi c){
        likovi.put(c.getIme(), c);
    }

    public Likovi getCharacter(String ime){
        return likovi.get(ime);
    }
    public List<Likovi> getSveLikove(){
        return new ArrayList<>(likovi.values());
    }
}
