class DLLNode{
    String data;
    DLLNode next,prev;
    DLLNode(String url){
        this.data=url;
        next=null;
        prev=null;
    }
}
class BrowserHistory {
    DLLNode linkedListHead, current;
    public BrowserHistory(String homepage) {
        linkedListHead = new DLLNode(homepage);
        current = linkedListHead;
    }
    
    public void visit(String url) {
        DLLNode node = new DLLNode(url);
        current.next=node;
        node.prev=current;
        current=node;
    }
    
    public String back(int steps) {
        while(steps>0 && current.prev!=null){
            current=current.prev;
            steps--;
        }
        return current.data;
    }
    
    public String forward(int steps) {
        while(steps>0 && current.next!=null){
            current=current.next;
            steps--;
        }
        return current.data;
    }
}

// Let's assume here, n visit calls are made, m is the maximum number of steps to go forward or back, and l is the maximum length of a URL string.

// Time complexity:

// visit(url) t will take O(l) time to create a new node(to allocate memory for l characters of the url string), and then we mark this new node as current which will take O(1) time.
// worst case each call to the visit(url) method will take O(l) time.
    
// back(steps) and forward(steps)
//     in the worst case, each call to these methods will take O(min(m,n)) time.

// Space complexity: O(l⋅n)
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */