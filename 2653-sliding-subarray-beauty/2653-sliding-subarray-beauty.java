class Solution {
    int getMin(TreeMap<Integer,Integer> map, int x){
        int smallest=0;
        for(int val : map.keySet()){
            if(val<0) smallest+=map.get(val);
            else return 0;
            if(smallest>=x) return val;
        }
        return 0;
    }
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int n = nums.length;
        int res[] = new int[n-k+1];
        for(int i=0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int j=0;
        res[j++]=getMin(map,x);
        for(int i=k;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            map.put(nums[i-k],map.get(nums[i-k])-1);
            if(map.get(nums[i-k])==0) map.remove(nums[i-k]);
            res[j++]=getMin(map,x);
        }
        return res;
    }
}