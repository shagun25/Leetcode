class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            int x = arr[i];
            if(i+1>=n) break;
            if(i+2>=n) break;
            int y = arr[i+1];
            int z = arr[i+2];
            if(x%2!=0 && y%2!=0 && z%2!=0) return true;
        }
        return false;
    }
}