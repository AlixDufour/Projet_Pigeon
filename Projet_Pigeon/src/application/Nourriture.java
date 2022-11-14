package application;

import java.util.Random;

public class Nourriture {
	
	int x, y, size;
	int fraicheur;
	
	public Nourriture(int x, int y){
		this.x = x;
		this.y = y;
		this.size = 5;
		Random r = new Random();
		fraicheur = r.nextInt(10);
	}
	
	public int getX() {return this.x;}

	public int getY() {return this.y;}

	public int getFraicheur() {return this.fraicheur;}

	public boolean isFraiche() {
		return fraicheur > 0;
	}

	public void decFraicheur() {
		fraicheur--;
		return;
	}

}
