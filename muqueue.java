package mylinkedlist;

import java.util.*;

public class muqueue<E> implements MyQeuo<E> {

    MyLinkedList1<E> Queue = new MyLinkedList1<>();

    @Override
    public void enqueue(E r) {
        Queue.addLast(r);
    }

    @Override
    public void printQ() {
        Queue.print();
    }

    public Comparable findMax(muqueue Q) {
        MyQeuo<Integer> Qnew = new muqueue();
        int max = (Integer) Q.peek();
        Qnew.enqueue((Integer) Q.dequeue());
        while (!Q.isempty()) {
            int y = (Integer) Q.peek();
            if (y > max) {
                max = y;
            }
            Qnew.enqueue((Integer) Q.dequeue());
        }
        while (!Qnew.isempty()) {
            Q.enqueue((Integer) Qnew.dequeue());
        }
        return max;
    }

    @Override
    public boolean Offer(E a) {
        return Queue.Offer(a);
    }

    @Override
    public E dequeue() {
        return Queue.removeFirst();

    }

    public E poll() {
        return Queue.removeFirst();
    }

    public E element() {
        return Queue.element();
    }

    public E peek() {
        return Queue.peek();
    }

    @Override
    public int sizeMyQ() {
        return Queue.size();
    }

    @Override
    public boolean isempty() {
        return Queue.size() == 0;
    }

    public static int SumOfEven(muqueue<Integer> q) {
        if (q.sizeMyQ() == 0) {
            return 0;
        }
        if (q.peek() % 2 == 0) {
            return q.poll() + SumOfEven(q);
        } else {
            q.poll();
        }
        return SumOfEven(q);

    }

}
