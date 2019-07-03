package sample.model;

public class Node {

    private Player current;
    private Node next;

    public Node (Player current) {
        this(current, null);
    }

    public Node(Player current, Node next) {
        this.current = current;
        this.next = next;
    }

    public Player getPlayer() {
        return current;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public Node getNext() { return next; }
}
