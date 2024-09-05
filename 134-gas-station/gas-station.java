class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;  // Total gas surplus/deficit
        int currentGas = 0;  // Current surplus at this point
        int startIndex = 0;  // Starting point
        
        for (int i = 0; i < gas.length; i++) {
            int gasDiff = gas[i] - cost[i];  // Net gas gain at this station
            totalGas += gasDiff;  // Add to the total gas difference
            currentGas += gasDiff;  // Add to the current gas balance
            
            // If currentGas drops below 0, reset the starting point to the next station
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0;  // Reset current gas as we're starting from a new point
            }
        }
        
        // If the total gas is negative, no solution exists
        if (totalGas < 0) {
            return -1;
        }
        
        // Otherwise, return the valid starting index
        return startIndex;
    }
}