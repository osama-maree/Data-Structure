
public class MyLinkedList1<E> {

    public Node<E> head, tail;
    private int size = 0;

    public void addLast(E e) {
        if (head == null) {
            head = tail = new Node<>(e);
            size++;
        } else {
            Node<E> o = new Node<>(e);
            tail.next = o;
            tail = o;
            size++;
        }
    }

    public MyLinkedList1() {
    }

    public MyLinkedList1(E Objects[]) {
        for (int i = 0; i < Objects.length; i++) {
            addLast((Objects[i]));
        }
    }

    public boolean Offer(E a) {   //for Queue
        Node<E> o = new Node<>(a);
        try {
            if (head == null) {
                head = tail = o;
                size++;
                return true;
            } else {

                tail.next = o;
                tail = o;
                size++;
                return true;
            }
        } catch (Exception m) {
            return false;
        }
    }

    public E poll() {
        if (head == null) {
            return null;
        } else {
            E r = head.element;
            Node w = head;
            head = head.next;
            w = null;
            size--;
            return r;
        }
    }

    public E element() {
        if (head == null) {
            throw new UnsupportedOperationException("Qeuo is empty");
        } else {
            return head.element;
        }
    }

    public E peek() {
        if (head == null) {
            return null;
        } else {
            return head.element;
        }
    }

    public boolean add(E a) {
        if (head == null) {
            head = tail = new Node<>(a);
            size++;
        } else {
            Node<E> o = new Node<>(a);
            tail.next = o;
            tail = o;
            size++;
        }
        return true;

    }

    public void removeDup() {

        int arr[] = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = 0;
        }

