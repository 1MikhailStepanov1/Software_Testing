package lab1.secondTask;

public class FibonacciHeapNode {
    FibonacciHeapNode parent;
    FibonacciHeapNode left;
    FibonacciHeapNode right;
    FibonacciHeapNode child;
    int degree;
    boolean mark;
    public int key;

    public FibonacciHeapNode() {
        this.degree = 0;
        this.mark = false;
        this.parent = null;
        this.left = this;
        this.right = this;
        this.child = null;
        this.key = Integer.MAX_VALUE;
    }

    FibonacciHeapNode(int x) {
        this();
        this.key = x;
    }

    void set_parent(FibonacciHeapNode x) {
        this.parent = x;
    }

    void set_left(FibonacciHeapNode x) {
        this.left = x;
    }

    FibonacciHeapNode get_left() {
        return this.left;
    }

    void set_right(FibonacciHeapNode x) {
        this.right = x;
    }

    FibonacciHeapNode get_right() {
        return this.right;
    }

    void set_child(FibonacciHeapNode x) {
        this.child = x;
    }

    FibonacciHeapNode get_child() {
        return this.child;
    }

    void set_degree(int x) {
        this.degree = x;
    }

    int get_degree() {
        return this.degree;
    }

    void set_mark(boolean m) {
        this.mark = m;
    }

    int get_key() {
        return this.key;
    }
}