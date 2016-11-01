import javax.swing.JFrame;


public class Brain {
	
	private static double radius[];
	private static long mass[];
	private static double[] charge;
	private static int colorR[];
	private static int colorG[];
	private static int colorB[];
	private static double xPosition[];
	private static double yPosition[];
	private static double xVelocity[];
	private static double yVelocity[];
	private static JFrame j;
	private static InitialScreen i;
	private static World w;
	private static double timeC, lowX, highX, lowY, highY;

	public static void main(String[] args)
	{

		Brain b = new Brain();
		b.generateStart();

	}
	
	private void generateStart()
	{
		j = new JFrame();
		i = new InitialScreen(this);
		j.setVisible(true);
		j.setSize(1200,600);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.add(i);
		
		radius = new double[10];
		mass = new long[10];
		charge = new double[10];
		colorR = new int[10];
		colorG = new int[10];
		colorB = new int[10];
		xPosition = new double[10];
		yPosition = new double[10];
		xVelocity = new double[10];
		yVelocity = new double[10];
		
	}
	
	public static void setRadius(double n, int i){
		radius[i] = n;
	}
	
	public static void setMass(long n, int i){
		mass[i] = n;
	}
	
	public static void setCharge(double n, int i){
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
	
	public static void setXPosition(double n, int i){
		xPosition[i] = n;
	}
	
	public static void setYPosition(double n, int i){
		yPosition[i] = n;
	}
	
	public static void setXVelocity(double n, int i){
		xVelocity[i] = n;
	}
	
	public static void setYVelocity(double n, int i){
		yVelocity[i] = n;
	}
	
	public static void beginSim(){
		j.remove(i);
		j.repaint();
		j.revalidate();
		w = new World(1200, 600, radius, mass, charge, colorR, colorG, colorB, xPosition, yPosition, xVelocity, yVelocity, timeC, lowX, highX, lowY, highY);
		j.add(w);
		j.repaint();
		j.revalidate();
		new Thread(w).start();
	}

	public static double getTimeC() {
		return timeC;
	}

	public static void setTimeC(double timeC) {
		Brain.timeC = timeC;
	}

	public static double getLowX() {
		return lowX;
	}

	public static void setLowX(double lowX) {
		Brain.lowX = lowX;
	}

	public static double getHighX() {
		return highX;
	}

	public static void setHighX(double highX) {
		Brain.highX = highX;
	}

	public static double getLowY() {
		return lowY;
	}

	public static void setLowY(double lowY) {
		Brain.lowY = lowY;
	}

	public static double getHighY() {
		return highY;
	}

	public static void setHighY(double highY) {
		Brain.highY = highY;
	}

}
