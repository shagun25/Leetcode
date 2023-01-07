class DataStream {
    Deque<Integer> dq = new LinkedList<>();
    Map<Integer,Integer> mp = new HashMap<>();
    int k,value;
    public DataStream(int value, int k) {
        this.value=value;
        this.k=k;
    }
    
    public boolean consec(int num) {
        mp.put(num,mp.getOrDefault(num,0)+1);
        dq.addLast(num);
        while(dq.size()>k){
            int front = dq.getFirst();
            dq.removeFirst();
            mp.put(front,mp.get(front)-1);
            if(mp.get(front)==0) mp.remove(front);
        }
        if(mp.containsKey(value) && mp.get(value)==k) return true;
        return false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */