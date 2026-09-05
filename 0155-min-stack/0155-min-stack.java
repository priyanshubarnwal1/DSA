class MinStack {

    private Stack<Long> st;
    private long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {

        long val = value;

        if (st.isEmpty()) {
            min = val;
            st.push(val);
            return;
        }

        if (val > min) {
            st.push(val);
        } else {
            st.push(2L * val - min);
            min = val;
        }
    }

    public void pop() {

        if (st.isEmpty()) return;

        long x = st.pop();

        if (x < min) {
            min = 2L * min - x;
        }
    }

    public int top() {

        long x = st.peek();

        if (x > min) {
            return (int) x;
        }

        return (int) min;
    }

    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */