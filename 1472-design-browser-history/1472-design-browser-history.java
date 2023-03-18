class BrowserHistory {
    ArrayList<String> visitedURl;
    int currUrl,lastURL;
    public BrowserHistory(String homepage) {
        visitedURl = new  ArrayList<String>(Arrays.asList(homepage));
        currUrl=0;
        lastURL=0;
    }
    
    public void visit(String url) {
        currUrl+=1;
        if(visitedURl.size()>currUrl){
            visitedURl.set(currUrl,url);
        }else{
            visitedURl.add(url);
        }
        lastURL = currUrl;
    }
    
    public String back(int steps) {
        currUrl = Math.max(0,currUrl-steps);
        return visitedURl.get(currUrl);
    }
    
    public String forward(int steps) {
        currUrl = Math.min(lastURL,currUrl+steps);
        return visitedURl.get(currUrl);
    }
}
// Let's assume here, n visit calls are made, m is the maximum number of steps to go forward or back, and l is the maximum length of a URL string.
// Time complexity:
// visit(url) ->   insert and update O(1)
// back(steps) and forward(steps) -> O(1) time.
// Space complexity:  O(l⋅n) space.
     
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */