class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String> initialGroup[] = new HashSet[26];
        for(int i=0;i<26;i++){
            initialGroup[i] = new HashSet<>();
        }
        for(String idea : ideas){
            initialGroup[idea.charAt(0)-'a'].add(idea.substring(1));
        }
        long res=0;
        for(int i=0;i<25;i++){
            for(int j=i+1;j<26;j++){
                long noMutual=0;
                for(String idea : initialGroup[i]){
                    if(initialGroup[j].contains(idea)) noMutual++;
                }
                res+=2*(initialGroup[i].size()-noMutual)*(initialGroup[j].size()-noMutual);
            }
        }
        return res;
    }
}