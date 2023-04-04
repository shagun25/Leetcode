class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int count=1;
        for(Character ch : s.toCharArray()){
            if(set.contains(ch)){
                count++;
                set = new HashSet<>();
            }
            set.add(ch); 
        }
        return count;
    }
}