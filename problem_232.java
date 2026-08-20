class MyQueue {
    Stack<Integer> st=new Stack<>();
    Stack<Integer> helper=new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        while(st.size()>1) helper.add(st.pop());
        int x=st.pop();
        while(!helper.isEmpty()) st.add(helper.pop());
        return x;
    }
    
    public int peek() {
        while(st.size()>1) helper.add(st.pop());
        int x=st.peek();
        while(!helper.isEmpty()) st.add(helper.pop());
        return x;
    }
    
    public boolean empty() {
        return (st.size()==0);
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
