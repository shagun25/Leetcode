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
//     Primitive string will have equal number of opened and closed parenthesis.

// Explanation:
// opened count the number of opened parenthesis.
// Add every char to the result,
// unless the first left parenthesis,
// and the last right parenthesis.

// Time Complexity:
// O(N) Time, O(N) space
}