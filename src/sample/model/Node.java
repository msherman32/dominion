package sample.model;

public class Node {

    Player current;
    Node next;

    public Node(Player current, Node next) {
        this.current = current;
        this.next = next;
    }

    public Player getPlayer() {
        return current;
    }

    public void setNext(Node node) {
        next = node;
    }
}
