class Solution {
    public int passThePillow(int n, int time) {
        int rounds = time/(n-1);

        int remainder= time -rounds*(n-1);

        return (rounds%2==0)?1+remainder:n-remainder; 
    }
}