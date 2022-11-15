package application;

import java.awt.Color;
import java.util.List;

class Pigeon implements Runnable {

    Thread animation;
	public int x = 150, y = 50, dx = 1, dy = 1;
	static int r = 20, slp = 10;
    Nourriture destN;
    mypanel p;
	Color c;
    
    
	public Pigeon(int x, int y, mypanel p, Color col) {
        this.x = x;
        this.y = y;
        this.p = p;
		this.c = col;
        
        animation=new Thread(this,"Pigeon");
        animation.start();
    }

    @Override
    public void run() {
        try
        {
            while(true)
            {
            	
            	
            	boolean res = checkNourriture(p.listNourritures);
            	
            	if(destN != null) {
            		
					if (x > destN.getX())
						x -= dx;
					else if (x < destN.getX())
						x += dx;
	            	
					if (y < destN.getY())
						y += dy;
					else if (y > destN.getY())
						y -= dy;

            	}
            	
				
				Thread.sleep(slp);
				checkCollision();
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

			if(destN != null) {
				double dist = (double) Math.sqrt(Math.pow(destN.getX() - x, 2) + Math.pow(destN.getY() - y, 2));

				if (dist < r + destN.getSize()) {
					if (destN.getFraicheur() > 0) {
						p.listNourritures.remove(destN);
					}
			}
			
		}

	}

	public Color getColor() {
		return c;
	}
}
