package no.hvl.dat102.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exception.EmptyCollectionException;

public abstract class KoeADTTest {

	private KoeADT<Integer> koe;

	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	@BeforeEach
	public void setup() {
		koe = reset();
	}

	@Test
	public void testErTom() {
		// Ny kø, ingen elementer
		assertTrue(koe.erTom());

		// kaller innKoe(), 1 element i køen
		koe.innKoe(e0);
		assertFalse(koe.erTom());

		// kaller innKoe(), 2 elementer i køen
		koe.innKoe(e1);
		assertFalse(koe.erTom());

		// kaller utKoe(), 1 element i køen
		koe.utKoe();
		assertFalse(koe.erTom());

		// kaller utKoe(), ingen elementer i køen
		koe.utKoe();
		assertTrue(koe.erTom());
	}

	@Test
	public void testInnKoeOgUtKoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);

		assertEquals(e0, koe.utKoe());
		assertEquals(e1, koe.utKoe());
		assertEquals(e2, koe.utKoe());
		assertEquals(e3, koe.utKoe());
		assertEquals(e4, koe.utKoe());
	}

	@Test
	public void testInnKoeOgUtKoe2() {
		koe.innKoe(e1);
		koe.innKoe(e4);
		koe.innKoe(e0);
		koe.innKoe(e3);
		koe.innKoe(e2);

		assertEquals(e1, koe.utKoe());
		assertEquals(e4, koe.utKoe());
		assertEquals(e0, koe.utKoe());
		assertEquals(e3, koe.utKoe());
		assertEquals(e2, koe.utKoe());
	}

	@Test
	public void testInnKoeOgUtKoe3() {
		koe.innKoe(e1);
		koe.innKoe(e1);
		koe.innKoe(e1);

		assertEquals(e1, koe.utKoe());
		assertEquals(e1, koe.utKoe());
		assertEquals(e1, koe.utKoe());
	}

	@Test
	public void testInnKoeOgUtKoe4() {
		koe.innKoe(e4);
		koe.innKoe(e1);
		koe.innKoe(e2);

		assertEquals(e4, koe.utKoe());
		assertEquals(e1, koe.utKoe());

		koe.innKoe(e3);
		koe.innKoe(e0);

		assertEquals(e2, koe.utKoe());
		assertEquals(e3, koe.utKoe());
		assertEquals(e0, koe.utKoe());
	}

	@Test
	public void testFoerste() {
		koe.innKoe(e2);
		assertEquals(e2, koe.foerste());

		koe.innKoe(e1);
		koe.innKoe(e1);
		koe.innKoe(e0);

		assertEquals(e2, koe.foerste());

		koe.utKoe();
		assertEquals(e1, koe.foerste());

		koe.utKoe();
		assertEquals(e1, koe.foerste());

		koe.utKoe();
		assertEquals(e0, koe.foerste());
	}

	@Test
	public void testAntall() {
		assertEquals(0, koe.antall());

		koe.innKoe(e0);
		assertEquals(1, koe.antall());

		for(int i = 1; i <= 20; i++) {
			koe.innKoe(e3);
		}
		assertEquals(21, koe.antall());

		koe.utKoe();
		koe.utKoe();
		assertEquals(19, koe.antall());

		koe.innKoe(e4);
		assertEquals(20, koe.antall());
	}

	@Test
	public void testUnntakBlirKastet() {
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.foerste();
		});

		koe.innKoe(e4);
		koe.innKoe(e1);
		koe.utKoe();
		koe.utKoe();

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.foerste();
		});
	}

}
