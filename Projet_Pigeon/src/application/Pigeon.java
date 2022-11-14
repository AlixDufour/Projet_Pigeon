package application;

import java.awt.Color;
import java.util.List;
import java.util.Random;

class Pigeon implements Runnable {

    Thread animation;
	public int x = 150, y = 50, fx = 0, fy = 0;
	static int r = 20, slp = 10;
    Nourriture destN;
	boolean frayeur;
    mypanel p;
	Color c;
    
	public Pigeon(int x, int y, mypanel p, Color col) {
        this.x = x;
        this.y = y;
        this.p = p;
		this.c = col;
		frayeur = false;
        
        animation=new Thread(this,"Pigeon");
        animation.start();
    }

    @Override
    public void run() {
        try
        {
            while(true)
            {
            	
				if (frayeur) {
					if (comparePosition(fx, fy))
						frayeur = false;
					else
						deplacement(fx, fy);
				} else {
					if (checkNourriture(p.listNourritures)) {
						// On regarde si il va se faire effrayer
						Random r = new Random();
						if (r.nextFloat(p.probaFrayeur) < 0.0015) {
							frayeur = true;
							destN = null;
							fx = r.nextInt(500);
							fy = r.nextInt(500);
						}

						else if (destN != null)
							deplacement(destN.getX(), destN.getY());
					}

					// checkCollision();
				}

				Thread.sleep(slp);
            }
        }
        catch(Exception e)
        {
        }
    }
    
    public boolean checkNourriture(List<Nourriture> listNourr) {
    	if(listNourr.size() == 0) {
    		destN = null;
    		return false;
		} else if (destN == null) {
    		destN = listNourr.get(0);
    		return true;
    	}
    	else {
    		for(Nourriture n : listNourr) {
				if (n.fraicheur > destN.fraicheur)
					destN = n;
    		}
    		return true;
    	}
    }
    
	public void checkCollision() {
		for (Nourriture n : p.listNourritures) {
			float dist = (float) Math.sqrt(((n.getX() - x) * 2) + ((n.getY() - y) * 2));
			if (dist < r + n.getSize()) {
				if (n.getFraicheur() > 0) {
					p.listNourritures.remove(n);
				}
			}
		}
	}

	public boolean comparePosition(int destX, int destY) {
		if (x == destX) {
			if (y == destY)
				return true;
		}
		return false;
	}

	public void deplacement(int destX, int destY) {
		if (x > destX)
			x--;
		else if (x < destX)
			x++;

		if (y < destY)
			y++;
		else if (y > destY)
			y--;
	}

	public Color getColor() {
		return c;
	}
}