        Node u = head;
        int y = 0;
        while (u != null) {
            int x = (int) u.element;
            arr[x]++;
            if (arr[x] > 1) {
                removeOfindex(y);
                y--;
            }
            u = u.next;
            y++;
        }

    }

    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            E y = head.element;
            head = tail = null;
            size--;
            return y;
        } else {
            Node u = head;
            for (int i = 0; i < size - 2; i++) {
                u = u.next;
            }
            E r = tail.element;
            tail = u;
            tail.next = null;
            size--;
            return r;
        }
    }

    public void find(MyLinkedList1<Integer> list) {//find secend max in linked list
        Node<Integer> curr = list.head;
        Integer max = list.head.element;
        Integer secondMax = list.head.element;
        for (int i = 1; i < list.size; i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }

        for (int i = 1; i < list.size; i++) {
            if (secondMax < list.get(i) && !list.get(i).equals(max)) {
                secondMax = list.get(i);
            }
        }
        System.out.print("the max is " + max + "\n the second max is " + secondMax);
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        E p = head.element;
        head = head.next;
        size--;
        return p;
    }

    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    public void addFirst(E e) {
        Node<E> o = new Node<>(e);
        o.next = head;
        head = o;
        size++;
        if (tail == null) {
            head = tail;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;

    }

    public void add(int index, E e) {
        if (index >= size) {
            addLast(e);
        } else if (index == 0) {
            addFirst(e);
        } else {
            Node<E> r = new Node<>(e);
            Node u = head;
            for (int i = 1; i < index - 1; i++) {
                u = u.next;
            }
            r.next = u.next;
            u.next = r;
            size++;
        }
    }

    public void revers() {
        Node<E> p = head;
        Node<E> e = null, n = null;
        while (p != null) {
            n = p.next;
            p.next = e;
            e = p;
            p = n;

        }
        head = e;
    }

    public void swap(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size) {
            Node<E> c1 = getNode(x);
            Node<E> c2 = getNode(y);
            Node<E> r1 = getNode(x - 1);
            Node<E> r2 = getNode(y - 1);
            if (x != 0) {
                r1.next = c2;
            } else {
                head = c2;
            }
            if (y != 0) {
                r2.next = c1;
            } else {
                head = c1;
            }
            Node<E> t = c1.next;
            c1.next = c2.next;
            c2.next = t;
            if (tail == c2) {
                tail = c1;
            } else if (tail == c1) {
                tail = c2;
            }
        }
    }

    public void swapv(E e, E y) {
        int x = indexOf(e);
        int o = indexOf(y);
        swap(x, o);
    }

    public int indexOf(E r) {
        Node<E> t = head;
        int i = 0;
        int z = (Integer) r;
        while ((((Integer) t.element == z)) == false) {
            t = t.next;
            i++;
        }
        return i;
    }

    public E removeOfindex(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    public void addLast1(E e) {
        add(size, e);
    }

    public int size() {
        return size;
    }

    public E remove(E e) {
        Node<E> w = head;
        Node<E> r = head;
        while (w.element.equals(e)) {
            r = w;
            w = w.next;
        }

        r.next = w.next;
        size--;
        return (E) e;
    }

    public void print() {
        Node y = head;
        while (y != null) {
            System.out.print(" >> " + y.element);
            y = y.next;
        }
    }

    public Node getNode(int n) {
        if (n < -1 || n >= size) {
            throw new IndexOutOfBoundsException("index " + n + " out of bounds");
        }

        Node<E> curr = head;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public E get(int n) {
        if (n < 0 || n >= size) {
            throw new IndexOutOfBoundsException("index " + n + " out of bounds");
        }
        Node<E> curr = head;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        return curr.element;
    }

    public int indexof(E e) {
        Node r = head;
        for (int i = 0; i < size; i++) {
            if (r.element.equals(e)) {
                return i + 1;
            }
            r = r.next;
        }

        return -1;
    }

    public void nthNodefromLast(int n) {  
        Node c = head;
        int cx = size - n;
        while (cx != 0) {
            cx--;
            c = c.next;
        }
        System.out.println(c.element);
    }

    public static Node reverse(Node head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        Node newHeadNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHeadNode;
    }
    int y = 0;

    public Object revers(MyLinkedList1 aa) {
        if (y == aa.size - 1) {
            return aa;
        }

        aa.add(y, aa.removeLast());
        y++;
        return revers(aa);

    }

    public void secendEven() {
        Node W = head;
        int c = 0, i = 0;
        while (W != null) {
            int y = (Integer) get(i);
            if (y % 2 == 0) {
                if (c == 1) {
                    System.out.println(W.element);
                    break;
                } else {
                    c++;
                }
            }
            W = W.next;
            i++;
        }
    }

    public void delet(int m) {
        Node j = head;
        int c = 0;
        while (j != null) {
            if (c == m) {
                for (int i = 0; i < 3; i++) {
                    removeOfindex(c);
                    j = j.next;

                }
                break;
            }
            c++;
            j = j.next;
        }

    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(get(i));
            if (i < size - 1) {
                result.append(", ");
            }
        }
        return result.toString() + "]";
    }

    public void deletodd() {
        int i = 1;
        Node R = head;
        while (R != null) {
            int u = (Integer) get(i);
            if (u % 2 != 0) {
                removeOfindex(i);
                i--;
            }
            i++;
            R = R.next;
        }

    }

    public void spilt() {
        int y = size / 2;
        int y1 = size - y;
        MyLinkedList1<E> L = new MyLinkedList1<>();
        MyLinkedList1<E> L1 = new MyLinkedList1<>();
        Node Q = head;
        int i = 0;
        while (Q != null) {
            for (; i < y; i++) {
                L.addLast(get(i));
            }
            for (; i < size; i++) {
                L1.addLast(get(i));;
            }
            Q = Q.next;
        }
        Node K = head;
        int o = 0;
        while (K != null) {
            if (o == y) {
                break;
            }
            E p = L.get(o);
            System.out.print(">> " + p);
            K = K.next;
            o++;
        }
        System.out.println("");
        System.out.println("thh half other");
        Node k = head;
        int a = 0;
        while (k != null) {
            if (a == y1 - 1) {
                break;
            }
            E p = L1.get(a);
            System.out.print(">> " + p);
            k = k.next;
            a++;
        }
    }

    public void rotatleft() {

        this.addLast(this.removeFirst());
    }

    public void rotatrught() {
        this.addFirst(this.removeLast());
    }

    public void paitSwap() {
        Node L = head;
        int i = 0, j = 1;
        while (L != null) {
            this.swap(i, j);
            L = L.next;
            if (L != null) {
                L = L.next;
            } else {
                break;
            }
            i += 2;
            j += 2;
        }
    }

    public void setIndex(int j, E t) {
        if (j == 0) {
            Node r = head;
            Node<E> y = new Node<>(t);
            y.next = r.next;
            y = r;
            y.element = t;
        } else {
            Node r = head;
            Node<E> y = new Node<>(t);
            for (int i = 0; i < j; i++) {
                r = r.next;
            }
            y.next = r.next;
            y = r;
            y.element = t;

        }
    }

    public void swapV(int n, int y) {
        E T = this.get(n);
        this.setIndex(n, this.get(y));
        this.setIndex(y, T);

    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int m = (Integer) this.get(i);
            for (int j = i + 1; j < size; j++) {
                int m1 = (Integer) this.get(j);
                if (m1 < m) {
                    this.swap(i, j);
                }
            }
        }
    }

    public void BubbleSort() {
        boolean flag = true;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                int m = (Integer) this.get(j);
                int m1 = (Integer) this.get(j + 1);
                if (m1 < m) {
                    flag = false;
                    this.swapV(j, 1 + j);
                }
            }
            if (flag == true) {
                break;
            }
        }
    }

    public void remoove(int n, int m) {
        int a = 0;
        Node r = head;
        int y = 0;
        while (r != null) {
            a++;
            int w = n;
            y++;
            if (a == m) {
                while (w != 0) {
                    removeOfindex(y);
                    w--;
                }
                a = 0;

            }
            r = r.next;
        }

    }

    public void printRevers(Node Q) {
        if (Q == null) {
            return;
        }
        printRevers(Q.next);
        System.out.print(">> " + Q.element);
    }

    public void print_all_characters_frequancy(int freq) {
        int arr[] = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = 0;
        }
        Node current = head;
        while (current != null) {
            char u = (char) current.element;
            if (u >= 'A' && u <= 'Z') {
                u += 32;
            }
            arr[u - 'a']++;
            current = current.next;
        }
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == freq) {
                char t = (char) (i + 'a');
                System.out.println(t);
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Not found same the frequancy");
        }
    }

    public void SortLinkedList() { //Sort for char
        Node MainHead = head;
        while (head != null) {
            Node Head2 = MainHead;
            while (Head2.next != null) {
                char First = (char) Head2.element;
                char Second = (char) Head2.next.element;
                if (First <= 'Z') {
                    First += 32;
                }
                if (Second <= 'Z') {
                    Second += 32;
                }
                if (First > Second || (First == Second && (char) Head2.element < (char) Head2.next.element)) {
                    char T = (char) Head2.element;
                    Head2.element = Head2.next.element;
                    Head2.next.element = T;
                }
                Head2 = Head2.next;
            }
            head = head.next;
        }
    }

}
