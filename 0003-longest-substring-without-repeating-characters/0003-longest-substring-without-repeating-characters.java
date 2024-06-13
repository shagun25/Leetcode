class Solution {
    public int lengthOfLongestSubstring(String s) { 
        if(s.length()==0) return 0;
        HashSet<Character> set = new HashSet<>();
        int i=0,res=0;
        for(int j=0;j<s.length();){
            char ch = s.charAt(j);
            if(set.contains(ch)) set.remove(s.charAt(i++));
            else {
                set.add(ch);
                res = Math.max(res, set.size());
                j++;
            }
        }
        return res;
    }
}
