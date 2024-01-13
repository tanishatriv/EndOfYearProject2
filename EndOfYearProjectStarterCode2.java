import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.Color;
public class EndOfYearProjectStarterCode2 extends JPanel implements KeyListener,Runnable
{
	private int x;
	private int y;
	private int a;
	private int b;
	private int coinCount, coinCount1, coinCount2;
	private Rectangle r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16;
	private Polygon poly;
	private int right, left, upVal1, downVal1, upVal2, downVal2, upVal3, downVal3, upVal4, downVal4, upVal5, downVal5, upVal6, downVal6, up, down;
	private boolean bounce1, bounce2, bounce3, coinCount1boo, coinCount2boo;
	private int rig, lef, up1, down1;
	private JFrame frame;
	private Thread t;
	private boolean gameOn;
	private static int deathCount;
	private Font f;
	private Color color;
	public EndOfYearProjectStarterCode2()
	{
		frame=new JFrame();
		x = 45;
		y = 230;
		a = 145;
		b = 110;
		gameOn=true;
		f=new Font("ARIAL",Font.PLAIN,40);
		frame.addKeyListener(this);
		frame.add(this);
		frame.setSize(800,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		deathCount = 0;
		coinCount1 = 0;
		coinCount2 = 0;
		coinCount = 0;
		right = 485;
		left = 210;
		rig = 0;
		up1 = 0;
		//rightVal = 485;
		//leftVal = 210;
		up = 80;
		down = 408;
		upVal1 = 80;
		downVal1 = 408;
		upVal2 = 80;
		downVal2 = 408;
		upVal3 = 80;
		downVal3 = 408;
		upVal4 = 80;
		downVal4 = 408;
		upVal5 = 80;
		downVal5 = 408;
		upVal6 = 80;
		downVal6 = 408;

		bounce1 = false;
		bounce2 = false;
		bounce3 = false;

		r1 = new Rectangle(x,y,25,25);
		r2 = new Rectangle(a,upVal1,25,25);
		r3 = new Rectangle(a+43,upVal3,20,20);
		r4 = new Rectangle(a+86,upVal5,20,20);
		r5 = new Rectangle(a+129,upVal1,20,20);
		r6 = new Rectangle(a+172,upVal3,20,20);
		r7 = new Rectangle(a+215,upVal5,20,20);
		r8 = new Rectangle(a+258,upVal1,20,20);
		r9 = new Rectangle(a+301,upVal3,20,20);
		r10 = new Rectangle(a+344,upVal5,20,20);
		r11 = new Rectangle(a+387,upVal1,20,20);
		r12 = new Rectangle(a+430,upVal3,20,20);
		r13 = new Rectangle(a+473,upVal5,20,20);

		r15 = new Rectangle(a+235,80,20,20);
		r16 = new Rectangle(a+235,390,20,20);

		r14 = new Rectangle(x,y,25,25);

		poly = new Polygon();
		poly.addPoint(20,190);
		poly.addPoint(95,190);
		poly.addPoint(95,225);
		poly.addPoint(135,225);
		poly.addPoint(135,150);
		poly.addPoint(135,70);
		poly.addPoint(645,70);
		poly.addPoint(645,225);
		poly.addPoint(645,225);
		poly.addPoint(685,225);
		poly.addPoint(685,190);
		poly.addPoint(760,190);
		poly.addPoint(760,300);
		poly.addPoint(685,300);
		poly.addPoint(685,265);
		poly.addPoint(645,265);
		poly.addPoint(645,265);
		poly.addPoint(645,420);
		poly.addPoint(135,420);
		poly.addPoint(135,265);
		poly.addPoint(95,265);
		poly.addPoint(95,300);
		poly.addPoint(20,300);

		t=new Thread(this);
		t.start();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		//all painting (AND ONLY PAINTING) happens here!
		//Don't use this method to deal with mathematics
		//The painting imps aren't fond of math.
		//fill background
		Color LAVENDER = new Color(174, 157, 242);
		g2d.setPaint(LAVENDER);
		g2d.fillRect(0,0,800,500);

		Rectangle black = new Rectangle(0, 0, 800, 60);
		g2d.setColor(Color.BLACK);
		g2d.draw(black);
		g2d.fill(black);

		//draw scoreboard
		g2d.setColor(Color.WHITE);
		g2d.setFont(f);
		g2d.drawString("LEVEL: 21",20,50);
		g2d.drawString("COINS: " + coinCount,290,50);
		g2d.drawString("FAILS: " + deathCount,600,50);

		//green rectangle
		Rectangle green1 = new Rectangle(20,190,75,110);
		Color GREEN = new Color(161, 252, 149);
		g2d.setColor(GREEN);
		g2d.draw(green1);
		g2d.fill(green1);

		Rectangle green2 = new Rectangle(685,190,75,110);
		g2d.setColor(GREEN);
		g2d.draw(green2);
		g2d.fill(green2);

		//gray background
		Color GRAY = new Color(198, 202, 207);
		Rectangle gray1 = new Rectangle(135, 70, 507, 350);
		g2d.setColor(GRAY);
		g2d.draw(gray1);
		g2d.fill(gray1);

		Rectangle gray2 = new Rectangle(95, 225, 40, 40);
		g2d.setColor(GRAY);
		g2d.draw(gray2);
		g2d.fill(gray2);

		Rectangle gray3 = new Rectangle(643, 225, 42, 40);
		g2d.setColor(GRAY);
		g2d.draw(gray3);
		g2d.fill(gray3);

		//Your character
		g2d.setColor(Color.RED);
		g2d.fill(r1);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.BLACK);
		g2d.draw(r1);

		g2d.setStroke(new BasicStroke(4));
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(poly);

		//coins
		Color YELLOW = new Color(232, 208, 28);
        if(coinCount1 == 0)
        {
			g2d.setColor(YELLOW);
			g2d.fillOval(a+235,80,20,20);
			coinCount1boo = true;

		}
   		if(coinCount2 == 0)
   		{
			g2d.setColor(YELLOW);
			g2d.fillOval(a+235,390,20,20);
			coinCount2boo = true;
		}

		//enemy
		Color PURPLE = new Color(127, 3, 252);
		g2d.setColor(PURPLE);
		g2d.fillOval(a,upVal1,20,20);

		g2d.setColor(PURPLE);
		g2d.fillOval(a+43,upVal3,20,20);

		g2d.setColor(PURPLE);
		g2d.fillOval(a+86,upVal5,20,20);

		g2d.setColor(PURPLE);
		g2d.fillOval(a+129,upVal1,20,20);

		g2d.setColor(PURPLE);
		g2d.fillOval(a+172,upVal3,20,20);

		g2d.setColor(PURPLE);
		g2d.fillOval(a+215,upVal5,20,20);

		g2d.setColor(PURPLE);
		g2d.fillOval(a+258,upVal1,20,20);

		g2d.setColor(PURPLE);
		g2d.fillOval(a+301,upVal3,20,20);

		g2d.setColor(PURPLE);
		g2d.fillOval(a+344,upVal5,20,20);

		g2d.setColor(PURPLE);
		g2d.fillOval(a+387,upVal1,20,20);

		g2d.setColor(PURPLE);
		g2d.fillOval(a+430,upVal3,20,20);

		g2d.setColor(PURPLE);
		g2d.fillOval(a+473,upVal5,20,20);


        if(green2.contains(r1))
        {
			g2d.setPaint(LAVENDER);
			g2d.fillRect(0,0,800,500);
			g2d.setColor(Color.BLACK);
			g2d.drawString("YOU WIN!", 280, 250);
		}
	}
	public void run()
	{
		while(true)
		{
			if(gameOn)
			{
				//MATH HAPPENS HERE!!!!
				//keep count of steps

				//randomly generate new top row of walls.
				//eliminate bottom row of walls

				//check to see if you've hit a wall

				//modify points

				//check to see if you've increased a level - if so, increase it

				//check for crashes

				//balls moving up and down
				if(upVal1 == upVal2 && downVal1 == downVal2)
				{
					bounce1 = true;
				}
				else if(upVal1 == downVal2 && downVal1 == upVal2)
				{
					bounce1 = false;
				}
				if(bounce1)
				{
					upVal1+=4;
					downVal1-=4;
				}
				else
				{
					upVal1-=4;
					downVal1+=4;
				}

				if(upVal3 == upVal4 && downVal3 == downVal4)
				{
					bounce2 = true;
				}
				else if(upVal3 == downVal4 && downVal3 == upVal4)
				{
					bounce2 = false;
				}
				if(bounce2)
				{
					upVal3+=2;
					downVal3-=2;
				}
				else
				{
					upVal3-=2;
					downVal3+=2;
				}

				if(upVal5 == upVal6 && downVal5 == downVal6)
				{
					bounce3 = true;
				}
				else if(upVal5 == downVal6 && downVal5 == upVal6)
				{
					bounce3 = false;
				}
				if(bounce3)
				{
					upVal5++;
					downVal5--;
				}
				else
				{
					upVal5--;
					downVal5++;
				}

				r2 = new Rectangle(a,upVal1,25,25);
				r3 = new Rectangle(a+43,upVal3,20,20);
				r4 = new Rectangle(a+86,upVal5,20,20);
				r5 = new Rectangle(a+129,upVal1,20,20);
				r6 = new Rectangle(a+172,upVal3,20,20);
				r7 = new Rectangle(a+215,upVal5,20,20);
				r8 = new Rectangle(a+258,upVal1,20,20);
				r9 = new Rectangle(a+301,upVal3,20,20);
				r10 = new Rectangle(a+344,upVal5,20,20);
				r11 = new Rectangle(a+387,upVal1,20,20);
				r12 = new Rectangle(a+430,upVal3,20,20);
				r13 = new Rectangle(a+473,upVal5,20,20);

				r15 = new Rectangle(a+235,80,20,20);
				r16 = new Rectangle(a+235,390,20,20);

				//square stays in polygon
				r14 = new Rectangle(x + rig, y + up1, 25, 25);
				if (poly.contains(r14))
				{
					x += rig;
					y += up1;
				}
				r1 = new Rectangle(x,y,25,25);


				if(r1.intersects(r2) || r1.intersects(r3) || r1.intersects(r4) || r1.intersects(r5) || r1.intersects(r6) || r1.intersects(r7) || r1.intersects(r8) || r1.intersects(r9) || r1.intersects(r10) || r1.intersects(r11) || r1.intersects(r12) || r1.intersects(r13))
				{
					System.out.println("OUCH");
					deathCount++;
					x = 45;
					y = 230;
				}

				if(r1.intersects(r15) && coinCount1boo)
				{
					coinCount1++;
					if(coinCount2 > 0)
					{
						coinCount = coinCount1 + coinCount2;
					}
				}

				if(r1.intersects(r16) && coinCount2boo)
				{
					coinCount2++;
					if(coinCount1 > 0)
					{
						coinCount = coinCount1 + coinCount2;
					}
				}

				//this is the code for delay
				try
				{
					t.sleep(5);
				}catch(InterruptedException e)
				{
				}
				repaint();
			}
		}

	}

	public void keyPressed(KeyEvent ke)
	{
		//look up keycodes online.  39 is right arrow key
		System.out.println(ke.getKeyCode());
		if(ke.getKeyCode()== 39)
			rig = 2;//x+=4;

		if(ke.getKeyCode() == 37)
			rig = -2; //x-=4;

		if(ke.getKeyCode() == 38)
			up1 = -2; //y-=4;

		if(ke.getKeyCode() == 40)
			up1 = 2; //y+=4;

	}
	public void keyReleased(KeyEvent ke)
	{
		System.out.println(ke.getKeyCode());
		if(ke.getKeyCode()== 39)
			rig = 0; //x+=4
		if(ke.getKeyCode() == 37)
			rig = 0; //x-=4;
		if(ke.getKeyCode() == 38)
			up1 = 0; //y-=4;
		if(ke.getKeyCode() == 40)
			up1 = 0; //y+=4;
	}
	public void keyTyped(KeyEvent ke)
	{
	}
	public static void main(String args[])
	{
		EndOfYearProjectStarterCode2 app=new EndOfYearProjectStarterCode2();
	}
}








