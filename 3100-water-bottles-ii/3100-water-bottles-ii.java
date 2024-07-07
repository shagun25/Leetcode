class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int sum=numBottles;
        while(numBottles>=numExchange){
            sum+=1;
            numBottles=(numBottles-numExchange)+1;
            numExchange++;
        }
       return sum;
    }
}

