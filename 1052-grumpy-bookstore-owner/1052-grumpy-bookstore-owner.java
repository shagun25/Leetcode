class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum=0,impact=0, imp=0;
        for(int i=0;i<minutes;i++){
             if(grumpy[i]==0) sum+=customers[i];
            if(grumpy[i]==1) imp+=customers[i];
        }
        impact=Math.max(impact,imp);
        for(int i=minutes;i<customers.length;i++){
             if(grumpy[i]==0) sum+=customers[i];
              if(grumpy[i]==1) imp+=customers[i];
              if(grumpy[i-minutes]==1)  imp-=customers[i-minutes];
             impact=Math.max(impact,imp);
        }
        return impact+sum;
    }
}