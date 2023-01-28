class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums==null || nums.length==0) return res;
        List<int[]> intervals = new ArrayList<>();
        int left=nums[0],right=nums[0];
        for(int i=1;i<nums.length;i++){
            int value=nums[i];
            if(value==right+1){
                right=value;
            }else{
                if(left==right) res.add(Integer.toString(left));
                else res.add(""+left+"->"+right);
                left=right=value;
            }
           // System.out.println("value: "+value+"left: "+left+"right: "+right);
        }
        if(left==right) res.add(Integer.toString(left));
        else res.add(""+left+"->"+right);
        return res;
    }
}
