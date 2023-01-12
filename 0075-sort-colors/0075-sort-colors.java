class Solution {
    public void sortColors(int[] nums) {
        //Dutch National flag algorithm 
        int n = nums.length;
        int lo=0,mid=0,hi=n-1;
        while(mid<=hi){
            switch(nums[mid]){
                case 0 : 
                    {
                        int temp=nums[mid];
                        nums[mid]= nums[lo];
                        nums[lo]=temp;
                        lo++;mid++;
                        break;
                    }
                case 1:
                    {
                        mid++;
                        break;
                    }
                case 2:
                    {
                       int temp=nums[mid];
                        nums[mid]= nums[hi];
                        nums[hi]=temp;
                        hi--;
                        break; 
                    }
            }
            
        }
    }
}