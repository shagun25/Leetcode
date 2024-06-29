class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        // Initialize the list with empty ArrayLists
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        // Populate the adjacency list from edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            list.get(to).add(from);
        }

        // Compute ancestors using BFS with TreeSet
        List<List<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            TreeSet<Integer> ancestorSet = new TreeSet<>();
            bfs(i, list, ancestorSet);
            ancestors.add(new ArrayList<>(ancestorSet));
        }

        return ancestors;
    }

    private void bfs(int node, List<List<Integer>> list, TreeSet<Integer> ancestorSet) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int parent : list.get(current)) {
                if (!ancestorSet.contains(parent)) {
                    ancestorSet.add(parent);
                    queue.offer(parent);
                }
            }
        }
    }
}