class Solution {
    public int findJudge(int n, int[][] trust) {
        int arr[] = new int[n+1];
        for(int tr[] : trust){
            arr[tr[1]]++;
            arr[tr[0]]--;
        }
        for(int i=1;i<=n;i++){
            if(arr[i]==n-1) return i;
        }
        return -1;
    }
}