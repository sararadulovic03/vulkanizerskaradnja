package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	Radnja r;
	AutoGuma ag1, ag2;

	protected abstract Radnja getInstance();

	@BeforeEach
	void setUp() throws Exception {
		r = getInstance();

		ag1 = new AutoGuma("Michelin Pilot", 16, 205, 55);
		ag2 = new AutoGuma("Sava Eskimo", 15, 195, 65);
	}

	@AfterEach
	void tearDown() throws Exception {
		r = null;
	}

	@Test
	void testDodajGumu() {
		r.dodajGumu(ag1);
		r.dodajGumu(ag2);
		
		List<AutoGuma> gume = r.vratiSveGume();
		
		assertEquals(2, gume.size());
		assertTrue(gume.contains(ag1));
		assertTrue(gume.contains(ag2));
	}
	
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, () -> r.dodajGumu(null));
	}

	@Test
	void testDodajGumuPostoji() {
		r.dodajGumu(ag1);
		
		AutoGuma ag3 = new AutoGuma("Michelin Pilot", 16, 205, 55);
		assertThrows(java.lang.RuntimeException.class, () -> r.dodajGumu(ag3));
	}
	
	@Test
	void testPronadjiGumuNull() {
		assertNull(r.pronadjiGumu(null));
	}
	
	@Test
	void testPronadjiGumuPrazno() {
		ag1.setMarkaModel("Michelin Pilot");
		ag2.setMarkaModel("Michelin Pilot");
		
		r.dodajGumu(ag1);
		r.dodajGumu(ag2);
		
		List<AutoGuma> gume = r.pronadjiGumu("ab");
		
		assertEquals(0, gume.size());
	}

	@Test
	void testPronadjiGumuVise() {
		ag1.setMarkaModel("MichELin Pilot");
		ag2.setMarkaModel("michelin Pilot");
		
		AutoGuma ag3 = new AutoGuma("Sava Eskimo", 15, 195, 65);
		
		r.dodajGumu(ag1);
		r.dodajGumu(ag2);
		r.dodajGumu(ag3);
		
		List<AutoGuma> gume = r.pronadjiGumu("CHE");
		
		assertEquals(2, gume.size());
		assertTrue(gume.contains(ag1));
		assertTrue(gume.contains(ag2));
	}
	
	
	@Test
	void testVratiSveGume() {
		r.dodajGumu(ag1);
		r.dodajGumu(ag2);
		
		List<AutoGuma> gume = r.vratiSveGume();
		
		assertEquals(2, gume.size());
		assertTrue(gume.contains(ag1));
		assertTrue(gume.contains(ag2));
		
	}

}
