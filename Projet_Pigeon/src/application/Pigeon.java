package application;

import java.awt.Color;
import java.util.List;
import java.util.Random;

class Pigeon implements Runnable {

    Thread animation;
	public int x = 150, y = 50, fx = 0, fy = 0;
	static int r = 20;
	private int slp = 10;
    Nourriture destN;
	boolean frayeur = false;
    mypanel p;
	Color c;
	Random rand = new Random();
    
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
            		
            	
            	//boolean res = checkNourriture(p.listNourritures);
            	
            	// On regarde si il va se faire effrayer
            	
            	float f = rand.nextFloat(1);

				if (f < p.probaFrayeur) {
					frayeur = true;
					destN = null;
					slp = 5;
					fx = rand.nextInt(500);
					fy = rand.nextInt(500);
				}
				
				if (frayeur) {
					     
					if (comparePosition(fx, fy))
						frayeur = false;
					else {
						deplacement(fx, fy);
					}
					
				} else if (checkNourriture(p.listNourritures) || destN != null) {
							slp = 10;
							deplacement(destN.getX(), destN.getY());
				}

					
				checkCollision();
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
				if (n.fraicheur > destN.fraicheur || !listNourr.contains(destN))
					destN = n;
    		}
    		return true;
    	}
    }
    
	public void checkCollision() {

			if(destN != null) {
				double dist = (double) Math.sqrt(Math.pow(destN.getX() - x, 2) + Math.pow(destN.getY() - y, 2));

				if (dist < r + destN.getSize()) {
					if (destN.getFraicheur() > 0 && !p.getNLock()) {
						p.listNourritures.remove(destN);
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
