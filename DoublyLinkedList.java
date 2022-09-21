package mylinkedlist;

import java.util.*;

public class DoublyLinkedList<E> {

    class Node<E> {

        E item;
        Node previous;
        Node next;

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node(E item) {
            this.item = item;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
    Node<E> head = null, tail = null;
    int length;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(E Objects[]) {
        for (int i = 0; i < Objects.length; i++) {
            addLast((Objects[i]));
        }
    }

    public void addfirst(E r) {
        Node<E> l = new Node<>(r);
        if (head == null) {
            head = tail = l;
            l.previous = null;
            l.next = null;
            length++;
        } else {
            l.next = head;
            l.previous = null;
            head.previous = l;
            head = l;
            length++;
        }

    }

    public void addLast(E item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
            newNode.previous = null;
            newNode.next = null;
            length++;
        } else {
            newNode.next = null;
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
            length++;
        }
    }

    public void printrev() {
        Node t = tail;
        while (t != null) {
            System.out.print(t.item + "\t");
            t = t.previous;
        }
    }

    public boolean addByindex(E item, int i) {
        Node T = new Node<>(item);
        if (i < 0) {
            return false;
        } else if (i == 0) {
            this.addfirst(item);
        } else if (i >= length) {
            this.addLast(item);
        } else {
            Node c = head;
            for (int p = 1; p < i; p++) {
                c = c.next;
            }
            T.next = c.next;
            T.previous = c;
            c.next = T;
            c.next.previous = T;
            length++;
        }
        return true;
    }

    public E removefirst() {
        if (length == 1) {
            E p = head.item;
            tail = head = null;
            length = 0;
            return p;
        } else {
            E p = head.item;
            head = head.next;
            head.previous = null;
            length--;
            return p;
        }
    }

    public E removeLast() {
        if (length == 1) {
            E p = head.item;
            tail = head = null;
            length = 0;
            return p;
        } else {
            E p = tail.item;
            tail = tail.previous;
            tail.next = null;
            length--;
            return p;
        }
    }

    public void removeByindex(int i) {
        if (i < 0 || length == 0) {
            throw new UnsupportedOperationException("lenked is empty");
        } else if (i == 0) {
            this.removefirst();
        } else if (i >= length) {
            this.removeLast();
        } else {
            Node c = head;
            for (int p = 0; p < i - 1; p++) {
                c = c.next;
            }
            E p = (E) c.item;
            Node T = c.next.next;
            T.previous = c;
            c.next = T;
            length--;

        }

    }

    public void printNodes() {
        Node current = head;
        if (head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> p = new DoublyLinkedList<>();
        Scanner s = new Scanner(System.in);
      p.addfirst(5);
      p.addLast(4);
        p.printNodes();
    }
}
