class Solution {
    public static boolean isAllocationPossible(int barrier, int arr[], int totalStudents)
    {
        int students = 1;
        int pages = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > barrier)
                return false;
            
            if((pages + arr[i]) > barrier)
            {
                // pages = 0;
                students += 1;
                pages = arr[i];
            }
            else
            {
                pages += arr[i];
            }
        }
        
        if(students > totalStudents) return false;
        
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = Integer.MIN_VALUE;
        int high = 0;
        if(n < k) return -1;
        
        for(int ele : nums)
        {
            low = Math.max(low, ele);
            high = high + ele;
        }
        
        int res = -1;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(isAllocationPossible(mid, nums, k))
            {
                res = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return res;
    }
}