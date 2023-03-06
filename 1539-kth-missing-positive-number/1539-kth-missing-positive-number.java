class Solution {
    //We increase k everytime until with we get an element on the array greater than it
    public int findKthPositive(int[] arr, int k) {
        for(int i : arr){
			if(i <= k) k++; else break;
		}
        return k;
    }
}