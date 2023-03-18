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

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */