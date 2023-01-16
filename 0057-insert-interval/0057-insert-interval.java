class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            if(newInterval==null || end<newInterval[0] ) res.add(interval);
            else if(newInterval[1]<start) {
                res.add(newInterval);
                res.add(interval);
                newInterval=null;
            }else{
                int start1 = Math.min(start,newInterval[0]);
                int end1 = Math.max(end,newInterval[1]);
                newInterval = new int[]{start1,end1};
            }
        }
        if(newInterval!=null){
            res.add(newInterval);
        }
        int result[][] = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            result[i][0]=res.get(i)[0];
            result[i][1]=res.get(i)[1];
        }
        return result;
    }
    
}