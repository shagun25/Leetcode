class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                sum%=1000000007;
                list.add(sum);
            }
        }
        Collections.sort(list);
        int sum=0;
        for(int i=left;i<=right;i++){
            sum+=list.get(i-1);
             sum%=1000000007;
        }
        return sum;
    }
}