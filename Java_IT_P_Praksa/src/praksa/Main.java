package praksa;

public class Main {
	public static void main(String[] args) {
		SviLikovi sviLikovi = new SviLikovi();
		String meta = FileHelper.loadMetaData();
		String[] redovi = meta.split("\n");

		for(int i = 1; i < redovi.length; i++){
			String[] podaci = redovi[i].split(", ");
			String ime = podaci[0];
			String alijansa = podaci[1].trim();
			String fajl = podaci[2].trim();

			Likovi c = new Likovi(ime, alijansa, fajl);
			sviLikovi.putCharacter(c);
		}

		Likovi daeneris = sviLikovi.getCharacter("Daenerys Stormborn");
		Likovi snow = sviLikovi.getCharacter("Jon Snow");
		Likovi tyrion = sviLikovi.getCharacter("Tyrion Lannister");
		Likovi cersei = sviLikovi.getCharacter("Cersei Lannister");
		// Одштампајте све поруке особе Daenerys
		System.out.println("Poruke Daeneris Stormborn: ");
		daeneris.stampajPoruke();
		System.out.println("======================");

		// Креирајте обавештење које приказује број порука који jе сваки карактер послао
		System.out.println("Broj poruka Daeneris Stormborn: " + daeneris.brojPoruka());
		System.out.println("Broj poruka Jon Snow: " + snow.brojPoruka());
		System.out.println("Broj poruka Tyrion Lannister: " + tyrion.brojPoruka());
		System.out.println("Broj poruka Cersei Lannister: " + cersei.brojPoruka());

		// Урадити анализу карактера, бројећи њихову употребу смајлија
		System.out.println("=============================");
		daeneris.dispozicija();
		snow.dispozicija();
		tyrion.dispozicija();
		cersei.dispozicija();

		// Одштампати карактер који има најпозитивнију и најнегативнију диспозицију
		System.out.println("=============================");
		Likovi c1 = Likovi.najpozitivnijiKarakter(sviLikovi);
		System.out.println("Najpozitivniji karakter je: " + c1.getIme());
		Likovi c2 = Likovi.najnegativnijiKarakter(sviLikovi);
		System.out.println("Najnegativniji karakter je: " + c2.getIme());

		// Да ли Jon воли Daenerys више него што она воли њега
		System.out.println("=============================");
		snow.koVoliVise(daeneris);
		// mozemo da ispitamo i ovako nesto:
		cersei.koVoliVise(daeneris);
	}
}