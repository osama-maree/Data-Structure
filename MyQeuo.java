
package mylinkedlist;

public interface MyQeuo<E> {

    public abstract void enqueue(E a);

    public abstract boolean Offer(E a);

    public abstract E dequeue();
    public abstract E poll();
    public abstract boolean isempty(); 
    public abstract E element();
    public abstract int sizeMyQ(); 
    public abstract E peek();
    public abstract void printQ();
}