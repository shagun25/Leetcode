class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j=0;
        for(int x:pushed){
            st.push(x);
            while(j<popped.length && !st.isEmpty() && popped[j]==st.peek()) {
                st.pop();
                j++;
            }
        }
        for(;j<popped.length;j++){
            if(!st.isEmpty() && popped[j]==st.peek()) {
                st.pop();
            }else return false;
        }
        return true;
    }
}