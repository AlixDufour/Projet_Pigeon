package application;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


class Main
{
    public static void main(String []args)
    {
        myframe m=new myframe();
        m.setTitle("Les pigeons là");
        m.setSize(500,500);
        m.setVisible(true);
        m.setLocation(300,100);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true){
        	m.update();
        }
        
    }

}
class myframe extends JFrame
{
    mypanel p;

    myframe()
    {
        p=new mypanel();
        Container c=getContentPane();
        c.add(p);
        p.addMouseListener(new TestMouseListener(p));
    }

    public void update(){
        p.test();
    }
}
class mypanel extends JPanel implements ActionListener
{

	public ArrayList<Nourriture> listNourritures;
	public ArrayList<Pigeon> listPigeons;
	public int nbPigeons = 3;
	public float probaFrayeur = 0;

	static List<Color> colors;

	Timer time = new Timer(3000, this);
    
    boolean nlock = false;
    
    mypanel()
    {
		setColors();

		Random r = new Random();
		listPigeons = new ArrayList<Pigeon>();

		for (int i = 0; i < nbPigeons; i++) {
			listPigeons.add(new Pigeon(r.nextInt(500 - 2 * Pigeon.r), r.nextInt(500 - 2 * Pigeon.r), this,
					new Color(r.nextFloat(), r.nextFloat(), r.nextFloat())));
		}

        this.listNourritures = new ArrayList<>();
        time.start();
    }

    public void test(){
    	//pig.checkNourriture(listNourritures);
        repaint();
		// Calcul de la probabilité des pigeons de se faire effrayer pour ce tour-ci
		Random r = new Random();
		probaFrayeur = r.nextFloat(0.003f);
    }
    
    public boolean getNLock() {return this.nlock;}
    
    public void addNourriture(Nourriture n) {
    	this.listNourritures.add(n);
    }

    public void paint(Graphics g)
    {

    	nlock = true;
    	
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;

		for (Pigeon p : listPigeons) {
			Rectangle2D.Double rec = new Rectangle2D.Double(p.x - Pigeon.r, p.y - Pigeon.r, Pigeon.r * 2,
					Pigeon.r * 2);
			g2.draw(rec);
			if (p.frayeur)
				g2.setPaint(Color.red);
			else
				g2.setPaint(p.getColor());
			g2.fill(rec);
		}
        
		
        for(Nourriture n : listNourritures) {
        	Rectangle2D.Double nr =new Rectangle2D.Double(n.x-n.size,n.y-n.size,n.size*2,n.size*2);
            g2.draw(nr);
			g2.setPaint(colors.get(n.getFraicheur()));
            g2.fill(nr);
        }
        nlock = false;
    }

	public void setColors() {
		colors = new ArrayList<Color>();
		// color pour 0 gris foncé
		colors.add(new Color(94, 94, 94)); // color pour 0 gris foncé
		colors.add(new Color(0, 255, 49)); // 1
		colors.add(new Color(105, 255, 0)); // 2
		colors.add(new Color(164, 255, 0)); // 3
		colors.add(new Color(211, 255, 0)); // 4
		colors.add(new Color(254, 255, 0)); // 5
		colors.add(new Color(255, 216, 0)); // 6
		colors.add(new Color(255, 173, 0)); // 7
		colors.add(new Color(255, 130, 0)); // 8
		colors.add(new Color(255, 83, 0)); // 9
		colors.add(new Color(255, 0, 0)); // 10
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
			
		
		for(Nourriture n : listNourritures) {
			n.decFraicheur();
			time.start();
		}

	}
}



class TestMouseListener implements MouseListener{

	mypanel panel;
	
	public TestMouseListener(mypanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(!panel.getNLock()) {
			panel.addNourriture(new Nourriture(e.getX(),e.getY()));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
