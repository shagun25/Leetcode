class Solution {
    public int bulbSwitch(int n) {
        int i=1,count=0;
        while(i*i<=n){
            count++;
            i++;
        }
        return count;
    }
}