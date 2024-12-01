class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int a: arr) {
            if((a%2==0 && set.contains(a/2) )|| set.contains(a*2)) return true;
            set.add(a);
        }
        return false;
    }
}