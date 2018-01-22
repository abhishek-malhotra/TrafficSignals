package com.barclays.test.domain;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FourWayIntersection implements Intersection {

	//Barrier to ensure all the signals start at same time
	final CyclicBarrier signalGate = new CyclicBarrier(5);
	ExecutorService executorService = Executors.newFixedThreadPool(8);

	Signal northSignal = new Signal(Direction.NORTH, SignalColor.GREEN, signalGate);
	Signal southSignal = new Signal(Direction.SOUTH, SignalColor.GREEN, signalGate);
	Signal eastSignal = new Signal(Direction.EAST, SignalColor.RED, signalGate);
	Signal westSignal = new Signal(Direction.WEST, SignalColor.RED, signalGate);
	private Map<Direction, Road> roadsMap;

	public FourWayIntersection(Map<Direction, Road> roadsMap) {
		if (roadsMap.size() != 4) {
			//TODO: throw Exception and exit form the program
		}
		this.roadsMap = roadsMap;
	}

	@Override
	public void startIntersectionSignals() throws InterruptedException, BrokenBarrierException {
		executorService.execute(northSignal);
		executorService.execute(southSignal);
		executorService.execute(eastSignal);
		executorService.execute(westSignal);
		// all signals initialized...
		signalGate.await();
	}

	@Override
	public void moveVehiclesAtIntersection() throws InterruptedException {
		if (northSignal.getSignalColor().equals(SignalColor.GREEN)) {
			if (northSignal.getPreviousSignalColor().equals(SignalColor.RED)) {
				Thread.sleep(1000);
			}
			roadsMap.get(Direction.NORTH).moveTraffic();
		}
		if (southSignal.getSignalColor().equals(SignalColor.GREEN)) {
			if (southSignal.getPreviousSignalColor().equals(SignalColor.RED)) {
				Thread.sleep(1000);
			}
			roadsMap.get(Direction.SOUTH).moveTraffic();
		}
		if (eastSignal.getSignalColor().equals(SignalColor.GREEN)) {
			if (eastSignal.getPreviousSignalColor().equals(SignalColor.RED)) {
				Thread.sleep(1000);
			}
			roadsMap.get(Direction.EAST).moveTraffic();
		}
		if (westSignal.getSignalColor().equals(SignalColor.GREEN)) {
			if (westSignal.getPreviousSignalColor().equals(SignalColor.RED)) {
				Thread.sleep(1000);
			}
			roadsMap.get(Direction.WEST).moveTraffic();
		}
		Thread.sleep(1000);
	}

}
