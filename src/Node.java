public class Node<T> {
    T data;
    Node<T> next = null;

    public Node(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);

        Node head = node1;
        node1.next = node2;

    }
}
