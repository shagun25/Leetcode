class Solution {
    public int titleToNumber(String columnTitle) {
        int res=0;
        for(int i=0;i<columnTitle.length();i++){
            char ch = columnTitle.charAt(i);
            res=res*26+(ch-'A'+1);
        }
        
        return res;
    }
}