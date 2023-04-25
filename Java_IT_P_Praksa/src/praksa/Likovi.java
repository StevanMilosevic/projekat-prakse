package praksa;

import java.util.List;

public class Likovi {
    private String ime;
    private String alijansa;
    private String fajlSaPorukama;

    // za sad koristimo samo getIme()
    public String getIme() {
        return ime;
    }
    public String getAlijansa() {
        return alijansa;
    }
    public String getFajlSaPorukama() {
        return fajlSaPorukama;
    }

    Likovi(String ime, String alijansa, String fajlSaPorukama){
        this.ime = ime;
        this.alijansa = alijansa;
        this.fajlSaPorukama = fajlSaPorukama;
    }
    // krecemo od 1 zato sto svaki fajl ima DANY, JON, TYRION ili CERSEI na poziciji 0
    // ova metoda stampa sve poruke od svih likova
    public void stampajPoruke(){
        for(int i = 1; i < FileHelper.loadMessages(this.fajlSaPorukama).size(); i++){
            System.out.println(FileHelper.loadMessages(this.fajlSaPorukama).get(i));
        }
    }
    // brojimo poruke svakog od likova
    public int brojPoruka(){
        int brojac = 0;
        List<String> brojPoruka = FileHelper.loadMessages(this.fajlSaPorukama);
        for (int i = 1; i < brojPoruka.size(); i++) {
            if (brojPoruka.get(i).isBlank() || brojPoruka.get(i).isEmpty()) {
                break;
            } else {
               brojac++;
            }

        }
        return brojac;
    }

    // broji happy emoji od konkretnog lika (objekta)
    public static int happy(Likovi lik){
        int brojac = 0;

        for(int i = 0; i < FileHelper.loadMessages(lik.fajlSaPorukama).size(); i++){
            String[] reci = FileHelper.loadMessages(lik.fajlSaPorukama).get(i).split(" ");
            for(String rec : reci){
                for(String happyEmoji : Emojis.happy()){
                    if(rec.contains(happyEmoji)){
                        brojac++;
                    }
                }
            }
        }
        return brojac;
    }

    // broji sad emoji od konkretnog lika (objekta)
    public static int sad(Likovi lik){
        int brojac = 0;

        for(int i = 0; i < FileHelper.loadMessages(lik.fajlSaPorukama).size();i++){
            String[] reci = FileHelper.loadMessages(lik.fajlSaPorukama).get(i).split(" ");
            for(String rec : reci){
                for(String sadEmoji : Emojis.sad()){
                    if(rec.contains(sadEmoji)){
                        brojac++;
                    }
                }
            }
        }
        return brojac;
    }

    // zadatak ne trazi ovo da se broji, ali mi je potrebno
    // da bi se proverilo ko vise voli koga izmedju Jon i Daeneris -> koVoliVise()
    public static int love(Likovi lik){
        int brojac = 0;

        for(int i = 0; i < FileHelper.loadMessages(lik.fajlSaPorukama).size();i++){
            String[] reci = FileHelper.loadMessages(lik.fajlSaPorukama).get(i).split(" ");
            for(String rec : reci){
                for(String loveEmoji : Emojis.love()){
                    if(rec.contains(loveEmoji)){
                        brojac++;
                    }
                }
            }
        }
        return brojac;
    }


    // Проверити да ли „SAD“ има позитивну диспозицију (да ли је више срећан или тужан).
    public void dispozicija(){
        if(happy(this) > sad(this)){
            System.out.println(this.ime + " je vise srecan nego tuzan. Sreca: " + happy(this) + ", tuga: " + sad(this));
        } else if(happy(this) < sad(this)){
            System.out.println(this.ime + " je vise tuzan nego srecan. Sreca: " + happy(this) + ", tuga: " + sad(this));
        }else{
            System.out.println(this.ime + " je podjednako srecan i tuzan. Sreca: " + happy(this) + ", tuga: " + sad(this));
        }
    }

    // Да ли Jon воли Daenerys више него што она воли њега.
    public void koVoliVise(Likovi lik){
        if(love(this) > love(lik)){
            System.out.println(this.ime + " vise voli " + lik.ime + ". " + this.ime + ": " + love(this) + ", " + lik.ime + ": " + love(lik));
        } else if(love(this) < love(lik)){
            System.out.println(lik.ime + " vise voli " + this.ime + ". " + this.ime + ": " + love(this) + ", " + lik.ime + ": " + love(lik));
        }else{
            System.out.println("Podjednako se vole. " + this.ime + ": " + love(this) + ", " + lik.ime + ": " + love(lik));
        }
    }

    // Одштампати карактер који има најпозитивнију и најнегативнију диспозицију
    public static Likovi najpozitivnijiKarakter(SviLikovi sviLikovi){
        List<Likovi> svi = sviLikovi.getSveLikove();
        Likovi naj = svi.get(0);
        for (int i = 1; i < svi.size(); i++) {
            Likovi sledeci = svi.get(i);
            if (happy(sledeci) > happy(naj)) {
                naj = sledeci;
            }
        }
        return naj;
    }

    public static Likovi najnegativnijiKarakter(SviLikovi sviLikovi){
        List<Likovi> svi = sviLikovi.getSveLikove();
        Likovi najnegativniji = svi.get(0);
        for(int i = 1; i < svi.size(); i++){
            Likovi sledeci = svi.get(i);
            if(sad(sledeci) > sad(najnegativniji)){
                najnegativniji = sledeci;
            }
        }
        return najnegativniji;
    }
}