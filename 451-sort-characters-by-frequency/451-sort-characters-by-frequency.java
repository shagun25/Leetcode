class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Character> bucket[] = new ArrayList[s.length()+1];
        for(char ch : map.keySet()){
            int count = map.get(ch);
            if(bucket[count]==null) bucket[count]=new ArrayList<Character>();
            bucket[count].add(ch);
        }
        StringBuilder str = new StringBuilder(); 
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(int k=0;k<bucket[i].size();k++){
                   for(int j=0;j<i;j++){
                    str.append(bucket[i].get(k));
                   } 
                }
            }
        }
        return str.toString();
    }
}