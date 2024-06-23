class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum=0,impact=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0) sum+=customers[i];
        }
        for(int i=0;i<customers.length-minutes+1;i++){
            int imp=0;
            for(int j=i;j<i+minutes;j++){
                if(grumpy[j]==1) imp+=customers[j];
            }
            impact=Math.max(impact,imp);
        }
        return impact+sum;
    }
}