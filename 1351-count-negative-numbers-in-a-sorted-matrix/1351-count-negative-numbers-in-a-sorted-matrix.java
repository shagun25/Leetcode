class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid[0].length;
        
        for (int[] row : grid) {
            
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (row[mid] < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;  
                }
            }
            count += (n - left);
        }
        return count;
    }
}