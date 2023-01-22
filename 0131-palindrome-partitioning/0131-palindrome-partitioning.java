class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
    solve(s,new ArrayList<String>(),0);
        return result;
    }
    
    void solve(String s,List<String> temp,int i){
        if(i==s.length()) result.add(new ArrayList<String>(temp));
  
        for(int k=i;k<=s.length()-1;k++){
            if(isPalingdrome(s,i,k)){
                temp.add(s.substring(i,k+1));
                solve(s,temp,k+1);
                temp.remove(temp.size()-1);
            }
        }
      
    }
    boolean isPalingdrome(String s, int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}