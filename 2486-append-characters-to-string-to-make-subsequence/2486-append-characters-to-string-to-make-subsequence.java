class Solution {
    public int appendCharacters(String s, String t) {
        int i=0,j=0;
        for(i=0,j=0;i<s.length() && j<t.length();){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return t.length()-j;
    }
}