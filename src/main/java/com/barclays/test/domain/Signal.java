package com.barclays.test.domain;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public final class Signal implements Runnable {

	private final Direction signalName;
	private SignalColor signalColor;
	private SignalColor previousSignalColor = SignalColor.GREEN;

	private final CyclicBarrier gate;
	int i = 0;

	public Signal(Direction signalName, SignalColor signalColor, CyclicBarrier gate) {
		this.signalName = signalName;
		this.signalColor = signalColor;
		this.gate = gate;
	}

	private void operateSignal() throws InterruptedException, BrokenBarrierException {
		gate.await();
		while (true) {
			i++;
			Thread.sleep(1000);
			if (SignalColor.GREEN.equals(signalColor)) {
				if (i == 3) {
					signalColor = SignalColor.RED;
					previousSignalColor = SignalColor.GREEN;
					i = 0;
				}
				previousSignalColor = SignalColor.RED;
			}
			if (SignalColor.RED.equals(signalColor)) {
				if (i == 4) {
					signalColor = SignalColor.GREEN;
					previousSignalColor = SignalColor.RED;
					i = 0;
				}
				previousSignalColor = SignalColor.GREEN;
			}
		}
	}

	public void run() {
		try {
			operateSignal();
		} catch (BrokenBarrierException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Direction getSignalName() {
		return signalName;
	}

	public SignalColor getSignalColor() {
		return signalColor;
	}

	public SignalColor getPreviousSignalColor() {
		return previousSignalColor;
	}
}
