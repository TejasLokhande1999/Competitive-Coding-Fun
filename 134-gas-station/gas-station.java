class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int costSum = 0;
        int n = gas.length;
        for(int i=0;i<n;i++){
            sumGas+=gas[i];
            costSum+=cost[i];
        }

        if(sumGas<costSum){
            return -1;
        }

        int start = 0;
        int currGas = 0;
        for(int i=0;i<n;i++){
            currGas += gas[i]-cost[i];
            if(currGas<0){
                currGas = 0;
                start = i+1;
            }
        }

        return start;
    }
}