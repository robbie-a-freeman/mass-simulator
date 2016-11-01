import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class World extends JPanel implements Runnable {

	public boolean isBlack = false;
	public Mass[] massList;
	private double G = Math.pow(6.67, -11);
	private double k = Math.pow(8.99, 9);
	private double seconds, timeC;
	private JFrame j;
	private SimStats stats;
	private int miniFrameX, miniFrameY, minutes, hours, days, years, frameX, frameY, eleventhX, eleventhY;
	private double metersConversionX, metersConversionY;

	/**TODO file io
	 * 
	 */
	private static final long serialVersionUID = 3885923810877945277L;

	public World(int frameX, int frameY, double[] radius, long[] mass, double[] charge, int[] colorR, int[] colorG, int[] colorB, double[] xPosition, double[] yPosition, double[] xVelocity, double[] yVelocity, double timeC, double xLow, double xHigh, double yLow, double yHigh)
	{
		this.frameX = frameX;
		this.frameY = frameY;
		this.timeC = timeC;

		metersConversionX = (xHigh - xLow) / frameX;
		metersConversionY = -(yHigh - yLow) / frameY;
		System.out.println(metersConversionX);
		System.out.println(metersConversionY);
		eleventhX = frameX / 11;
		eleventhY = frameY / 11;

		j = new JFrame("TEST");
		j.setVisible(true);
		miniFrameX = 1100;
		miniFrameY = 200;
		j.setSize(miniFrameX, miniFrameY);
		j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		massList = new Mass[10];

		for(int i = 0; i < 10; i++){
			massList[i] = new Mass(radius[i], mass[i], charge[i], new Color(colorR[i], colorG[i], colorB[i]), xPosition[i], yPosition[i], xVelocity[i], yVelocity[i]);
		}

		stats = new SimStats(miniFrameX, miniFrameY);
		j.add(stats);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i = 0; i < massList.length; i++){
			if(massList[i] != null){
				g.setColor(massList[i].getColor());
				g.fillOval((int) ((massList[i].getPosX() - massList[i].getRadius()) / metersConversionX), (int) ((massList[i].getPosY() - massList[i].getRadius()) / metersConversionY), (int) (2 * massList[i].getRadius() / metersConversionX), (int) (2 * massList[i].getRadius() / metersConversionY));
			}
		}
		g.setColor(Color.BLACK);

		for(int i = 0; i < 11; i++){
			g.drawLine(i * eleventhX, 0, i * eleventhX, frameY); //Vertical
			g.drawString(i * eleventhX * metersConversionX + " m", i * eleventhX, 10);
			g.drawLine(0, i * eleventhY, frameX, i * eleventhY); //Horizontal
			g.drawString((i * eleventhY) * metersConversionY + " m", 10, i * eleventhY);
		}

		g.drawString(seconds + " seconds", 750, 50);
		g.drawString(minutes + " minutes", 750, 60);
		g.drawString(hours + " hours", 750, 70);
		g.drawString(days + " days", 750, 80);
		g.drawString(years + " years", 750, 90);

		for(int i = 0; i < 10; i++){
			if(massList[i] != null){
				g.drawString("" + (i + 1), (int) ((massList[i].getPosX()) / metersConversionX), (int) ((massList[i].getPosY()) / metersConversionY)); 
			}
		}

		for(int i = 0; i < 10; i++){
			if(massList[i] == null){
				SimStats.setRadius(0, i);
			}
			else{
				SimStats.setRadius((int) massList[i].getRadius(), i);
			}
			if(massList[i] == null){
				SimStats.setMass(0, i);
			}
			else{
				SimStats.setMass( massList[i].getMass(), i);
			}
			if(massList[i] == null){
				SimStats.setCharge(0, i);
			}
			else{
				SimStats.setCharge((int) massList[i].getCharge(), i);
			}
			if(massList[i] == null){
				SimStats.setColorR(0, i);
			}
			else{
				SimStats.setColorR(massList[i].getColor().getRed(), i);
			}
			if(massList[i] == null){
				SimStats.setColorG(0, i);
			}
			else{
				SimStats.setColorG(massList[i].getColor().getGreen(), i);
			}
			if(massList[i] == null){
				SimStats.setColorB(0, i);
			}
			else{
				SimStats.setColorB(massList[i].getColor().getBlue(), i);
			}
			if(massList[i] == null){
				SimStats.setXPosition(0, i);
			}
			else{
				SimStats.setXPosition((int) massList[i].getPosX(), i);
			}
			if(massList[i] == null){
				SimStats.setYPosition(0, i);
			}
			else{
				SimStats.setYPosition((int) massList[i].getPosY(), i);
			}
			if(massList[i] == null){
				SimStats.setXVelocity(0, i);
			}
			else{
				SimStats.setXVelocity(massList[i].getVelocityX(), i);
			}
			if(massList[i] == null){
				SimStats.setYVelocity(0, i);
			}
			else{
				SimStats.setYVelocity(massList[i].getVelocityY(), i);

			}
		}
		stats.repaint();
	}

	public void run()
	{
		while(true){
			for(int i = 0; i < 10; i++){
				if(massList[i] == null){

				}
				else if(massList[i].getMass() == 0){
					massList[i] = null;
				}
			}
			repaint();
			applyForces(massList);
			collisionDetection();
		}
	}

	private void collisionDetection() {

		for(int i = 0; i < massList.length; i++){
			for(int x = 0; x < massList.length; x++){
				if(massList[i] != null && massList[x] != null && i != x && Math.sqrt(Math.pow(massList[i].getPosX()
						- massList[x].getPosX(), 2) + Math.pow(massList[i].getPosY() - massList[x].getPosY(), 2))
						<= massList[i].getRadius() + massList[x].getRadius()){
					System.out.println("Collision");
					massList[i] = new Mass(Math.sqrt(Math.pow(massList[i].getRadius(), 2) + Math.pow(massList[x].getRadius(), 2)),
							massList[i].getMass() + massList[x].getMass(),
							massList[i].getCharge() + massList[x].getCharge(),
							// RGB, (mi * ci + mx * cx) / (mi + mx) <- weighted average of the colors' RGB numbers
							new Color((int) ((massList[i].getMass() * massList[i].getColor().getRed() + massList[x].getMass() * massList[x].getColor().getRed()) / (massList[i].getMass() + massList[x].getMass())),
									(int) ((massList[i].getMass() * massList[i].getColor().getGreen() + massList[x].getMass() * massList[x].getColor().getGreen()) / (massList[i].getMass() + massList[x].getMass())),
									(int) ((massList[i].getMass() * massList[i].getColor().getBlue() + massList[x].getMass() * massList[x].getColor().getBlue()) / (massList[i].getMass() + massList[x].getMass()))),
									massList[i].getPosX() / 2 + massList[x].getPosX() / 2,
									massList[i].getPosY() / 2 + massList[x].getPosY() / 2,
									(massList[i].getMass() * massList[i].getVelocityX() + massList[x].getMass() * massList[x].getVelocityX()) / (massList[i].getMass() + massList[x].getMass()),
									(massList[i].getMass() * massList[i].getVelocityY() + massList[x].getMass() * massList[x].getVelocityY()) / (massList[i].getMass() + massList[x].getMass()));
					System.out.println(massList[i].getVelocityX());
					massList[x] = null;
				}
			}
		}

	}

	private void applyForces(Mass ...masses) {
		Force[] forceList = new Force[10];
		for(int i = 0; i < masses.length; i++){
			Force f = new Force(0, 0, 0);
			for(int x = 0; x < masses.length; x++){
				if(massList[i] != null && massList[x] != null && x != i){
					Force tempGravityF = new Force(getGravitationalMagnitude(masses[i], masses[x]), masses[i].getPosX() - masses[x].getPosX(), masses[i].getPosY() - masses[x].getPosY());
					boolean isSameSign = true;
					if(masses[i].getCharge() * masses[x].getCharge() < 0){
						isSameSign = false;
					}
					Force tempElectricF = new Force(isSameSign, getElectricalMagnitude(masses[i], masses[x]), masses[i].getPosX() - masses[x].getPosX(), masses[i].getPosY() - masses[x].getPosY());
					double netForceX = f.getMagnitude() * Math.cos(f.getDirection()) + tempGravityF.getMagnitude() * Math.cos(tempGravityF.getDirection()) + tempElectricF.getMagnitude() * Math.cos(tempElectricF.getDirection());
					double netForceY = f.getMagnitude() * Math.sin(f.getDirection()) + tempGravityF.getMagnitude() * Math.sin(tempGravityF.getDirection()) + tempElectricF.getMagnitude() * Math.sin(tempElectricF.getDirection());
					double newDirection = Math.atan2(netForceY, netForceX);
					f.setDirection(newDirection);
					f.setMagnitude(Math.sqrt(Math.pow(netForceX, 2) + Math.pow(netForceY, 2)));
					forceList[i] = f;
				}
			}
		}
		for(int i = 0; i < masses.length; i++){
			if(masses[i] != null && forceList[i] != null){
				moveMasses(masses[i], forceList[i]);				
			}
		}
	}

	private void moveMasses(Mass mass, Force force) {
		double changeInTime = timeC;
		double accelerationX = force.getMagnitude() / mass.getMass() * Math.cos(force.getDirection());
		double accelerationY = force.getMagnitude() / mass.getMass() * Math.sin(force.getDirection());
		double initialVelocityX = mass.getVelocityX() + accelerationX;
		double initialVelocityY = mass.getVelocityY() + accelerationY;
		//d = V0t + 1/2 a t^2
		double distanceX = initialVelocityX * changeInTime + .5 * accelerationX * Math.pow(changeInTime, 2);
		double distanceY = initialVelocityY * changeInTime + .5 * accelerationY * Math.pow(changeInTime, 2);
		mass.setPosX(mass.getPosX() + distanceX);
		mass.setPosY(mass.getPosY() - distanceY);
		mass.setVelocityX(initialVelocityX);
		mass.setVelocityY(initialVelocityY);
		seconds += changeInTime;
		if(seconds >= 60){
			seconds -= 60;
			minutes += 1;
			if(minutes >= 60){
				minutes -= 60;
				hours += 1;
				if(hours >= 24){
					hours -= 24;
					days += 1;
					if(days >= 365){
						days -= 365;
						years += 1;
					}
				}
			}
		}
	}

	private double getGravitationalMagnitude(Mass mass1, Mass mass2) {
		double forceMagnitude;

		double m1 = mass1.getMass();
		double m2 = mass2.getMass();
		double distance = Math.sqrt(Math.pow(mass1.getPosX() - mass2.getPosX(), 2) + Math.pow(mass1.getPosY() - mass2.getPosY(), 2));

		forceMagnitude = G * m1 * m2 / Math.pow(distance, 2);

		return forceMagnitude;
	}

	private double getElectricalMagnitude(Mass mass1, Mass mass2) {
		double forceMagnitude;

		double q1 = mass1.getCharge();
		double q2 = mass2.getCharge();
		double distance = Math.sqrt(Math.pow(mass1.getPosX() - mass2.getPosX(), 2) + Math.pow(mass1.getPosY() - mass2.getPosY(), 2));

		forceMagnitude = k * q1 * q2 / Math.pow(distance, 2);

		return forceMagnitude;
	}

}
