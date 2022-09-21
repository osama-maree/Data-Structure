package arraylist;

public class Node<E> {

    Node<E> next;
    E element;

    public Node(E e) {
        this.element = e;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

}
