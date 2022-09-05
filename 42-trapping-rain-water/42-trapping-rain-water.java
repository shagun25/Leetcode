class Solution {
    public int trap(int[] height) {
       int lo=0,hi=height.length-1,left_max=0,right_max=0,water=0;
        while(lo<hi){
            if(height[lo]<height[hi]){
                if(height[lo]>=left_max) left_max = height[lo];
                else water+= left_max - height[lo];
                lo++;
            }else{
                if(height[hi]>=right_max) right_max = height[hi];
                else water+= right_max - height[hi];
                hi--;
            }
        }
        return water;
    }
}