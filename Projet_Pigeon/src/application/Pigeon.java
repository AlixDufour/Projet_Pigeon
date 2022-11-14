package application;

class Pigeon implements Runnable {

    Thread animation;
    public int x=150,y=50,dx=0,dy=0,r=20,slp=50;

    public Pigeon(int x, int y){
        this.x = x;
        this.y = y;
        animation=new Thread(this,"Pigeon");
        animation.start();
    }

    @Override
    public void run() {
        try
        {
            while(true)
            {
                x+=Math.random() * 0;
                y+=Math.random() * 0;

                animation.sleep(slp);
            }
        }
        catch(Exception e)
        {
        }
    }
}
