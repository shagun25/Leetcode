class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int x:nums1){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int x: nums2){
            if(map.containsKey(x)){
                res.add(x);
                if(map.get(x)>1) map.put(x,map.get(x)-1);
                else map.remove(x);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}