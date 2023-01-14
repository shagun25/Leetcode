class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind1=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]) {ind1=i;break;}
        }
        if(ind1!=-1){
           int ind2=0;
           for(int i=n-1;i>=0;i--){
              if(nums[i]>nums[ind1]) {ind2=i;break;}
           }
            swap(nums,ind1,ind2);
        }
      
        reverse(nums,ind1+1,n-1);
    }
    void swap(int[] nums,int ind1,int ind2){
        int temp = nums[ind1];
        nums[ind1]=nums[ind2];
        nums[ind2]=temp;
    }
    void reverse(int[] nums,int i,int j){
        while(i<j)
            swap(nums,i++,j--);
    }
}