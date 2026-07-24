package com.rpk.dsa;

/**
 * 
 * This class implements a solution to the Gas Station problem. The `GasStation` class includes the following method:
 * - `canCompleteCircuit(int[] gas, int[] cost)`: Determines if there is a valid starting gas station index, or returns -1 if none exists.
 *  The method takes two integer arrays as input: `gas`, where `gas[i]` represents the amount of gas available at station `i`, and `cost`, where `cost[i]` represents the cost of gas required to travel from station `i` to station `i+1`. The method returns the index of the starting gas station if a valid circuit can be completed, or -1 if it is not possible to complete the circuit.
 * The algorithm works by iterating through the gas stations and calculating the total gas and total cost. It also maintains a `tank` variable to track the current gas in the tank while traversing the stations. If at any point the `tank` becomes negative, it means that starting from the current station is not feasible, and the algorithm resets the starting index to the next station and resets the `tank` to zero. After iterating through all stations, if the total gas is greater than or equal to the total cost, it returns the starting index; otherwise, it returns -1.
 * Example usage:   
 * GasStation gasStation = new GasStation();
 * int[] gas1 = {1, 2, 3, 4, 5};
 * int[] cost1 = {3, 4, 5, 1, 2};
 * System.out.println(gasStation.canCompleteCircuit(gas1, cost1)); // Output: 3
 * int[] gas2 = {2, 3, 4};  
 * int[] cost2 = {3, 4, 3};
 * System.out.println(gasStation.canCompleteCircuit(gas2, cost2)); // Output: -1
 *  
 * GasStation
 */

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }

        return totalGas >= totalCost ? startIndex : -1;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println(gasStation.canCompleteCircuit(gas1, cost1)); // Output: 3

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println(gasStation.canCompleteCircuit(gas2, cost2)); // Output: -1
    }

}
