class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int res[] = new int[spells.length];
        
        for(int i=0;i<spells.length;i++){
            int l=0,h=potions.length-1;
            int spell = spells[i];
            while(l<=h){
                int m = l+(h-l)/2;
                long product = (long) spell * potions[m];
                if (product >= success) h=m-1;
                else l=m+1;
            }
            res[i]=potions.length-l;
        }
        return res;
    }
}