class Solution {
    public String reverseWords(String s) {
         String[] words = s.trim().split(" +");
        //s.split(" +") takes into account more than one space and gives the output as [the, sky, is, blue]
         Collections.reverse(Arrays.asList(words));
       return String.join(" ", words);
    }
}