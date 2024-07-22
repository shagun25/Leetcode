class Solution {

    public String[] sortPeople(String[] names, int[] heights) {
        int numberOfPeople = names.length;

        Integer[] sortedIndices = new Integer[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            sortedIndices[i] = i;
        }

        Arrays.sort(sortedIndices, (a, b) -> heights[b] - heights[a]);


        String[] sortedNames = new String[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            sortedNames[i] = names[sortedIndices[i]];
        }

        return sortedNames;
    }
}