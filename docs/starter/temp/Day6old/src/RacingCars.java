import acm.program.*;
import acm.graphics.*;
import acm.util.*;

import java.awt.Color;
import java.awt.event.*;

public class RacingCars extends GraphicsProgram {
	private final int CAR_WIDTH = 75;
	private final int MAX_VELOCITY = 5;
	private final int PAUSE_TIME = 30;
	private final int X_OFFSET = 50;
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run(){
		/* Creation and placement of the cars */
		int numCars = 10;
		double carHeight = getHeight()/(2*numCars);
		double yOffset = carHeight/2.0;
		GRect[] cars = new GRect[numCars];
		for(int i = 0; i < numCars; i++){
			cars[i] = new GRect(CAR_WIDTH, carHeight);
			cars[i].setColor(rgen.nextColor());
			cars[i].setFilled(true);
			double carYOffset = yOffset + 2*i*carHeight;
			add(cars[i], X_OFFSET, carYOffset);
		}
		pause(1000);
		
		/* Animation */
		boolean finished=false;
		while(!finished) {
			// move each car one by one
			for(int i = 0; i < cars.length; i++) {
				cars[i].move(rgen.nextInt(MAX_VELOCITY), 0);
				if(cars[i].getX() + CAR_WIDTH >= getWidth()) {
					// let everyone move to the next animation frame.
					finished = true;
				}
			}
			pause(PAUSE_TIME);
		}
	}
}