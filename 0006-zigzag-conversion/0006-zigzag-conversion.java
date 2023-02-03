class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        
        List<StringBuilder> res = new ArrayList<>();
        for(int i=0;i<Math.min(s.length(),numRows);i++){
            res.add(new StringBuilder());
        }
        
        int currRow = 0;
        boolean direction = false;
        for(int i=0;i<s.length();i++){
            if(currRow==0 || currRow==numRows-1) direction=!direction;
            res.get(currRow).append(s.charAt(i));
            currRow+=direction?1:-1;
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<Math.min(s.length(),numRows);i++){
            result.append(res.get(i));
        }
        return result.toString();
    }
}