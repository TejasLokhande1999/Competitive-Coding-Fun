class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sumGas = 0;
        int sumCost = 0;
        for(int i=0;i<n;i++){
            sumGas+=gas[i];
            sumCost+=cost[i];
        }

        if(sumGas<sumCost){
            return -1;
        }

        int currGas = 0;
        int start = 0;
        for(int i=0;i<n;i++){
            currGas+=gas[i]- cost[i];

            if(currGas<0){
                currGas = 0;
                start=i+1;
            }
        }

        return start;
    }

}