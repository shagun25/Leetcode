class Solution {
    class Node{
        String key;
        double val;
        Node(String key, double val){
            this.key=key;
            this.val=val;
        }
    }
    public double dfs(String src,String dest,Map<String,List<Node>> graph,HashSet<String> vis){
        if(!(graph.containsKey(src) && graph.containsKey(dest))) return -1.0;
        if(src.equals(dest)) return 1.0;
        vis.add(src);
        double ans=0;
        for(Node ng : graph.get(src)){
            if(!vis.contains(ng.key)){
                ans = dfs(ng.key,dest,graph,vis);
                if(ans!=-1.0) return ans*ng.val;
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Node>> graph = buildGraph(equations,values);
        double res[] = new double[queries.size()];
         int i=0;
        for(List<String> q : queries){
            String a = q.get(0);
            String b = q.get(1);
            res[i++] = dfs(a,b,graph, new HashSet<>());
        }
        return res;
    }
    public Map<String,List<Node>> buildGraph(List<List<String>> equations, double[] values){
        Map<String,List<Node>> map = new HashMap<>();
        int i=0;
        for(List<String> eq : equations){
            String a = eq.get(0);
            String b = eq.get(1);
            map.putIfAbsent(a,new ArrayList<Node>());
            map.putIfAbsent(b,new ArrayList<Node>());
            map.get(a).add(new Node(b,values[i]));
            map.get(b).add(new Node(a,1/values[i++]));
        }
        return map;
    }
}