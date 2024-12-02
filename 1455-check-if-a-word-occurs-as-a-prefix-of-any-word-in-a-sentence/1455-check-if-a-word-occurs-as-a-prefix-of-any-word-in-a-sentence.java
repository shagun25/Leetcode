class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strgs = sentence.split(" ");
        int k=0;
        for(String str:strgs){
            int j=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)!=searchWord.charAt(j)) break;
                j++;
                if(j==searchWord.length()) return k+1;
                
            }
            k++;
        }
        return -1;
    }
}