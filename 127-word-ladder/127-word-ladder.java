class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level=1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                String curr = queue.poll();
                if(curr.equals(endWord)) return level;
                for(int i=0;i<curr.length();i++){
                    for(char c='a';c<='z';c++){
                        char temp[] = curr.toCharArray();
                        temp[i]=(char)c;
                        String str = new String(temp);
                        if(set.contains(str)){
                            queue.add(str);
                            set.remove(str);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}