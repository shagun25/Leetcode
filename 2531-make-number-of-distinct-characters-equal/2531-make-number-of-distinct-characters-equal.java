class Solution {
    public boolean isItPossible(String word1, String word2) {
      int[] v1 = new int[26];
        int[] v2 = new int[26];
        Arrays.fill(v1, 0);
        Arrays.fill(v2, 0);
        for (int i = 0; i < word1.length(); i++) {
            v1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            v2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (v1[i] > 0 && v2[j] > 0) {
                    v1[i]--;
                    v2[j]--;
                    v2[i]++;
                    v1[j]++;
                    int cnt1 = 0;
                    int cnt2 = 0;
                    for (int k = 0; k < 26; k++) {
                        if (v1[k] >= 1) {
                            cnt1++;
                        }
                        if (v2[k] >= 1) {
                            cnt2++;
                        }
                    }
                    if (cnt1 == cnt2) {
                        return true;
                    }
                    v1[i]++;
                    v2[j]++;
                    v2[i]--;
                    v1[j]--;
                }
            }
        }
        return false;
    }
    
}