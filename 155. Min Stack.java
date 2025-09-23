class MinStack {
    private ListNode mainStack = null;
    private ListNode minStack = null;

    public MinStack() {
        
    }
    
    public void push(int val) {
        mainStack = new ListNode(val, mainStack);

        if (minStack == null || val <= minStack.val) {
            minStack = new ListNode(val, minStack);
        }
    }
    
    public void pop() {
        var removed = mainStack.val;
        mainStack = mainStack.next;

        if (removed == minStack.val) {
            minStack = minStack.next;
        }
    }
    
    public int top() {
        return mainStack.val;
    }
    
    public int getMin() {
        return minStack.val;
    }
}