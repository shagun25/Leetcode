class Solution {
    private void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        // Calculate the start and sizes of two halves.
        int start1 = left;
        int start2 = mid + 1;
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Copy elements of both halves into a temporary array.
        for (int i = 0; i < n1; i++) {
            tempArr[start1 + i] = arr[start1 + i];
        }
        for (int i = 0; i < n2; i++) {
            tempArr[start2 + i] = arr[start2 + i];
        }

        // Merge the sub-arrays 'in tempArray' back into the original array 'arr' in sorted order.
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (tempArr[start1 + i] <= tempArr[start2 + j]) {
                arr[k] = tempArr[start1 + i];
                i += 1;
            } else {
                arr[k] = tempArr[start2 + j];
                j += 1;
            }
            k += 1;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = tempArr[start1 + i];
            i += 1;
            k += 1;
        }
        while (j < n2) {
            arr[k] = tempArr[start2 + j];
            j += 1;
            k += 1;
        }
    }
    private void mergeSort(int[] nums, int left, int right, int[] tempArray){
        if(left>=right) return;
        int mid = (left+right)/2;
        mergeSort(nums,left,mid,tempArray);
        mergeSort(nums,mid+1,right,tempArray);
        merge(nums,left,mid,right,tempArray);
    }
    public int[] sortArray(int[] nums) {
        int tempArray[] = new int[nums.length];
        mergeSort(nums,0,nums.length-1,tempArray);
        return nums;
    }
}