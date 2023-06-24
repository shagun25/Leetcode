class Solution {
    public int tallestBillboard(int[] rods) {
        return solve(rods, 0, 0, new HashMap<>());
    }

    int solve(int[] roads, int ind, int diff, HashMap<String, Integer> map){
        if(ind == roads.length){
            if(diff == 0) return 0;
            else return Integer.MIN_VALUE;
        }

        String key = ind + "+" + diff;

        if(map.containsKey(key)) return map.get(key);

        int exc = solve(roads, ind+1, diff, map);

        int taller = solve(roads, ind+1, diff + roads[ind], map) + roads[ind]; // inc current road as taller
        int smaller = solve(roads, ind+1, diff - roads[ind], map); // inc current road as shorter

        int ans = Math.max(exc, Math.max(taller, smaller));
        map.put(key, ans);
        return ans;
    }
}