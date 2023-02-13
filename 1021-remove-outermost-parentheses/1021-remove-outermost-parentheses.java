class Solution {
    public String removeOuterParentheses(String str) {
        StringBuilder s = new StringBuilder();
        int opened=0;
        for(char ch : str.toCharArray()){
            if(ch=='(' && opened++>0) s.append(ch);
            if(ch==')' && opened-->1) s.append(ch);
        }
        return s.toString();
    }
}