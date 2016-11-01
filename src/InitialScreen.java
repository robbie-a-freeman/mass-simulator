import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Random;


public class InitialScreen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2991761523917318109L;
	private String s;
	private JLabel j;
	private JTextField xRange[], yRange[], radius[], mass[], charge[], colorR[], colorG[], colorB[], xPosition[], yPosition[], xVelocity[], yVelocity[], timeC;
	private int massNameC, radiusC, massC, chargeC, colorRC, colorGC, colorBC, xPositionC, yPositionC, xVelocityC, yVelocityC;
	private JButton next, demo;

	public InitialScreen(Brain b){
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		s = "Welcome to Robbie's Mass Simulator!";
		j = new JLabel(s);
		c.insets = new Insets(5,5,5,5);
		c.ipady = 3;
		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 0;
		add(j, c);

		s = "Please construct your masses below. Leave masses blank if unused.";
		j = new JLabel(s);
		c.gridwidth = 9;
		c.gridy++;
		add(j, c);
		
		xRange = new JTextField[2];
		yRange = new JTextField[2];
		
		s = "x range";
		j = new JLabel(s);
		c.gridwidth = 1;
		c.gridx = 10;
		add(j, c);
		
		xRange[0] = new JTextField("0", 20);
		c.gridx++;
		c.gridwidth = 2;
		c.ipadx = 70;
		add(xRange[0], c);
		
		xRange[1] = new JTextField("1200", 20);
		c.gridx += 2;
		c.gridwidth = 2;
		add(xRange[1], c);
		
		s = "y range";
		j = new JLabel(s);
		c.gridwidth = 1;
		c.gridx += 2;
		add(j, c);
		
		yRange[0] = new JTextField("0", 20);
		c.gridx++;
		c.gridwidth = 2;
		c.ipadx = 70;
		add(yRange[0], c);
		
		yRange[1] = new JTextField("600", 20);
		c.gridx += 2;
		c.gridwidth = 2;
		add(yRange[1], c);
		
		c.ipadx = 0;
		c.gridy++;

		radius = new JTextField[10];
		mass = new JTextField[10];
		charge = new JTextField[10];
		colorR = new JTextField[10];
		colorG = new JTextField[10];
		colorB = new JTextField[10];
		xPosition = new JTextField[10];
		yPosition = new JTextField[10];
		xVelocity = new JTextField[10];
		yVelocity = new JTextField[10];

		s = "mass Name";
		j = new JLabel(s);
		c.gridx = 0;
		massNameC = 1;
		c.gridwidth = massNameC;
		add(j, c);

		s = "radius (m)";
		j = new JLabel(s);
		c.gridx += massNameC;
		radiusC = 2;
		c.gridwidth = radiusC;
		add(j, c);

		s = "mass (kg)";
		j = new JLabel(s);
		c.gridx += radiusC;
		massC = 2;
		c.gridwidth = massC;
		add(j, c);

		s = "charge (C)";
		j = new JLabel(s);
		c.gridx += massC;
		chargeC = 2;
		c.gridwidth = chargeC;
		add(j, c);

		s = "red color (0-255)";
		j = new JLabel(s);
		c.gridx += chargeC;
		colorRC = 2;
		c.gridwidth = colorRC;
		add(j, c);

		s = "green color (0-255)";
		j = new JLabel(s);
		c.gridx += colorRC;
		colorGC = 2;
		c.gridwidth = colorGC;
		add(j, c);

		s = "blue color (0-255)";
		j = new JLabel(s);
		c.gridx += colorGC;
		colorBC = 2;
		c.gridwidth = colorBC;
		add(j, c);

		s = "x position (0-900 m)";
		j = new JLabel(s);
		c.gridx += colorBC;
		xPositionC = 2;
		c.gridwidth = xPositionC;
		add(j, c);

		s = "y position (0-600 m)";
		j = new JLabel(s);
		c.gridx += xPositionC;
		yPositionC = 2;
		c.gridwidth = yPositionC;
		add(j, c);

		s = "x velocity (m/s)";
		j = new JLabel(s);
		c.gridx += yPositionC;
		xVelocityC = 2;
		c.gridwidth = xVelocityC;
		add(j, c);

		s = "y velocity (m/s)";
		j = new JLabel(s);
		c.gridx += xVelocityC;
		yVelocityC = 2;
		c.gridwidth = yVelocityC;
		add(j, c);

		c.gridx = 0;
		c.gridy++;

		for(int i = 0; i < 10; i++){
			c.ipadx = 70;

			s = "mass " + (i + 1);
			j = new JLabel(s);
			c.gridwidth = massNameC;
			add(j, c);

			radius[i] = new JTextField(20);
			c.gridx += massNameC;
			c.gridwidth = radiusC;
			add(radius[i], c);

			mass[i] = new JTextField(20);
			c.gridx += radiusC;
			c.gridwidth = massC;
			add(mass[i], c);

			charge[i] = new JTextField(20);
			c.gridx += massC;
			c.gridwidth = chargeC;
			add(charge[i], c);

			colorR[i] = new JTextField(20);
			c.gridx += chargeC;
			c.gridwidth = colorRC;
			add(colorR[i], c);

			colorG[i] = new JTextField(20);
			c.gridx += colorRC;
			c.gridwidth = colorGC;
			add(colorG[i], c);

			colorB[i] = new JTextField(20);
			c.gridx += colorGC;
			c.gridwidth = colorBC;
			add(colorB[i], c);

			xPosition[i] = new JTextField(20);
			c.gridx += colorBC;
			c.gridwidth = xPositionC;
			add(xPosition[i], c);

			yPosition[i] = new JTextField(20);
			c.gridx += xPositionC;
			c.gridwidth = yPositionC;
			add(yPosition[i], c);

			xVelocity[i] = new JTextField(20);
			c.gridx += yPositionC;
			c.gridwidth = xVelocityC;
			add(xVelocity[i], c);

			yVelocity[i] = new JTextField(20);
			c.gridx += xVelocityC;
			c.gridwidth = yVelocityC;
			add(yVelocity[i], c);

			c.gridx = 0;
			c.gridy++;
		}

		s = "next";
		next = new JButton(s);
		c.gridx = 18;
		c.gridwidth = 3;
		add(next, c);

		s = "demo";
		demo = new JButton(s);
		c.gridx = 18;
		c.gridy++;
		add(demo, c);

		s = "time constant: ";
		j = new JLabel(s);
		c.gridx = 0;
		c.gridy--;
		c.gridwidth = 2;
		add(j, c);

		timeC = new JTextField(".005", 20);
		c.gridx = 2;
		c.gridwidth = 2;
		add(timeC, c);

		Handler h = new Handler();
		next.addActionListener(h);
		demo.addActionListener(h);
	}

	private void clearScreen(){
		Brain.beginSim();
	}

	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("next")){
				for(int i = 0; i < 10; i++){
					if(radius[i].getText().equals("")){
						Brain.setRadius(0, i);
					}
					else{
						Brain.setRadius(Double.parseDouble(radius[i].getText()), i);
					}
					if(mass[i].getText().equals("")){
						Brain.setMass(0, i);
					}
					else{
						Brain.setMass(Long.parseLong(mass[i].getText()), i);
					}
					if(charge[i].getText().equals("")){
						Brain.setCharge(0, i);
					}
					else{
						Brain.setCharge(Double.parseDouble(charge[i].getText()), i);
					}
					if(colorR[i].getText().equals("")){
						Brain.setColorR(0, i);
					}
					else{
						Brain.setColorR(Integer.parseInt(colorR[i].getText()), i);
					}
					if(colorG[i].getText().equals("")){
						Brain.setColorG(0, i);
					}
					else{
						Brain.setColorG(Integer.parseInt(colorG[i].getText()), i);
					}
					if(colorB[i].getText().equals("")){
						Brain.setColorB(0, i);
					}
					else{
						Brain.setColorB(Integer.parseInt(colorB[i].getText()), i);
					}
					if(xPosition[i].getText().equals("")){
						Brain.setXPosition(0, i);
					}
					else{
						Brain.setXPosition(Double.parseDouble(xPosition[i].getText()), i);
					}
					if(yPosition[i].getText().equals("")){
						Brain.setYPosition(0, i);
					}
					else{
						Brain.setYPosition(Double.parseDouble(yPosition[i].getText()), i);
					}
					if(xVelocity[i].getText().equals("")){
						Brain.setXVelocity(0, i);
					}
					else{
						Brain.setXVelocity(Double.parseDouble(xVelocity[i].getText()), i);
					}
					if(yVelocity[i].getText().equals("")){
						Brain.setYVelocity(0, i);
					}
					else{
						Brain.setYVelocity(Double.parseDouble(yVelocity[i].getText()), i);
					}
				}
				Brain.setTimeC(Double.parseDouble(timeC.getText()));
				
				Brain.setLowX(Double.parseDouble(xRange[0].getText()));
				Brain.setHighX(Double.parseDouble(xRange[1].getText()));
				Brain.setLowY(Double.parseDouble(yRange[1].getText())); //reversed for the y coordinate
				Brain.setHighY(Double.parseDouble(yRange[0].getText()));
				clearScreen();
			}
			else if(e.getActionCommand().equals("demo")){
				Random r = new Random();
				for(int i = 0; i < 10; i++){
					radius[i].setText("10");
					mass[i].setText("100000000");
					charge[i].setText(r.nextInt(10) - 5 + "");
					colorR[i].setText(r.nextInt(255) + "");
					colorG[i].setText(r.nextInt(255) + "");
					colorB[i].setText(r.nextInt(255) + "");
					xPosition[i].setText(r.nextInt(1200) + "");
					yPosition[i].setText(r.nextInt(600) + "");
					xVelocity[i].setText(r.nextInt(2) - 1 + "");
					yVelocity[i].setText(r.nextInt(2) - 1 + "");
				}
			}


		}



	}

}