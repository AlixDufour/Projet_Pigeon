package application;
import java.awt.*;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.ArrayList;


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
	
    Pigeon pig;
    Pigeon pig2;
    
    mypanel()
    {
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
        	Rectangle2D.Double nr =new Rectangle2D.Double(n.x-n.r,n.y-n.r,n.r*2,n.r*2);
            g2.draw(nr);
            g2.setPaint(Color.green);
            g2.fill(nr);
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
