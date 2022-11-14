package application;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


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
class mypanel extends JPanel
{

	public ArrayList<Nourriture> listNourritures;
	static List<Color> colors;
	
    Pigeon pig;
    Pigeon pig2;
    
    mypanel()
    {
		setColors();
        pig = new Pigeon(150,50, this);
        pig2 = new Pigeon(50,50, this);
        this.listNourritures = new ArrayList<>();
    }

    public void test(){
    	//pig.checkNourriture(listNourritures);
        repaint();
    }
    
    public void addNourriture(Nourriture n) {
    	this.listNourritures.add(n);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;
        Rectangle2D.Double r1=new Rectangle2D.Double(pig.x-pig.r,pig.y-pig.r,pig.r*2,pig.r*2);
        g2.draw(r1);
        g2.setPaint(Color.red);
        g2.fill(r1);

        Rectangle2D.Double r2=new Rectangle2D.Double(pig2.x-pig2.r,pig2.y-pig2.r,pig2.r*2,pig2.r*2);
        g2.draw(r2);
        g2.setPaint(Color.blue);
        g2.fill(r2);
        
        for(Nourriture n : listNourritures) {
        	Rectangle2D.Double nr =new Rectangle2D.Double(n.x-n.size,n.y-n.size,n.size*2,n.size*2);
            g2.draw(nr);
			g2.setPaint(colors.get(n.getFraicheur()));
            g2.fill(nr);
        }
        
    }

	public void setColors() {
		colors = new ArrayList<Color>();
		// color pour 0 gris foncé
		colors.add(new Color(94, 94, 94)); // color pour 0 gris foncé
		colors.add(new Color(133, 126, 100)); // 1
		colors.add(new Color(171, 158, 105)); // 2
		colors.add(new Color(210, 190, 111)); // 3
		colors.add(new Color(248, 222, 116)); // 4
		colors.add(new Color(248, 202, 117)); // 5
		colors.add(new Color(247, 182, 119)); // 6
		colors.add(new Color(219, 129, 104)); // 7
		colors.add(new Color(247, 162, 120)); // 8
		colors.add(new Color(190, 95, 88)); // 9
		colors.add(new Color(162, 62, 72)); // 10
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
		System.out.println(e.getX());
		System.out.println(e.getY());
		panel.addNourriture(new Nourriture(e.getX(),e.getY()));
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
