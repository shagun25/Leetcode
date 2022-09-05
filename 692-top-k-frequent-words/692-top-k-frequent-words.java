class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        List<String>[] bucket = new ArrayList[words.length + 1];
        for (String word : map.keySet()) {
            int count = map.get(word);
            if (bucket[count] == null) {
             bucket[count] = new ArrayList<String>();
            }
            bucket[count].add(word);
        }
        
        List<String> resultList = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 && resultList.size() < k; i--) {
            if (bucket[i] != null){
                Collections.sort(bucket[i]);
                resultList.addAll(bucket[i]);
            }
        }
        return resultList.subList(0,k);
    }
}