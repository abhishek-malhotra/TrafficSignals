package com.barclays.test.domain;

import java.util.LinkedList;
import java.util.Queue;

public class Road implements Runnable{

	private Queue<Vehicle> vehicleTraffic = new LinkedList<>();
	private volatile boolean moveTraffic = false;

	private void startTraffic() throws InterruptedException {
		moveTraffic = Boolean.TRUE;
		while (moveTraffic) {
			Thread.sleep(1000);
			vehicleTraffic.add(new Vehicle());
		}
	}

	public void moveTraffic() {
		vehicleTraffic.poll();
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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
