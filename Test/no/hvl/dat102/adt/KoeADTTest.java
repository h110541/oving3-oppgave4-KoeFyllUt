package no.hvl.dat102.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
