package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class AutoGumaTest {
	
	AutoGuma ag;
	
	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}

	@Test
	void testAutoGuma() {
		assertNotNull(ag);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		ag = new AutoGuma("Michelin Pilot", 18, 225, 45);
		
		assertNotNull(ag);
		assertEquals("Michelin Pilot", ag.getMarkaModel());
		assertEquals(18, ag.getPrecnik());
		assertEquals(225, ag.getSirina());
		assertEquals(45, ag.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("Michelin Pilot");
		assertEquals("Michelin Pilot", ag.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, ()-> ag.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelKratko() {
		assertThrows(java.lang.IllegalArgumentException.class, ()-> ag.setMarkaModel("Ma"));
		assertThrows(java.lang.IllegalArgumentException.class, ()-> ag.setMarkaModel("M"));
		assertThrows(java.lang.IllegalArgumentException.class, ()-> ag.setMarkaModel(""));
	}

	@ParameterizedTest
	@CsvSource({
		"13","15","22"
	})
	void testSetPrecnik(int precnik) {
		ag.setPrecnik(precnik);
		assertEquals(precnik, ag.getPrecnik());
	}
	
	@Test
	void testSetPrecnikVanOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setPrecnik(10));
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setPrecnik(23));
	}

	@ParameterizedTest
	@CsvSource({
		"135","170","355"
	})
	void testSetSirina(int sirina) {
		ag.setSirina(sirina);
		
		assertEquals(sirina, ag.getSirina());
	}
	
	@Test
	void testSetSirinaVanOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setSirina(25));
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setSirina(370));
	}

	@ParameterizedTest
	@CsvSource({
		"25","50","95"
	})
	void testSetVisina(int visina) {
		ag.setVisina(visina);
		assertEquals(visina, ag.getVisina());
	}
	
	@Test
	void testSetVisinaVanOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setVisina(24));
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setVisina(96));
	}

	@Test
	void testToString() {
		ag.setMarkaModel("Michelin Pilot");
		ag.setPrecnik(15);
		ag.setSirina(150);
		ag.setVisina(70);
		
		String s = ag.toString();
		
		assertTrue(s.contains("Michelin Pilot"));
		assertTrue(s.contains(String.valueOf(15)));
		assertTrue(s.contains("150"));
		assertTrue(s.contains(String.valueOf(70)));
	}

	@ParameterizedTest
	@CsvSource({
		"Michelin Pilot, 15, 150, 70, Michelin Pilot, 15, 150, 70, true",
		"Michelin Pilot, 15, 150, 70, Michelin Milot, 15, 150, 70, false",
		"Michelin Pilot, 15, 150, 70, Michelin Pilot, 20, 150, 70, false",
		"Michelin Pilot, 15, 150, 70, Michelin Pilot, 15, 170, 70, false",
		"Michelin Pilot, 15, 150, 70, Michelin Pilot, 15, 150, 80, false",
	})
	void testEqualsObject(String m1, int p1, int s1, int v1, String m2, int p2, int s2, int v2, boolean isto) {
		ag.setMarkaModel(m1);
		ag.setPrecnik(p1);
		ag.setSirina(s1);
		ag.setVisina(v1);
		
		AutoGuma ag2 = new AutoGuma(m2, p2, s2, v2);
		
		assertEquals(isto, ag.equals(ag2));
		
	}
	
	@Test
	void testEqualsIstiObjekat() {
		ag.setMarkaModel("Michelin Pilot");
		ag.setPrecnik(15);
		ag.setSirina(150);
		ag.setVisina(70);
		assertTrue(ag.equals(ag));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(ag.equals(null));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(ag.equals(new String()));
	}
	

}
