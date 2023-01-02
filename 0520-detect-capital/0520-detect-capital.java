class Solution {
    public boolean detectCapitalUse(String word) {
        int upper=0,lower=0;
        for(char ch : word.toCharArray()){
            if (Character.isUpperCase(ch)) {
                upper++;
            }else {
                lower++;
            }
        }
        if(upper==1 && (word.length()-1)==lower && Character.isUpperCase(word.charAt(0))) return true;
        if(upper==0 && word.length()==lower) return true;
        if(upper==word.length() && lower==0) return true;
        return false;
    }
}