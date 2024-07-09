class Solution {
    public double averageWaitingTime(int[][] customers) {
        int x =0;
        long wait=0;
        for(int customer[]: customers){
            int arr = customer[0];
            int time = customer[1];
            if(x<arr) x=arr+time;
            else x+=time;
            wait+=x-arr;
        }
        return wait/(double)customers.length;
    }
}