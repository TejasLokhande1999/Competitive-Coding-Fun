class MyCircularDeque {

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head, tail; // Head = front, Tail = rear
    private int size, capacity;

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;

        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
            head.next = head.prev = head; // circular
        } else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            head = newNode;
        }

        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;

        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
            head.next = head.prev = head;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }

        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }

        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }

        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : head.data;
    }

    public int getRear() {
        return isEmpty() ? -1 : tail.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
