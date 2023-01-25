class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       // Approach 1:
       //  use array and put all the elements and sort
       //      tc: O(nlogn)
       //      sc: O(n)
        // Approach 2:
        // use merge sort function and put all the elements in array
        //     tc: O(n)
        //     sc: O(n)
        // Approach 3:
        // use merge sort function and use counter to store median elements
        //     tc: O(n)
        //     sc: O(1)
        // Approach 4:
        // use binary search
        //     tc: O(logn)
        //     sc: O(1)
        int m = nums1.length,n=nums2.length;
        boolean isEven = (m+n)%2==0?true:false;
        if(m<n) return findMedian(nums1,nums2,isEven);
        return findMedian(nums2,nums1,isEven);
    }
    double findMedian(int[] nums1,int[] nums2,boolean isEven){
        int m = nums1.length,n=nums2.length;
        int l = 0, h=m;
        int N = m+n; 
        while(l<=h){
            int mid = l+(h-l)/2;
            int b = (N+1)/2-mid;
            int mi = (mid==0)?Integer.MIN_VALUE:nums1[mid-1];
            int ml = (mid==m)?Integer.MAX_VALUE:nums1[mid];
            int bi = (b==0)?Integer.MIN_VALUE:nums2[b-1];
            int bl = (b==n)?Integer.MAX_VALUE:nums2[b];
        
            if(mi>bl) h=mid-1;
            else if(bi>ml) l=mid+1;
            else{
                int left = Math.max(mi,bi);
                int right = Math.min(ml,bl);
                if(!isEven) return left;
                return (double)(left+right)/2;
            }
        }
        return (double)0;
    }
}