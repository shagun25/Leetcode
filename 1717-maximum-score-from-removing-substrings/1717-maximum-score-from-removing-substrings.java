import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        int gain = 0;
        int largerVal = Math.max(x, y); 
        int smallerVal = Math.min(x, y); 
        char firstChar = x > y ? 'a' : 'b';
        char secondChar = firstChar == 'a' ? 'b' : 'a';

  
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == firstChar && ch == secondChar) {
                stack.pop();
                gain += largerVal;
            } else if(ch == firstChar || ch == secondChar){
                stack.push(ch);  
            }else if(!stack.isEmpty() && stack.peek()!=x){
                stack.push('x');  
            }
        }
        int count=0;
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (ch==firstChar) {
                count++;
            } else if(ch==secondChar && count>0){
                gain+=smallerVal;
                count--;
            }else{
                count=0;
            }
        }

        return gain;
    }

}