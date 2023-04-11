class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='*') st.pop();
            else st.push(ch);
        }
        String str = "";
        while(!st.isEmpty()){
            str=st.pop()+str;
        }
        return str;
    }
}