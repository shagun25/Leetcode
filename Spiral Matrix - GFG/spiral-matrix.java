//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
	public int findK(int matrix[][], int n, int m, int k)
	{
	   List<Integer> list = new ArrayList<Integer>();
        if(matrix.length==0) return 0;
        int top=0,right=matrix[0].length-1,bottom=matrix.length-1,left=0;
        int dir=0;
        while(top<=bottom && left<=right){
            if(dir==0){
            for(int j=left;j<=right;j++)
               list.add(matrix[top][j]);
            top++;
            }
            else if(dir==1){
           for(int i=top;i<=bottom;i++)
               list.add(matrix[i][right]);
           right--;
            }
            else if(dir==2){
              for(int j=right;j>=left;j--)
                 list.add(matrix[bottom][j]);
              bottom--;
            }
            else if(dir==3){
              for(int i=bottom;i>=top;i--)
                 list.add(matrix[i][left]);
              left++; 
           }
           dir=(dir+1)%4;
        }
        return list.get(k-1);
	}
	
}