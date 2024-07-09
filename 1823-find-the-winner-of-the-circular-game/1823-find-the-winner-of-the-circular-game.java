class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<=n;i++) arr.add(i);
        int i=0,count=k-1;
        while(arr.size()>1){
            i=(i+count)%arr.size();
            arr.remove(i); 
        }
        return arr.get(0);
    }
}