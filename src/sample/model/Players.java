package sample.model;

import java.util.*;

public class Players implements List<Node> {

    Node head;
    Node tail;

    int numPlayers;
    int currentPlayer;

    public Players(int numPlayers) {

        this.numPlayers = numPlayers;
        for (int i=0; i < numPlayers; i++) {
            Player player = new Player(i);
            Node newNode = new Node(player, null);
            this.add(newNode);
        }
        this.currentPlayer = 0;
    }

    @Override
    public int size() {
        return numPlayers;
    }

    @Override
    public boolean isEmpty() {
        return numPlayers == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Node node) {
        if (this.head == null) {
            head = node;
        }
        if (this.tail == null) {
            tail = node;
        }
        if (currentPlayer == 1) {
            head.setNext(node);
            node.setNext(head);
            tail = node;
        }
        if (currentPlayer > 1) {
            tail.setNext(node);
            node.setNext(head);
            tail = node;
        }

        currentPlayer = (currentPlayer++) % numPlayers; //keeps currentPlayer within bounds
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Node get(int index) {
        if (index >= numPlayers) {
            throw new IndexOutOfBoundsException(String.format("Index %d is greater than Number of Players: %d", index, numPlayers));
        }
        Node temp = head;
        int i = 0;
        while (i < index) {
            temp = temp.next;
            i++;
        }

        return temp;
    }

    @Override
    public Node set(int index, Node element) {
        return null;
    }

    @Override
    public void add(int index, Node element) {

    }

    public Player getCurrentPlayer() {
        return this.get(currentPlayer).getPlayer();
    }

    @Override
    public Node remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
