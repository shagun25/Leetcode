class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        double sum =0;
        int min = Integer.MAX_VALUE,max= Integer.MIN_VALUE;
        for(int sal : salary){
            min = Math.min(min,sal);
            max = Math.max(max,sal);
            sum+=sal;
        }
        return (sum-(min+max))/(n-2);
    }
}