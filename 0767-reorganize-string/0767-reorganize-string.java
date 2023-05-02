class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> mp = new HashMap<Character,Integer>();
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b)->{
            return (mp.get(b)).compareTo(mp.get(a));
            });
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> e:mp.entrySet()){
            pq.add(e.getKey());
        }
        String str = "";
        while(!pq.isEmpty()){
            char ch = pq.poll();
            if(pq.isEmpty()){
                if(mp.get(ch)>1) return "";
                else str+=ch+"";
                break;
            }
            char ch1 = pq.poll();
            str+=ch+"";
            mp.put(ch,mp.get(ch)-1);
            str+=ch1+"";
            mp.put(ch1,mp.get(ch1)-1);
            if(mp.get(ch)!=0) pq.add(ch);
            if(mp.get(ch1)!=0) pq.add(ch1);
        }
        return str;
    }
}