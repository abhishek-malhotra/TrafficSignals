package com.barclays.test.runner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.barclays.test.domain.Direction;
import com.barclays.test.domain.FourWayIntersection;
import com.barclays.test.domain.Intersection;
import com.barclays.test.domain.Road;

public class SignalOperations {

	public static void main(String[] ty) throws Exception {

		Road northSnellRoad = new Road();
		Road southSnellRoad = new Road();
		Road eastWeaverRoad = new Road();
		Road westWeaverRoad = new Road();
		Map<Direction, Road> roadsAtIntersectionMap = new HashMap<>();
		roadsAtIntersectionMap.put(Direction.NORTH, northSnellRoad);
		roadsAtIntersectionMap.put(Direction.SOUTH, southSnellRoad);
		roadsAtIntersectionMap.put(Direction.EAST, eastWeaverRoad);
		roadsAtIntersectionMap.put(Direction.WEST, westWeaverRoad);

		Intersection fourWayIntersection = new FourWayIntersection(roadsAtIntersectionMap);
		ExecutorService ex = Executors.newFixedThreadPool(4);
		
		ex.execute(northSnellRoad);
		ex.execute(southSnellRoad);
		ex.execute(eastWeaverRoad);
		ex.execute(westWeaverRoad);
		
		fourWayIntersection.startIntersectionSignals();
		

		for (int i = 0; i < 20; i++) {
			System.out.println(
					i + ": N = " + northSnellRoad.getVehicleCount() + "; S = " + southSnellRoad.getVehicleCount()
							+ "; E = " + eastWeaverRoad.getVehicleCount() + "; W=" + westWeaverRoad.getVehicleCount());
			Thread.sleep(1000);
		}
		System.exit(0);
	}
}
