package praksa;

import java.util.ArrayList;
import java.util.List;

/*
* Emoji se smestaju u 3 metode, koje vracaju ArrayList emoji-a za kategorije happy, sad i love
* Ideja je da se kasnije ovo iskoristi kada se ispituju poruke svakog od likova, koliko znakova u poruci se poklapaju
* sa odredjenom grupom emojia
* */
public class Emojis {

    public static List<String> happy(){
        List<String> happyEmoji = new ArrayList<>();
        happyEmoji.add("\uD83D\uDE04");
        happyEmoji.add("\uD83D\uDE42");
        happyEmoji.add("\uD83D\uDE0A");
        happyEmoji.add("\uD83D\uDE0D");

        return happyEmoji;
    }

    public static List<String> sad(){
        List<String> sadEmoji = new ArrayList<>();
        sadEmoji.add("\uD83D\uDE22");
        sadEmoji.add("\uD83D\uDE2D");
        sadEmoji.add("\uD83D\uDE1E");
        sadEmoji.add("\uD83D\uDC7F");

        return sadEmoji;
    }

    public static List<String> love(){
        List<String> lovingEmoji = new ArrayList<>();
        lovingEmoji.add("\uD83D\uDE0D");
        lovingEmoji.add("\uD83D\uDE18");

        return lovingEmoji;
    }
}
