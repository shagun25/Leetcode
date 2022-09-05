class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i=0,j=0,max=0;
        while(j<s.length()){
            char c = s.charAt(j);
            if(!set.contains(c)){
                set.add(c);
                max=Math.max(max,set.size());
                j++;
            }else set.remove(s.charAt(i++));
        }
        return max;
    }
}