This is a maven project. To execute, simply run the SignalOperations.java after importing the project in eclipse.

### Coding problem: Traffic Signals

Write a program that controls the traffic signals for a four-way intersection. Initially, we consider traffic flowing in straight lines only, no turns. The four directions are S(outhbound) and N(orthbound) on Snell Rd; and W(estbound) and E(astbound) on Weaver Rd. The traffic lights should obey the following rules:

1. Cars arrive in each direction on both roads (Snell and Weaver) at the rate of 1 car per second. That is, 4 cars approach the intersection each second.

2. Only one road (Snell or Weaver) can have a "green" light at one time.

3. It is acceptable for both roads to have the "red" light at the same time. Of course, traffic backs up on both roads if this happens.

4. Start by turning on the traffic on Snell Rd "green" in both directions for 3 seconds; then turn it "red" for one second; then turn Weaver "green" for 3 seconds; and then red for one second.

5. When the light turns from red to green at any intersection, it takes the first car 2 seconds to start moving and cross the intersection. Subsequent cars take 1 second each.

6. At the instant the light turns from "green" to "red", a car may not start moving to cross the intersection; whether that car just arrived at the intersection or was waiting at that intersection.

7. The output should be the number of cars that are waiting at the intersection in each direction at each second, for the first 20 seconds. Do not make the program wait 20 seconds to produce the output: this is only a simulation, so print the output when it's ready.

8. Expected output
```
 	0: N = 0; S = 0; E = 0; W = 0
 	1: N = 0; S = 0; E = 1; W = 1
 	2: N = 0; S = 0; E = 2; W = 2
 	3: N = 0; S = 0; E = 3; W = 3
 	4: N = 1; S = 1; E = 4; W = 4
 	5: N = 2; S = 2; E = 5; W = 5
 	6: N = 3; S = 3; E = 5; W = 5
 	7: N = 4; S = 4; E = 5; W = 5
 	8: N = 5; S = 5; E = 6; W = 6
```