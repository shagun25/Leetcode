class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<Integer>();
        int node_level=1;
        int level=1;
        while(label>=node_level*2){
            node_level=node_level*2;
            level++;
        }
        while(label!=0){
            list.add(label);
             int levelmax = ((int)Math.pow(2, level)) - 1;
             int levelmin = (int)Math.pow(2, level-1);
             label = (int)((levelmax + levelmin - label)/2);
             level--;
        }
        Collections.reverse(list);
        return list;
    }
}