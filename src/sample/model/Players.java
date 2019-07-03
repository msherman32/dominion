package sample.model;

import java.util.*;

public class Players implements List<Node> {

    private Node head;
    private Node tail;
    private int size;

    private int numPlayers;
    private int currentPlayer;

    public Players(int numPlayers) {
        this.numPlayers = numPlayers;
        for (int i=0; i < numPlayers; i++) {
            Player player = new Player(i);
            Node newNode = new Node(player, null);
            this.add(newNode);
        }
        this.currentPlayer = 0;
    }

    public Player getCurrentPlayer() {
        return this.get(currentPlayer).getPlayer();
    }

    public Player getNextPlayer() {
        currentPlayer = ((currentPlayer++) % numPlayers); //go to next player within bounds
        return this.getCurrentPlayer();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
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
        if (size == 0) {
            if (this.head == null) {
                head = node;
            }
            if (this.tail == null) {
                tail = node;
            }
        }
        if (size == 1) {
            head.setNext(node);
            node.setNext(head);
            tail = node;
        }
        if (size > 1) {
            tail.setNext(node);
            node.setNext(head);
            tail = node;
        }

        size++;
        return true;
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
        if (index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d is outside range: [0,%d]", index, size));
        }
        if (index == size - 1){
            return tail;
        }
        if (size == 0) {
            return head;
        }
        Node temp = head;
        int i = 0;
        while (i < index) {
            temp = temp.getNext();
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
