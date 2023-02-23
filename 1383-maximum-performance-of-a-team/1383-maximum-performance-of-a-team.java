class Solution {
    class Score implements Comparable<Score>{
        int efficiency;
        int speed;
        Score(int efficiency,int speed){
            this.efficiency = efficiency;
            this.speed = speed;
        }
        public int compareTo(Score score){
            return efficiency-score.efficiency;
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int) Math.pow(10, 9) + 7;
        Score scores[] = new Score[n];
        for(int i=0;i<n;i++){
           scores[i] = new Score(efficiency[i],speed[i]); 
        }
        Arrays.sort(scores, Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        long res=0,sum=0;
        for(int i=0;i<n;i++){
            pq.add(scores[i].speed);
            sum+=scores[i].speed;
            if(pq.size()>k) sum-=pq.poll();
            res=Math.max(res,sum*scores[i].efficiency);
        }
        return (int)(res%mod);
    }
}