class MyStack {
    Queue<Integer> q;
    boolean reversed;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        for(int i=0; i<q.size()-1; i++) {
            int s = q.poll();
            q.add(s);
        }
        return q.poll();
    }
    
    public int top() {
        if(q.isEmpty()) return -1;
        for(int i=0; i<q.size()-1; i++) {
            int s = q.poll();
            q.add(s);
        }
        int result = q.poll();
        q.add(result);
        return result;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */