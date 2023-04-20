class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node,int level){
        this.node = node;
        this.level=level;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
          int width=0;
        if(root==null) return width;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        
       
        while(!queue.isEmpty()){
            int sz = queue.size();
            int start=0,end=0;
            for(int i=0;i<sz;i++){
                Pair rm = queue.poll();
                if(i==0) start = rm.level;
                if(i==sz-1) end = rm.level;
                if(rm.node.left!=null) queue.add(new Pair(rm.node.left,2*rm.level));
                if(rm.node.right!=null) queue.add(new Pair(rm.node.right,2*rm.level+1));
            }
          width=Math.max(width,end-start+1);
        }
        return width;
    }
}