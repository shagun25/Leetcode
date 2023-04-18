class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity+ jug2Capacity<targetCapacity) return false;
        if(jug1Capacity==targetCapacity || jug2Capacity==targetCapacity || jug1Capacity+ jug2Capacity==targetCapacity) return true;
        return targetCapacity%gcd(jug1Capacity, jug2Capacity)==0;
    }
    int gcd(int x, int y){
        while(y!=0){
            int temp = y;
            y = x%y;
            x = temp;
        }
        return x;
    }
//Math problem-number theory
//use the property of Bézout's identity and check if z is a multiple of GCD(x, y)

// let a and b be nonzero integers and let d be their greatest common divisor. Then there exist integers x
// and y such that ax+by=d
// If a or b is negative => we are emptying a jug of x or y gallons respectively.
// if a or b is positive => we are filling a jug of x or y gallons respectively.
}