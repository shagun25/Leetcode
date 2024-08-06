public class Solution {

    public int minimumPushes(String word) {
        // Frequency array to store count of each letter
        int[] frequency = new int[26];

        // Count occurrences of each letter
        for (char c : word.toCharArray()) {
            frequency[c - 'a']++;
        }

        // Sort frequencies in descending order
        Arrays.sort(frequency);

        /*
        // Or do like this 
        // Sort frequencies in descending order
        Integer[] sortedFrequency = Arrays.stream(frequency).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedFrequency, (a, b) -> b - a);
        */

        int totalPushes = 0;

        // Calculate total number of presses
        int index=0;
        for (int i = 25; i >=0; i--) {
            if (frequency[i] == 0) break;
            totalPushes += (index / 8 + 1) * frequency[i];
            index++;
        }

        return totalPushes;
    }
}