package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

import java.util.Timer;
import java.util.TimerTask;

public class TrainControllerImpl implements TrainController {

	private int step = 0;

	public void setReferenceSpeed(int referenceSpeed) {
		this.referenceSpeed = referenceSpeed;
	}

	private int referenceSpeed = 0;
	private int speedLimit = 0;
	public boolean isTrainAhead = false;
	public int trainAheadSpeed = 0;

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}

		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();

		if (isTrainAhead) {
			this.speedLimit = trainAheadSpeed;
		}
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;
		Thread f = new Thread(() -> {
			try {
				this.referenceSpeed += 5;
 				Thread.sleep(1000);
			} catch (InterruptExeption e) {
			}
		});
		f.start();
	}

}
