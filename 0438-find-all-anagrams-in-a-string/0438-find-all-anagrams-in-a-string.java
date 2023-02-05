class Solution {
    boolean checkAnagram(String s, String p){
        if(s==null || p==null || s.length()!=p.length()) return false;
        int[] dict = new int[26];
        for(Character ch : s.toCharArray()){
            dict[ch-'a']++;
        }
        for(Character ch : p.toCharArray()){
            dict[ch-'a']--;
            if(dict[ch-'a']<0) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<s.length()-p.length()+1;i++){
            if(checkAnagram(s.substring(i,i+p.length()),p)){
                res.add(i);
            }
        }
        return res;
    }
}