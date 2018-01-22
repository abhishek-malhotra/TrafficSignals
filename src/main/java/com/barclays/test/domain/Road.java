package com.barclays.test.domain;

import java.util.LinkedList;
import java.util.Queue;

public class Road implements Runnable {

	private Signal signal;

	private Queue<Vehicle> vehicleTraffic = new LinkedList<>();
	private volatile boolean moveTraffic = false;

	private void startTraffic() throws InterruptedException {
		moveTraffic = Boolean.TRUE;
		while (moveTraffic) {
			Thread.sleep(1000);
			vehicleTraffic.add(new Vehicle());
		}
	}

	public Integer getVehicleCount() {
		return vehicleTraffic.size();
	}

	public void stopTraffic() {
		moveTraffic = Boolean.FALSE;
	}

	@Override
	public void run() {
		try {
			this.startTraffic();
			this.moveVehiclesAtIntersection();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void moveVehiclesAtIntersection() throws InterruptedException {
		if (signal.getSignalColor().equals(SignalColor.GREEN)) {
			if (signal.getPreviousSignalColor().equals(SignalColor.RED)) {
				Thread.sleep(1000);
			}
			vehicleTraffic.poll();
		}
		Thread.sleep(1000);
	}

	public void setSignal(Signal signal) {
		this.signal = signal;
	}

}
