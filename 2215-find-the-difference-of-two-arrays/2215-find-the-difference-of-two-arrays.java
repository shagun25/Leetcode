class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>(),set2 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        for(int num : nums2){
            set2.add(num);
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>(),ans2 = new ArrayList<>();
        for(int x:set1){
            if(!set2.contains(x)) ans1.add(x);
        }
        for(int x:set2){
            if(!set1.contains(x)) ans2.add(x);
        }
        list.add(ans1);
        list.add(ans2);
        return list;
    }
}