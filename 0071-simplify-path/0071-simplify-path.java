class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] p =path.split("/");
        
        for(int i=0;i<p.length;i++){
            if(!s.isEmpty()  && p[i].equals("..")) s.pop();
            else if(s.isEmpty()  && p[i].equals("..")) continue;
            else if(p[i].equals("") || p[i].equals(".") ) continue;
            else s.push(p[i]);
        }
        
        
        if(s.isEmpty()) return "/";
        while(!s.isEmpty()){
            //System.out.println(s.pop());
            res.insert(0,s.pop()).insert(0,"/");
        }
        
        return res.toString();
    }
}