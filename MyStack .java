class MyStack {
    
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;

    /** Initialize your data structure here. */
    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(!qu1.isEmpty()){
            qu1.offer(x);
        } else if(!qu2.isEmpty()){
            qu2.offer(x);
        } else {
            qu1.offer(x);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (this.empty()){
            return -1;
        }
        int size = qu1.isEmpty() ? qu2.size() : qu1.size();
        if (qu1.isEmpty()){
            for (int i = 0; i < size-1; i++) {
                qu1.offer(qu2.poll());
            }
            return qu2.poll();
        } else {
            for (int i = 0; i < size-1; i++) {
                qu2.offer(qu1.poll());
            }
            return qu1.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        if (this.empty()){
            return -1;
        }
        int tmp = -1;
        //切记要先求出size，循环中执行poll()会改变size大小
        int size = qu1.isEmpty() ? qu2.size() : qu1.size();
        if (qu1.isEmpty()){
            for (int i = 0; i < size; i++) {
                tmp = qu2.poll();
                qu1.offer(tmp);
            }
        } else {
            for (int i = 0; i < size; i++) {
                tmp = qu1.poll();
                qu2.offer(tmp);
            }
        }
        return tmp;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
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