package auto_radnja.gume;

/**
 * Predstavlja auotomobilsku gumu.
 * 
 * Svaka guma ima marku i model, precnik, sirinu i visinu.
 * 
 * @author Sara
 * @version 1.0
 *
 */

public class AutoGuma {
	/**
	 *  Marka i model kao String.
	 */
	private String markaModel = null;
	/**
	 * Precnik gume kao int koji je inicijalizovan na -1.
	 */
	private int precnik = -1;
	
	/**
	 * Sirina gume kao int koja je inicijalizovana na -1.
	 */
	private int sirina = -1;
	/**
	 * Visina gume kao int koja je inicijalizovana na -1.
	 */
	private int visina = -1;

	/**
	 * Kreira objekat klase AutoGuma sa defaultnim vrednostima njegovih atributa. 
	 */
	public AutoGuma() {
	}

	/**
	 * Pravi objekat klase AutoGuma i postavlja vrednosti atributa na prosledjene vrednsoti.
	 * 
	 * Poziva set metode za sve parametre uz logicku kontrolu.
	 * 
	 * @param markaModel Marka i model gume. Ne sme biti null niti kraci od 3 karaktera.
	 * @param precnik Precnik gume. Mora biti manji od 13 ili veci od 22.
	 * @param sirina Sirina gume. Mora biti manja od 135 ili veca od 355.
	 * @param visina Visina gume. Mora biti manja od 25 ili veca od 95
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Vraca marku i model gume.
	 * 
	 * @return Marka i model gume kao String.
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja marku i model na unetu vrednost.
	 * 
	 * @param markaModel Novi naziv marke i modela.
	 * 
	 * @throws java.lang.NullPointerException Ako je prosledjena vrednost null.
	 * @throws java.lang.IllegalArgumentException Ako je unte marka i model String kraci od 3 karaktera.
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca precnik gume.
	 * @return Precnik gume kao int.
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja precnik gume na unetu vrednost.
	 * 
	 * @param precnik Novi precnik gume kao int.
	 * 
	 * @throws java.lang.IllegalArgumentException Ako je prosledjena vredsnot precnika van dozvoljenog opsega.
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca sirinu gume.
	 * 
	 * @return Sirina gume kao String.
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja siniru gume na unetu vrednost.
	 * 
	 * @param sirina Nova sirina gume kao int.
	 * 
	 * @throws java.lang.IllegalArgumentException Kada je uneta vrednost sirine van dozvoljenog opsega.
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca visinu gume.
	 * 
	 * @return Visina gume kao int.
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja visinu na unetu vredsnot.
	 * 
	 * @param visina Nova visina gume kao int.
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Vraca String s svim informacijama o gumi u formatu "AutoGuma [markaModel = ###, precnik = ###, sirina = ###, visina=###]".
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi dve gume po marki i modelu, precniku, sirini, visini.
	 * 
	 * @param obj Druga auto guma sa kojom se poredi.
	 * 
	 * @return
	 * <ul>
	 * <li><b>true</b> - Ako su oba objekat kalse AutoGuma i imaju istku markuModel, precnik, sirinu i visinu ili ako se nalaze na istoj adresi. </li>
	 * <li><b>false</b> - Ako je drugi objekat null, druge klase ili ako se razlikuje bar jedan od navedenih atributa. </li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}
