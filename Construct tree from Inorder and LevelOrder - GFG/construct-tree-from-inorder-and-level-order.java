//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}

// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        return solve(inord,0,inord.length-1,level);
    }
    int findPos(int inord[],int x){
        for(int i=0;i<inord.length;i++) if(inord[i]==x) return i;
        return -1;
    }
    Node solve(int inord[],int inStart,int inEnd, int level[]){
        if(inStart>inEnd) return null;
        Node root = new Node(level[0]);
        if(level.length==1) return root;
        int pos = findPos(inord,level[0]);
        HashSet<Integer> set = new HashSet<>();
        for(int i=inStart;i<pos;i++){
            set.add(inord[i]);
        }
        int levelLeft[] = new int[pos-inStart];
        int levelRight[] = new int[inEnd-pos];
        int ls=0,rs=0;
        for(int i=1;i<level.length;i++){
            int elem = level[i];
            if(set.size()!=0 && set.contains(elem)){
                levelLeft[ls++]=elem;
                set.remove(elem);
            }else{
                levelRight[rs++]=elem;
            }
        }
        root.left=solve(inord,inStart,pos-1,levelLeft);
        root.right=solve(inord,pos+1,inEnd,levelRight);
        return root;
    }
   
}


