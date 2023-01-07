class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      //TLE O(n2)  
        // int n=gas.length;
        // for(int i=0;i<n;i++){
        //     if(gas[i]>=cost[i]) {
        //         int j=(i+1)%n;
        //         int currGas = gas[i]-cost[i]+gas[j];
        //         while(i!=j){
        //              if(currGas>=cost[j]) {
        //                  int gass = cost[j];
        //                j=(j+1)%n;
        //                 currGas-= gas[j]-gass;
        //              }else break;
        //         }
        //         if(i==j) return i;
        //     }
        // }
        // return -1;
        int totalgas=0,totalCost=0;
        int n=gas.length;
        for(int i=0;i<n;i++){
            totalgas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalgas<totalCost) return -1;
        int remaining_gas=0,start=0;
        for(int i=0;i<n;i++){
            remaining_gas+=gas[i]-cost[i];
            if(remaining_gas<0){
                start=i+1;
                remaining_gas=0;
            }
        }
        return start;
    }
}