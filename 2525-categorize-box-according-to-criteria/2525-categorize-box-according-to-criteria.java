class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
 
        int bulky=0,heavy=0;
        if(length>=10000 || width>=10000 || height>=10000 || length*width>=(1000000000/height)) bulky=1;
        if(mass>=100) heavy=1;
        
        if(bulky==1 && heavy==1) return "Both";
        if(bulky==0 && heavy==0) return "Neither";
        if(bulky==1 && heavy==0) return "Bulky";
        if(bulky==0 && heavy==1) return "Heavy";  
        return "Neither";
    }
}