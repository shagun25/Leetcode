class Solution {
    class Score implements Comparable<Score>{
        int num2;
        int num1;
        Score(int num2,int num1){
            this.num2 = num2;
            this.num1 = num1;
        }
        public int compareTo(Score score){
            return num2-score.num2;
        }
    }
    public long maxScore(int[] num1, int[] num2, int k) {
        int n = num1.length;
        Score scores[] = new Score[n];
        for(int i=0;i<n;i++){
           scores[i] = new Score(num2[i],num1[i]); 
        }
        //scores[] = [[4,2],[3,3],[2,1],[1,3]]
        Arrays.sort(scores, Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        long res=0,sum=0;
        for(int i=0;i<n;i++){
            pq.add(scores[i].num1);//pq : 2 3 3
            sum+=scores[i].num1;//sum+=2+3=5+1=6+3=9-1=8
            if(pq.size()>k) sum-=pq.poll();
            if(pq.size()==k) res=Math.max(res,sum*scores[i].num2);//res=6*2=12
        }
        return res;
    }
}
