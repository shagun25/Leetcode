class Solution {
    public String compressedString(String word) {
        char ch = word.charAt(0), count=1;
        String str = "";
       for(int i=1;i<word.length();i++){
           if(count==9){
               str+=Integer.toString(count);
               str+=ch;
               count=1;
               ch=word.charAt(i);
           }
           else if(ch==word.charAt(i)){
               count++;
           }else{
               str+=Integer.toString(count);
               str+=ch;
               ch=word.charAt(i);
               count=1;
           }
       } 
        str+=Integer.toString(count);
        str+=ch;
        return str;
    }
}