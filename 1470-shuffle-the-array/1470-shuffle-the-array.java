class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[n*2];
        for(int i=0;i<n;i++){
            res[i+i]=nums[i];
        }
        int j=1;
        for(int i=n;i<2*n;i++){
            res[j]=nums[i];
            j=j+2;
        }
        return res;
    }
}