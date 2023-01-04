class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int count=1;
        int minimumRounds=0;
        for(int i=1;i<tasks.length;i++){
            if(tasks[i]==tasks[i-1]){
                count++;
            }else{
                if(count==1) return -1;
               if (count % 3 == 0) minimumRounds += count / 3;
               else minimumRounds += count / 3 + 1;
                count=1;
            }
        }
         if(count==1) return -1; 
       if (count % 3 == 0) minimumRounds += count / 3;
               else minimumRounds += count / 3 + 1;
        return minimumRounds;
    }
}