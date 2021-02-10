package no.hvl.dat102.klient;

import no.dat102.tabell.TabellKoe;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.kjedet.KjedetKoe;
import no.hvl.dat102.sirkulaer.SirkulaerKoe;

public class KlientKoe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KoeADT<Character> tegnKoe;

		tegnKoe = new TabellKoe<>();
		brukKoe(tegnKoe);

		tegnKoe = new KjedetKoe<>();
		brukKoe(tegnKoe);

		tegnKoe = new SirkulaerKoe<>();
		brukKoe(tegnKoe);
	}

	private static void brukKoe(KoeADT<Character> tegnKoe) {
		String streng = " Denne koen er en FIFO datastruktur.";
		int lengde = streng.length();
		for (int i = 0; i < lengde; i++) {
			tegnKoe.innKoe(streng.charAt(i));
		}

		try {
			while (!tegnKoe.erTom()) {
				char tegn = tegnKoe.utKoe();
				System.out.print(tegn);
			}
			System.out.println();
		} catch (EmptyCollectionException e) {
			System.out.print(e.getMessage());

		}

	}

}
