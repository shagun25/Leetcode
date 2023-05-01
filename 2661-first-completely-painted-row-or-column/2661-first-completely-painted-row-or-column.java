class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
       int m = mat.length;
        int n = mat[0].length;
        int r[] = new int[m];
        int c[] = new int[n];
        
        Map<Integer, int[]> map = new HashMap<>();
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        
        for(int i = 0; i < arr.length; i++)
        {
            int[] posi = map.get(arr[i]);
            int x = posi[0];
            int y = posi[1];
            r[x]++;
            c[y]++;
			// any index of r is storing painted columns of that particular row 
			// any index of c is storing painted rows of that particular column.
            if(r[x] == n || c[y] == m)  // as any column size of a particular row is n and any row size of a particular column is m
                return i;
        }
        return arr.length - 1; 
    }
}