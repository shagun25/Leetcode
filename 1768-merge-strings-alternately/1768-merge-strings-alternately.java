class Solution {
    public String mergeAlternately(String word1, String word2) {
        String str="";
        int n = word1.length(),m = word2.length();
        int i=0,j=0;
        while(i<n && j<m){
            str+=word1.charAt(i++);
            str+=word2.charAt(j++);
        }
        if(i<n) str+=word1.substring(i);
        if(j<m) str+=word2.substring(j);
        return str;
    }
}