class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        int j=0;
        for(int i=0;i<s.length();i++){
            if(i>0 && j>1 && s.charAt(i)==str.charAt(j-1) && s.charAt(i)==str.charAt(j-2)) {
               continue;
            }else{
                str.append(s.charAt(i));
                j++;
            }
        }
        return str.toString();
    }
}
// leeetcode
//          i
// leetcode
//         j