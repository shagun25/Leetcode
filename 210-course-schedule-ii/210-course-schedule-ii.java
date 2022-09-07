class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       ArrayList<Integer> adjList[] = new ArrayList[numCourses];
        int degree[] = new int[numCourses];
        for(int prerequisite[] : prerequisites){
            int u = prerequisite[1],v = prerequisite[0]; 
            if(adjList[u]==null) adjList[u] = new ArrayList<Integer>();
            adjList[u].add(v);
            degree[v]++;
        }
          
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(degree[i]==0) q.add(i);
        }
        int[] res = new int[numCourses];
        int i=0;
        while(!q.isEmpty()){
            int v = q.poll();
            res[i++]=v;
            if(adjList[v]==null) continue;
            for(int u: adjList[v]){
                degree[u]--;
                if(degree[u]==0) q.add(u);
            }
        }
        return i==numCourses?res:new int[0];
    }
}