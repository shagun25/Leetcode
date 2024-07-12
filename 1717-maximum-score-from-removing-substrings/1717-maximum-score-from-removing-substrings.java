import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        int gain = 0;
        int largerVal = Math.max(x, y);
        int smallerVal = Math.min(x, y);
        char firstChar = x > y ? 'a' : 'b';
        char secondChar = firstChar == 'a' ? 'b' : 'a';

        // First pass: process characters based on the larger gain
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == firstChar && ch == secondChar) {
                stack.pop();
                gain += largerVal;
            } else {
                stack.push(ch);
            }
        }

        // Second pass: process remaining characters for the smaller gain
        Stack<Character> secondStack = new Stack<>();
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (!secondStack.isEmpty() && secondStack.peek() == firstChar && ch == secondChar) {
                secondStack.pop();
                gain += smallerVal;
            } else {
                secondStack.push(ch);
            }
        }

        return gain;
    }
}
