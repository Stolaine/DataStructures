package linear.linkedList;

public class LinkedList {
    public Node head;

    public LinkedList() {
        head = null;
    }

    // insert at last
    // insert at first
    // insert at particular position
    // insert after or before particular data
    public void add(int data) {
        Node temp = new Node(data);

        // 1 2 3 null
        // 4
        // 1 2 3 null
        if (head == null) {
            head = temp;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
    }

    public String toString() {
        return "" + this.head;
    }
}

/*

1 2
3 4
5 6
7 8
9 10

// number of rows
// number of columns
// lines = number rows
// in each line elements = number of columns


4 5
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20

int row = sc.nextInt(); // 4
int col = sc.nextInt(); // 5
int[] arr = new int[row][col];
for (int i=0; i<row; i++) {
    for (int j=0; j<col; j++) {
        arr[i][j] = sc.nextInt();
    }
}













* */
