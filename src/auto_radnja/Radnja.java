package auto_radnja;

import java.util.List;

import auto_radnja.gume.AutoGuma;

/**
 * Predstavlja radnju u kojoj se prodaju gume.
 * 
 * @author Sara
 * @version 1.0
 *
 */
public interface Radnja {
	
	/**
	 * Dodaje gumu u radnji.
	 * 
	 * Guma ne sme biti null i duplikat.
	 * 
	 * @param a Nova auto guma koja se dodaje.
	 * 
	 * @throws java.lang.NullPointerException Ako je uneta guma null.
	 * @throws java.lang.IllegalArgumentException Ako uneta guma vec postoji u radnji.
	 */
	void dodajGumu(AutoGuma a);
	
	/**
	 * Pretrazuje radnju i vraca sve gume cinji naziv marke i modela sadrzi uneti String.
	 * 
	 * @param markaModel Deo naziva ili ceo naziv marke i modela po kojem se pretrazuju gume.
	 * 
	 * @return Vraca listu sa gumama koje u nazivu marke i modela sadrze prosledjeni String, praznu listu ukoliko nijedna knjiga ne sadrzi unet String u nazivu marke i modela ili null ukoliko je uneti kriterijum null.
	 * 
	 * @throws 
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);
	
	/**
	 * Vraca sve gume iz radnje.
	 * 
	 * @return Listu svih guma iz radnje ili praznu listu ukoliko u radnji nema niejdne gume.
	 */
	List<AutoGuma> vratiSveGume();
}
