class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack=new Stack<>();
         List<Character> list=new ArrayList<>();
        char[] ch=s.toCharArray();
        for(char c: ch){
            if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                         list.add(stack.pop());
                }
                stack.pop();
                for(char c2: list){
                    stack.push(c2);
                }
                list.clear();
            }
            else{
                stack.push(c);
            }
        }
    
    String ans="";
    while(!stack.isEmpty()){
        ans=stack.pop()+ans;
    }
    return ans;
    }
}