package application;

public class Nourriture {
	
	int x,y,r;
	int fraicheur;
	
	public Nourriture(int x, int y){
		this.x = x;
		this.y = y;
		this.r = 5;
		fraicheur = 10;
	}
	
	public int getX() {return this.x;}
	public int getY() {return this.y;}
	public int getFraicheur() {return this.fraicheur;}
}
