package nonLinear.tree;

public class Heap {
    int capacity;
    int[] heap;
    int index;
    int min;
    int max;

    public Heap(int capacity) {
        this.index = -1;
        this.capacity = capacity;
        heap = new int[capacity];
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
    }

    public boolean add(int data) {
        if (index>=capacity) {
            return false;
        }
        heap[++index] = data;
        return true;
    }

    public void minify() {
        for (int i=0; i<=index; i++) {
            int node = heap[i];
            int left = heap[i*2];
            int right = heap[(i*2)+1];
        }
    }
}
