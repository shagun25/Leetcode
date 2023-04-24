class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int stone : stones) pq.add(stone);
        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            if(x==y) continue;
            else if(x>y) pq.add(x-y);
            else pq.add(y-x);
        }
        return pq.size()==0?0:pq.poll();
    }
}