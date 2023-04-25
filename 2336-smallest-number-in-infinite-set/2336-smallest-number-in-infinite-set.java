class SmallestInfiniteSet {
    HashSet<Integer> set;
    PriorityQueue<Integer> pq;
    int currentInteger;
    public SmallestInfiniteSet() {
        set = new HashSet<Integer>();
        pq = new PriorityQueue<Integer>();
        currentInteger=1;
    }
    
    public int popSmallest() {
        int ans;
        if(pq.size()==0) {
            ans = currentInteger;
            currentInteger++;
        }
        else{
            set.remove(pq.peek());
            ans=pq.poll();
        }
        return ans;
    }
    
    public void addBack(int num) {
        if(currentInteger<=num || set.contains(num)) return; 
            pq.add(num);
            set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */