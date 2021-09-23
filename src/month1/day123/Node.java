package month1.day123;

class Node<T> {
    Node<T> next;
    T data;

    public Node(T data, Node<T> top) {
        this.data = data;
        this.next = top;
    }

    public Node(T data) {
        this.data = data;
    }

    public Node() {
    }
}