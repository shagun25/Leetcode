class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int prev=0;
        int result=1;
        for(int curr=1;curr<points.length;curr++){
            if(points[prev][1]<points[curr][0]){
                result++;
                prev=curr;
            }
        }
        return result;
    }
}