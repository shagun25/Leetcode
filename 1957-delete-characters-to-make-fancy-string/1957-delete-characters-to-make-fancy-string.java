class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        int j=0;
        for(int i=0;i<s.length();){
            if(i>0 && j>0 && s.charAt(i)!=str.charAt(j-1)) {
                str.append(s.charAt(i));
                i++;
                  j++;
            }else if(i>0 && j>1 && s.charAt(i)==str.charAt(j-1)  && s.charAt(i)!=str.charAt(j-2)) {
                   str.append(s.charAt(i));
                 i++;
                  j++;
            }else if(i>0 && j>1 && s.charAt(i)==str.charAt(j-1) && s.charAt(i)==str.charAt(j-2)) {
                 i++;
            }else{
                 str.append(s.charAt(i));
                j++;
                i++;
            }
        }
        return str.toString();
    }
}
// leeetcode
//          i
// leetcode
//         j