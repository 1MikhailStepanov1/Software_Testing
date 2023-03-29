package lab1.secondTask;

public class FibonacciHeap {
    public FibonacciHeapNode min;
    int n;
    boolean trace;
    FibonacciHeapNode found;


    public static FibonacciHeap create_heap() {
        return new FibonacciHeap();
    }

    FibonacciHeap() {
        min = null;
        n = 0;
        trace = false;
    }

    private void insert(FibonacciHeapNode x) {
        if (min == null) {
            min = x;
            x.set_left(min);
            x.set_right(min);
        } else {
            x.set_right(min);
            x.set_left(min.get_left());
            min.get_left().set_right(x);
            min.set_left(x);
            if (x.get_key() < min.get_key())
                min = x;
        }
        n += 1;
    }

    public void insert(int key) {
        insert(new FibonacciHeapNode(key));
    }

    public StringBuilder display(StringBuilder result) {
        return display(min, result);
    }

    private StringBuilder display(FibonacciHeapNode c, StringBuilder result) {
        result = result.append("(");
        if (c == null) {
            result = result.append(")");
            return null;
        } else {
            FibonacciHeapNode temp = c;
            do {
                result = result.append(temp.get_key());
                FibonacciHeapNode k = temp.get_child();
                display(k, result);
                result = result.append("->");
                temp = temp.get_right();
            } while (temp != c);
            result = result.append(")");
        }
        return result;
    }

    public static void merge_heap(FibonacciHeap H1, FibonacciHeap H2, FibonacciHeap H3) {
        H3.min = H1.min;
        if (H1.min != null && H2.min != null) {
            FibonacciHeapNode t1 = H1.min.get_left();
            FibonacciHeapNode t2 = H2.min.get_left();
            H1.min.set_left(t2);
            t1.set_right(H2.min);
            H2.min.set_left(t1);
            t2.set_right(H1.min);
        }
        if (H1.min == null || (H2.min != null && H2.min.get_key() < H1.min.get_key()))
            H3.min = H2.min;
        H3.n = H1.n + H2.n;
    }

    public int extract_min() {
        FibonacciHeapNode z = this.min;
        if (z != null) {
            FibonacciHeapNode c = z.get_child();
            FibonacciHeapNode k = c, p;
            if (c != null) {
                do {
                    p = c.get_right();
                    insert(c);
                    c.set_parent(null);
                    c = p;
                } while (c != null && c != k);
            }
            z.get_left().set_right(z.get_right());
            z.get_right().set_left(z.get_left());
            z.set_child(null);
            if (z == z.get_right())
                this.min = null;
            else
            {
                this.min = z.get_right();
                this.consolidate();
            }
            this.n -= 1;
            return z.get_key();
        }
        return Integer.MAX_VALUE;
    }

    public void consolidate() {
        double phi = (1 + Math.sqrt(5)) / 2;
        int Dofn = (int) (Math.log(this.n) / Math.log(phi));
        FibonacciHeapNode[] A = new FibonacciHeapNode[Dofn + 1];
        for (int i = 0; i <= Dofn; ++i)
            A[i] = null;
        FibonacciHeapNode w = min;
        if (w != null) {
            FibonacciHeapNode check = min;
            do {
                FibonacciHeapNode x = w;
                int d = x.get_degree();
                while (A[d] != null) {
                    FibonacciHeapNode y = A[d];
                    if (x.get_key() > y.get_key()) {
                        FibonacciHeapNode temp = x;
                        x = y;
                        y = temp;
                        w = x;
                    }
                    fib_heap_link(y, x);
                    check = x;
                    A[d] = null;
                    d += 1;
                }
                A[d] = x;
                w = w.get_right();
            } while (w != null && w != check);
            this.min = null;
            for (int i = 0; i <= Dofn; ++i) {
                if (A[i] != null) {
                    insert(A[i]);
                }
            }
        }
    }

    // Linking operation
    private void fib_heap_link(FibonacciHeapNode y, FibonacciHeapNode x) {
        y.get_left().set_right(y.get_right());
        y.get_right().set_left(y.get_left());

        FibonacciHeapNode p = x.get_child();
        if (p == null) {
            y.set_right(y);
            y.set_left(y);
        } else {
            y.set_right(p);
            y.set_left(p.get_left());
            p.get_left().set_right(y);
            p.set_left(y);
        }
        y.set_parent(x);
        x.set_child(y);
        x.set_degree(x.get_degree() + 1);
        y.set_mark(false);
    }

    // Search operation
    private void find(int key, FibonacciHeapNode c) {
        if (found != null || c == null)
            return;
        else {
            FibonacciHeapNode temp = c;
            do {
                if (key == temp.get_key())
                    found = temp;
                else {
                    FibonacciHeapNode k = temp.get_child();
                    find(key, k);
                    temp = temp.get_right();
                }
            } while (temp != c && found == null);
        }
    }

    public FibonacciHeapNode find(int k) {
        found = null;
        find(k, this.min);
        return found;
    }


    
}