class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> curr = new ArrayList<>();
            if (bucket[entry.getValue()] != null) {
                curr = bucket[entry.getValue()];
            }
            curr.add(entry.getKey());
            bucket[entry.getValue()] = curr;
        }
        
        List<Integer> resultList = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 && resultList.size() < k; i--) {
            if (bucket[i] != null)
                resultList.addAll(bucket[i]);
        }
        
        int[] result = new int[k];
        int i = 0;
        for (Integer value : resultList.subList(0, k)) {
            result[i] = value;
            i++;
        }
        return result;
    }
}