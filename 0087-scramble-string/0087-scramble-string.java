class Solution {
    HashMap<String,Boolean> map;
    public boolean isScramble(String s1, String s2) {
        map = new HashMap<>();
        if(s1.length() != s2.length()) return false;
        return solve(s1,s2);
    }
    boolean solve(String s1, String s2){
        if(s1.equals(s2)) return true;
        if(s1.length()<=1) return false;
        
        String key = s1 + "_" + s2;
        if(map.containsKey(key)) return map.get(key);
        
        boolean flag=false;
        int n = s1.length();
        for(int i=1;i<n;i++){
            boolean noswap = solve(s1.substring(0,i),s2.substring(0,i)) && solve(s1.substring(i),s2.substring(i));
            boolean swap = solve(s1.substring(0,i),s2.substring(n-i)) && solve(s1.substring(i),s2.substring(0,n-i));
            if(swap || noswap){
                flag=true;
                break;
            }
        }
        map.put(key,flag);
        return flag;
    }
}