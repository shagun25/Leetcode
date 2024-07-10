class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();
        for(String log: logs){
            if(!st.isEmpty() && log.equals("../")){
                System.out.println("pop: "+st.peek());
                st.pop();
            }
            else if(!log.equals("../") && !log.equals("./")){
                st.push(log);
                System.out.println("push: "+log);
            }
        }
        return st.size();
    }
}