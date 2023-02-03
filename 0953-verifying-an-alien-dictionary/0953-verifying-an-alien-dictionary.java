class Solution {
    public boolean isAlienSorted(String[] words, String orders) {
        int order[] = new int[26];
        for(int i=0;i<orders.length();i++){
            order[orders.charAt(i)-'a']=i;
        }
        
        for(int i=0;i<words.length-1;i++){
            for(int j=0;j<words[i].length();j++){
                if(j>=words[i+1].length()) return false;
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    int currChar = words[i].charAt(j)-'a';
                    int nextChar = words[i+1].charAt(j)-'a';
                    if(order[nextChar]<order[currChar]) return false;
                    else break;
                }
            }
        }
        
        return true;
    }
 
}