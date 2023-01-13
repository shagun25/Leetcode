class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Approaches: 
        // 1. Take 2 array pos and neg store into them 
        // tc: O(n)
        // space: O(n)
        // Two loops required
        
        //2. Take a extra array and store in it
        // start-> pos=0,neg=1;
        // pos+=2,neg+=2
        // tc: O(n)
        // space: O(n)
        // One loops required
        
        int n = nums.length;
        int arr[] = new int[n];
        int pos=0,neg=1;
        for(int num: nums){
            if(num>0) {
                arr[pos]=num;
                pos+=2;
            }else{
                arr[neg]=num;
                neg+=2;
            }
        }
        return arr;
        
    }
}