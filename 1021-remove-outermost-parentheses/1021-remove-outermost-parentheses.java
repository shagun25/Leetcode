class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (st.size() >0) {
                    sb.append(ch);
                }
                st.push(ch);
            } else {
                if (st.size() > 1) {
                    sb.append(ch);
                }
                st.pop();
            }
        }
        return sb.toString();
    }
}