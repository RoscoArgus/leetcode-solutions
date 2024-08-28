class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //check if solution
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0; i<gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost)
            return -1;

        //find solution
        int total = 0;
        int result = 0;
        for(int i=0; i<gas.length; i++) {
            total += (gas[i]-cost[i]);
            if(total<0) {
                total = 0;
                result = i+1;
            }
        }
        return result;
    }
}