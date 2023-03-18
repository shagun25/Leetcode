class BrowserHistory {
    Stack<String> history,future;
    String current;
    public BrowserHistory(String homepage) {
        history= new Stack<>();
        future = new Stack<>();
        current = homepage;
    }
    
    public void visit(String url) {
        history.push(current);
        current=url;
        future = new Stack<>();
    }
    
    public String back(int steps) {
        while(steps>0 && !history.isEmpty()){
            future.push(current);
            current = history.pop();
            steps--;
        }
        return current;
    }
    
    public String forward(int steps) {
        while(steps>0 && !future.isEmpty()){
            history.push(current);
            current = future.pop();
            steps--;
        }
        return current;
    }
}
// Let's assume here, n visit calls are made, m is the maximum number of steps to go forward or back, and l is the maximum length of the URL string.
// Time complexity: 
// visit(url) 
//     in the worst case each call to the visit(url) method will take O(1) time.
// back(steps) and forward(steps)
//     in the worst case, each call to these methods will take O(min(m,n)) time.

// Space complexity: n the worse case, we use O(l⋅n) space.

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */