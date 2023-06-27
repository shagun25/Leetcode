class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] < b[2]) ? 1 : -1);
        for(int i = 0; i < nums1.length; i++)
        {

            for(int j = 0; j < nums2.length; j++)
            {
                int currSum = nums1[i] + nums2[j];
                if(pq.size() < k)
                    pq.add(new int[]{nums1[i], nums2[j], currSum});
                else 
                {
                    if(currSum < pq.peek()[2])
                    {
                        pq.remove();
                        pq.add(new int[]{nums1[i], nums2[j], currSum});
                    }
                    else break;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while(!pq.isEmpty())
        {
            int temp[] = pq.remove();
            List<Integer> list = new ArrayList<>();
            list.add(temp[0]);
            list.add(temp[1]);
            ans.add(list);
        }
        return ans;
    }
}