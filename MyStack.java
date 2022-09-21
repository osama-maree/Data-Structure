
public class MyStack<E> {

    private final ArraListO<E> List = new ArraListO<>();

    public MyStack() {
    }

    public MyStack mergeStack(MyStack A, MyStack B) {
        MyStack<Integer> merege = new MyStack();
        for (int i = 0; i < A.sizestack(); i++) {
            merege.puch((Integer) A.pop());
        }
        for (int i = 0; i < B.sizestack(); i++) {
            merege.puch((Integer) B.pop());
        }
        MyStack<Integer> newStackSort = new MyStack();

        while (!merege.isEmpty()) {
            int tmp = merege.pop();

            while (!newStackSort.isEmpty() && newStackSort.peek() > tmp) {
                merege.puch(newStackSort.pop());
            }

            newStackSort.puch(tmp);
        }
        return newStackSort;
    }

    public void puch(E r) {
        List.add(r);
    }

    public E pop() {
        return List.removeByindex(List.getsize() - 1);
    }

    public boolean isEmpty() {
        return List.size() > 0;
    }

    public int StackSeardh(E y) {
        int i = 1;
        for (int j = List.getsize() - 1; j >= 0; j--) {
            if (List.get(j).equals(y)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int sizestack() {
        return List.getsize();
    }

    public E peek() {
        return List.get(List.getsize() - 1);
    }

    @Override
    public String toString() {
        return List.toString();
    }

}
