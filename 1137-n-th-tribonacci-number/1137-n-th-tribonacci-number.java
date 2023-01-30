class Solution {
    public int tribonacci(int n) {
     int T0=0,T1=1,T2=1;
        if(n==0) return T0;
        if(n==1) return T1;
        if(n==2) return T2;
     for(int i=3;i<=n;i++){
         int x = T0;
         T0=T1;
         T1=T2;
         T2=x+T0+T1;
     }
     return T2;
    }
}