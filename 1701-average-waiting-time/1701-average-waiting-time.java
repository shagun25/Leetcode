class Solution {
    public double averageWaitingTime(int[][] customers) {
        int x =0;
        long wait=0;
        for(int customer[]: customers){
            int arr = customer[0];
            int time = customer[1];
            if(x<arr) x=arr+time;
            else x+=time;
            // x = Math.max(x,arr)+time;
            wait+=x-arr;
            System.out.println("wait"+wait);
        }
        int n = customers.length;
        return wait/(double)n;
    }
}