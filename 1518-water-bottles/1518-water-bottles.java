class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum=numBottles;
        while(numBottles>=numExchange){
            int qoutient = (numBottles/numExchange);
            int remainder = (numBottles%numExchange);
            sum+=qoutient;
            numBottles=qoutient+remainder;
        }
       return sum;
    }
}
