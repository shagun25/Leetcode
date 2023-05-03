class Solution {
    //Solution 1: Max Heap keeps up to k elements
    // public int kthSmallest(int[][] matrix, int k) {
    //     int m = matrix.length, n = matrix[0].length; // For general, the matrix need not be a square
    //     PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    //     for (int r = 0; r < m; ++r) {
    //         for (int c = 0; c < n; ++c) {
    //             maxHeap.offer(matrix[r][c]);
    //             if (maxHeap.size() > k) maxHeap.poll();
    //         }
    //     }
    //     return maxHeap.poll();
    // }
    //Complexity:
    //Time: O(M * N * logK), where M <= 300 is the number of rows, N <= 300 is the number of columns.
    //Space: O(K), space for heap which stores up to k elements.
    
    
    
    //Solution 2: Min Heap to find kth smallest element from amongst N sorted list
//     public int kthSmallest(int[][] matrix, int k) {
//         int m = matrix.length, n = matrix[0].length, ans = -1; // For general, the matrix need not be a square
//         PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
//         for (int r = 0; r < Math.min(m, k); ++r)
//             minHeap.offer(new int[]{matrix[r][0], r, 0});

//         for (int i = 1; i <= k; ++i) {
//             int[] top = minHeap.poll();
//             int r = top[1], c = top[2];
//             ans = top[0];
//             if (c + 1 < n) minHeap.offer(new int[]{matrix[r][c + 1], r, c + 1});
//         }
//         return ans;
//     }
    //Complexity:
    //Time: O(K * logK)
    //Space: O(K)
    
    //Solution 3: Binary Search
    int m, n;
    public int kthSmallest(int[][] matrix, int k) {
        m = matrix.length; n = matrix[0].length; // For general, the matrix need not be a square
        int left = matrix[0][0], right = matrix[m-1][n-1], ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (countLessOrEqual(matrix, mid) >= k) {
                ans = mid;
                right = mid - 1; // try to looking for a smaller value in the left side
            } else left = mid + 1; // try to looking for a bigger value in the right side
        }
        return ans;
    }
    int countLessOrEqual(int[][] matrix, int x) {
        int cnt = 0, c = n - 1; // start with the rightmost column
        for (int r = 0; r < m; ++r) {
            while (c >= 0 && matrix[r][c] > x) --c;  // decrease column until matrix[r][c] <= x
            cnt += (c + 1);
        }
        return cnt;
    }
    //Complexity
    //Time: O((M+N) * logD), where M <= 300 is the number of rows, N <= 300 is the number of columns, D <= 2*10^9 is the difference between the maximum element and the minimum element in the matrix.
    //Space: O(1).

}

