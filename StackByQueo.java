package mylinkedlist;

public class StackByQueo<E> {

    private final muqueue<E> Qeuo = new muqueue<>();

    public void puch(E y) {
        Qeuo.enqueue(y);
    }

    public int size() {
        return Qeuo.sizeMyQ();
    }

    public boolean isimpty() {
        return Qeuo.isempty();
    }

    public E pop() {
        MyStack<E> Stack1 = new MyStack<>();
        while (!(Qeuo.isempty())) {
            Stack1.puch(Qeuo.poll());
        }
        E r = Stack1.pop();
        MyStack<E> Stack2 = new MyStack<>();
        while (Stack1.size() != 0) {
            Stack1.puch(Stack2.pop());
        }
        while (Stack2.size() != 0) {
            Qeuo.enqueue(Stack2.pop());
        }

        return r;
    }

    public void Printsq() {
        Qeuo.printQ();
    }
}
