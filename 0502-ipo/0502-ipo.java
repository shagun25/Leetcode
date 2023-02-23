class Solution {
    class Project implements Comparable<Project>{
    int profit;
    int capital;
    Project(int capital, int profit){
        this.profit = profit;
        this.capital = capital;
    }
    public int compareTo(Project project){
        return capital-project.capital;
    }
}
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        
        Project[] projects = new Project[n];
        for(int i=0;i<n;i++){
            projects[i]=new Project(capital[i],profits[i]);
        }
        Arrays.sort(projects);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n,Collections.reverseOrder());
        int ptr=0;
        for(int i=0;i<k;i++){
            //add in pq all the available projects.
            while(ptr<n && projects[ptr].capital<=w){
                pq.add(projects[ptr++].profit);
            }
            if(pq.isEmpty()) break;
            w+=pq.poll();
        }
        return w;
    }
}