class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int min = 1, max = position[position.length-1]-position[0];
        int res=0;
        while(min<=max){
            int mid = min+(max-min)/2;
            if(checkMinMax(position, mid, m)==m){
                res=mid;
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        return res;
    }
    int checkMinMax(int[] position, int mid, int m){
        int prev = position[0];
        int count = 1;

        for (int i = 1; i < position.length && count < m; ++i) {
            if (position[i] - prev >= mid) {
                count += 1;
                prev = position[i];
            }
        }
        return count;
    }
}