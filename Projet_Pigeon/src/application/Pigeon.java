package application;

import java.util.List;

class Pigeon implements Runnable {

    Thread animation;
    public int x=150,y=50,dx=1,dy=1,r=20,slp=10;
    Nourriture destN;
    mypanel p;
    
    
    public Pigeon(int x, int y, mypanel p){
        this.x = x;
        this.y = y;
        this.p = p;
        
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
            	
            	if(res == true) {
            		
					if (x > destN.getX())
						x -= dx;
					else if (x < destN.getX())
						x += dx;
	            	
					if (y < destN.getY())
						y += dy;
					else if (y > destN.getY())
						y -= dy;

            	}
            	
            	animation.sleep(slp);
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
}
