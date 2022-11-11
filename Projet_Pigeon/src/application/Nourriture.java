package application;

import java.util.Random;

public class Nourriture {

	private int fraicheur;

	public Nourriture() {
		Random r = new Random();
		fraicheur = r.nextInt(10);
	}

	public boolean isFraiche() {
		return fraicheur > 0;
	}

	public void decFraicheur() {
		fraicheur--;
		return;
	}

	// public

}
