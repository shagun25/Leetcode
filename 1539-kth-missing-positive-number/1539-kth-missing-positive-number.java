class Solution {
    public int findKthPositive(int[] arr, int k) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        int j=0;
        for(int i=1;i<=max;i++){
            if(i==arr[j]){
                j++;
                continue;
            }else {
                k--;
            }
            if(k==0) return i;
        }
        return max+k;
    }
}