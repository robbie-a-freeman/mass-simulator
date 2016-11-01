import java.awt.Graphics;
import java.text.DecimalFormat;

import javax.swing.JPanel;


public class SimStats  extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -629558602389528667L;
	private int x, y;
	private static int radius[];
	private static long mass[];
	private static int charge[];
	private static int colorR[];
	private static int colorG[];
	private static int colorB[];
	private static int xPosition[];
	private static int yPosition[];
	private static double xVelocity[];
	private static double yVelocity[];
	
	public SimStats(int x, int y){
		radius = new int[10];
		mass = new long[10];
		charge = new int[10];
		colorR = new int[10];
		colorG = new int[10];
		colorB = new int[10];
		xPosition = new int[10];
		yPosition = new int[10];
		xVelocity = new double[10];
		yVelocity = new double[10];
		
		this.x = x - 10;
		this.y = y - 30;
	}
	
	public static void setRadius(int n, int i){
		radius[i] = n;
	}
	
	public static void setMass(long n, int i){
		mass[i] = n;
	}
	
	public static void setCharge(int n, int i){
		charge[i] = n;
	}
	
	public static void setColorR(int n, int i){
		colorR[i] = n;
	}
	
	public static void setColorG(int n, int i){
		colorG[i] = n;
	}
	
	public static void setColorB(int n, int i){
		colorB[i] = n;
	}
	
	public static void setXPosition(int n, int i){
		xPosition[i] = n;
	}
	
	public static void setYPosition(int n, int i){
		yPosition[i] = n;
	}
	
	public static void setXVelocity(double n, int i){
		xVelocity[i] = n;
	}
	
	public static void setYVelocity(double n, int i){
		yVelocity[i] = n;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int lineIncV = y / 11;
		int lineIncH = x / 11;
		DecimalFormat df = new DecimalFormat("#.0000");
		for(int i = 0; i < 10; i++){
			g.drawLine(lineIncH * (i + 1), 0, lineIncH * (i + 1), y); //Vertical
			g.drawLine(0, lineIncV * (i + 1), x, lineIncV * (i + 1)); //Horizontal
			g.drawString("mass " + (i + 1), lineIncH / 4, lineIncV * i + 7 * lineIncV / 4);
			g.drawString(radius[i] + "", 5 * lineIncH / 4, lineIncV * i + 7 * lineIncV / 4);
			g.drawString(mass[i] + "", 9 * lineIncH / 4, lineIncV * i + 7 * lineIncV / 4);
			g.drawString(charge[i] + "", 13 * lineIncH / 4, lineIncV * i + 7 * lineIncV / 4);
			g.drawString(colorR[i] + "", 17 * lineIncH / 4, lineIncV * i + 7 * lineIncV / 4);
			g.drawString(colorG[i] + "", 21 * lineIncH / 4, lineIncV * i + 7 * lineIncV / 4);
			g.drawString(colorB[i] + "", 25 * lineIncH / 4, lineIncV * i + 7 * lineIncV / 4);
			g.drawString(xPosition[i] + "", 29 * lineIncH / 4, lineIncV * i + 7 * lineIncV / 4);
			g.drawString(yPosition[i] + "", 33 * lineIncH / 4, lineIncV * i + 7 * lineIncV / 4);
			g.drawString(df.format(xVelocity[i]) + "", 37 * lineIncH / 4, lineIncV * i + 7 * lineIncV / 4);
			g.drawString(df.format(yVelocity[i]) + "", 41 * lineIncH / 4, lineIncV * i + 7 * lineIncV / 4);
			//double d = 1.234567;
			 //
			 //System.out.print(df.format(d));
		}
		g.drawString("radius (m)", 5 * lineIncH / 4, 3 * lineIncV / 4);
		g.drawString("mass (kg)", 9 * lineIncH / 4, 3 * lineIncV / 4);
		g.drawString("charge (C)", 13 * lineIncH / 4, 3 * lineIncV / 4);
		g.drawString("red (0-255)", 17 * lineIncH / 4, 3 * lineIncV / 4);
		g.drawString("green (0-255)", 21 * lineIncH / 4, 3 * lineIncV / 4);
		g.drawString("blue (0-255)", 25 * lineIncH / 4, 3 * lineIncV / 4);
		g.drawString("x position (0-900 m)", 29 * lineIncH / 4, 3 * lineIncV / 4);
		g.drawString("y position (0-600 m)", 33 * lineIncH / 4, 3 * lineIncV / 4);
		g.drawString("x velocity (m/s)", 37 * lineIncH / 4, 3 * lineIncV / 4);
		g.drawString("y velocity (m/s)", 41 * lineIncH / 4, 3 * lineIncV / 4);
	}

}
