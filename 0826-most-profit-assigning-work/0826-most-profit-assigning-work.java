class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=0;i<profit.length;i++){
            arr.add(new int[]{difficulty[i],profit[i]});
        }
        Collections.sort(arr, (a,b)->a[0]-b[0]);
        int j=0, res=0, maxProfit=0;
        Arrays.sort(worker);
        for(int i=0;i<worker.length;i++){
            while(j<profit.length && worker[i]>=arr.get(j)[0]) {
                maxProfit=Math.max(maxProfit,arr.get(j)[1]);
                j++;
            }
            res+=maxProfit;
        }
        return res;
    }
}
