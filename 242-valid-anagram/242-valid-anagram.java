class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char ss = s.charAt(i);
            char ts = t.charAt(i);
            map.put(ss,map.getOrDefault(ss,0)+1);
             map.put(ts,map.getOrDefault(ts,0)-1);
        }
for (int count : map.values()) {
           if(count!=0) return false;
        }
        return true;
    }
}