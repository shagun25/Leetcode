class SmallestInfiniteSet {
    TreeSet<Integer> set;
    int currentInteger;
    public SmallestInfiniteSet() {
        set = new TreeSet<Integer>();
        currentInteger=1;
    }
    
    public int popSmallest() {
        int ans;
        if(set.size()==0) {
            ans = currentInteger;
            currentInteger++;
        }
        else{
            ans=set.first();
            set.remove(ans);
        }
        return ans;
    }
    
    public void addBack(int num) {
        if(currentInteger<=num || set.contains(num)) return; 
            set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */