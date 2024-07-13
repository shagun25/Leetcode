class Solution {
    static class Robot{
    int health;
    char dir;
    int pos;
    int inputInd;
    Robot(int health, char dir, int pos, int inputInd) {
        this.health = health;
        this.dir = dir;
        this.pos = pos;
        this.inputInd = inputInd;
    }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        ArrayList<Robot> roboList = new ArrayList<>();
        for(int i=0;i<positions.length;i++){
            roboList.add(new Robot(healths[i],directions.charAt(i),positions[i],i));
        }
        roboList.sort((a,b)->(a.pos-b.pos));
        Stack<Robot> st = new Stack<>();
        for(int i=0;i<roboList.size();i++){
            Robot r = roboList.get(i);
            if(r.dir == 'R'){
                st.push(r);
            }else{
                while(!st.isEmpty() && st.peek().health<r.health && st.peek().dir=='R'){
                    st.pop();
                    r.health--;
                }
                if(!st.isEmpty() && st.peek().health>r.health && st.peek().dir=='R'){
                    Robot robo = st.pop();
                    robo.health--;
                    st.push(robo);
                }else if(!st.isEmpty() && st.peek().health==r.health && st.peek().dir=='R'){
                     st.pop();
                }else{
                    st.push(r);
                }
            }
        }
        st.sort((a,b)->a.inputInd-b.inputInd);
        List<Integer> ans = new ArrayList<>();
        for(Robot r : st){
            ans.add(r.health);
        }
        return ans;
    }
}
