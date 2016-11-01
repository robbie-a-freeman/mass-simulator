
public class Force {

	private double magnitude, direction, changeInX, changeInY;
	private boolean chargeIsSameSign = false;
	
	public Force(double magnitude, double changeInX, double changeInY)
	{
		this.magnitude = magnitude;
		this.changeInX = changeInX;
		this.changeInY = -changeInY;
		calculateDirection();
	}
	
	public Force(boolean chargeIsSameSign, double magnitude, double changeInX, double changeInY)
	{
		this.chargeIsSameSign = chargeIsSameSign;
		this.magnitude = magnitude;
		this.changeInX = changeInX;
		this.changeInY = -changeInY;
		calculateDirection();
	}

	public double getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}

	private void calculateDirection(){
		direction = Math.atan2(changeInY, changeInX);
		if(direction > 0 && !chargeIsSameSign){
			direction -= Math.PI;
		}
		else {
			direction += Math.PI;
		}
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}
	
}
