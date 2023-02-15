class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int carry=0;
        for(int i=num.length-1;i>=0;i--){
            if(k>0){
                int a = k%10;
                carry+=num[i]+a;
                res.add(carry%10);
                carry=carry/10;
                k=k/10;
            }else{
                carry+=num[i];
                res.add(carry%10);
                carry=carry/10;
            }
        }
        while(k>0){
            int a = k%10;
            carry+=a;
            res.add(carry%10);
            carry=carry/10;
            k=k/10;
        }
        if(carry>0) res.add(carry);
        Collections.reverse(res);
        return res;
    }
}