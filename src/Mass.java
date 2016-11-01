import java.awt.Color;


public class Mass {

	private double posX, posY, velocityX, velocityY, radius, charge;
	private long mass;
	private Color color;
	
	public Mass(double radius, long mass, double charge, Color color, double posX, double posY, double initialVelocityX, double initialVelocityY)
	{
		this.radius = radius;
		this.mass = mass;
		this.charge = charge;
		this.setColor(color);
		this.posX = posX;
		this.posY = posY;
		velocityX = initialVelocityX;
		velocityY = initialVelocityY;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	public long getMass() {
		return mass;
	}

	public void setMass(long mass) {
		this.mass = mass;
	}

	public Color getColor()
	{
		return color;
	}

	public void setColor(Color color) 
	{
		this.color = color;
	}
	
	public double getPosX() 
	{
		return posX;
	}

	public void setPosX(double posX) 
	{
		this.posX = posX;
	}
	
	public double getPosY() 
	{
		return posY;
	}

	public void setPosY(double posY) 
	{
		this.posY = posY;
	}
	
}
