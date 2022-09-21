package arraylist;

import java.util.Set;
import java.Arrays;

public class ArraListO<E> implements MyArr<E> {

    private int size;
    private int capacity;
    private Object Arr[];

    ArraListO() {
        size = 0;
        capacity = 10;
        Arr = new Object[capacity];
    }

    public boolean retainAll(Object[] arr) {
        int c = 0;
        for (int i = 0; i <= size; i++) {
            int t = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((Integer) Arr[i] == (Integer) arr[j]) {
                    t++;
                    break;
                }
            }
            if (t == 0) {
                for (int k = i; k <= size; k++) {
                    Arr[k] = Arr[k + 1];
                    size--;
                }
            }
        }
        if (c > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(Arr[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        return result.toString() + "]";
    }

    public void addFirst(E e) {
        CheckAndIncreaseArraySize();
        size++;
        for (int i = size; i > 0; i--) {
            Arr[i] = Arr[i - 1];
        }
        Arr[0] = e;
    }

    public void addall(ArraListO<Integer> k, int p) {
        for (int w = p, j = 0; j < k.size; w++, j++) {
            this.add(w, (E) k.get(j));
        }
    }

    @Override
    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(Arr[i] + " ");
        }
    }

    public E get(int index) {
        if (index >= 0 && index < size) {
            return (E) Arr[index];
        }

        return null;
    }

    public int getsize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    void rotate(ArraListO list, int r) {
        for (int i = 0; i < r; i++) {
            list.addFirst(list.removeLast());
        }

    }

    @Override
    public void add(E e) {
        if (size == Arr.length) {
            enshourcapacity();
        }
        Arr[size] = e;
        size++;
    }

    public void duplicate() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if ((int) Arr[j] > (int) Arr[j + 1]) {

                    int temp = (int) Arr[j];

                    Arr[j] = Arr[j + 1];

                    Arr[j + 1] = temp;

                }
            }
        }

        int t[] = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            t[i] = 0;
        }
        for (int i = 0; i < size; i++) {
            t[(int) Arr[i]]++;
        }
        int y = 0;
        for (int i = 0; i < 10000000; i++) {
            if (t[i] >= 1) {
                y++;
            }
        }
        Object a[] = new Object[y];
        int i = 0, Last = 0, j = 0;
        while (i < size) {

            if (i == 0 || (int) Arr[i] != Last) {
                a[j] = Arr[i];
                Last = (int) Arr[i];
                j++;
            }

            i++;
        }
        size = y;
        Arr = a;
    }

    @Override
    public void add(int index, E e) {
        check(index);
        if (index == size) {
            add(e);
        } else {
            for (int i = size - 1; i >= index; i--) {
                Arr[i + 1] = Arr[i];
            }
            Arr[index] = e;
            size++;
        }
    }

    @Override
    public int indexof(E e) {
        for (int i = 0; i < size; i++) {
            if (Arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(E e) {
        if (!contain(e)) {
            return false;
        }
        removeByindex(indexof(e));
        return true;
    }

    @Override
    public E removeByindex(int index) {
        check(index);
        E w = (E) Arr[index];
        for (int i = index; i < size; i++) {
            Arr[i] = Arr[i + 1];
        }
        size--;
        return w;
    }

    @Override
    public boolean contain(E e) {
        for (int i = 0; i < size; i++) {
            if (Arr[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    private void check(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("size " + size + "index" + index);
        }
    }

    public void PD(int k) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int a = (int) Arr[i] - (int) Arr[j];
                int y = Math.abs(a);
                if (y == k) {
                    System.out.print("(" + Arr[i] + "," + Arr[j] + ")");
                }
            }
        }
    }

    private void enshourcapacity() {
        Object Arr2[] = new Object[2 * size];
        for (int i = 0; i < Arr.length; i++) {
            Arr2[i] = Arr[i];
        }
        Arr = Arr2;

    }

    public ArraListO(ArraListO<E> copy) {
        this.Arr = copy.Arr;
        this.size = copy.size;
    }

    public int lastIndexOf(E e) {
        if (!isEmpty()) {
            int value = -1;
            for (int i = size; i >= 0; i--) {
                if (e.equals(Arr[i])) {
                    value = i;
                    break;
                }
            }
            return value;
        } else {
            return -1;
        }
    }

    public boolean contains(E e) {
        if (!isEmpty()) {
            for (int i = 0; i <= size; i++) {
                if (Arr[i].equals(e)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void SetElement(int index, E element) {
        this.Arr[index] = element;
    }

    public boolean containsAll(ArraListO list) {
        int count = -1;
        for (int i = 0; i <= this.size; i++) {
            for (int j = 0; j <= list.size; j++) {
                if (this.get(i).equals(list.get(j))) {
                    count++;
                    break;
                }
            }
        }
        if (count == this.size) {
            return true;
        }
        return false;
    }

    public void removeFirst() {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                Arr[i] = Arr[i + 1];
            }
            Arr[size] = null;
            size--;
        }
    }

    public E removeLast() {
        E U = null;
        if (!isEmpty()) {
            U = (E) Arr[size - 1];
            Arr[size - 1] = null;
            size--;
        }
        return U;
    }

    public void CheckAndIncreaseArraySize() {
        if (size == Arr.length - 1) {
            E temp[] = (E[]) new Object[Arr.length + 1];
            for (int i = 0; i < Arr.length; i++) {
                temp[i] = (E) Arr[i];
            }
            Arr = temp;
            temp = null;
        }
    }

    public void addByIndex(int index, E e) {
        if (index > size || index < 0) {
            System.out.println("out of range index");
        } else {
            CheckAndIncreaseArraySize();
            if (index == size) {
                add(e);
            } else if (index == 0) {
                addFirst(e);
            } else {
                size++;
                for (int i = size; i > index; i--) {
                    Arr[i] = Arr[i - 1];
                }
                Arr[index] = e;
            }
        }
    }

    public ArraListO copyArray() {
        ArraListO<E> copy = new ArraListO<E>();
        for (int i = 0; i <= this.size; i++) {
            copy.add(this.get(i));
        }
        return copy;
    }

    public boolean sameElements(ArraListO list) {
        if (list.size != this.size) {
            return false;
        } else {
            ArraListO<E> arr = list.copyArray();
            for (int i = 0; i <= this.size; i++) {
                for (int j = 0; j <= arr.size; j++) {
                    if (arr.get(j).equals(this.get(i))) {
                        arr.removeByIndex(j);
                        break;
                    }
                }
            }
            if (arr.isEmpty()) {
                return true;
            }
            return false;
        }

    }

    public ArraListO subList(int index1, int index2) {
        ArraListO<E> temp = new ArraListO<E>();
        int mid = index2 - index1;
        int j = index1;
        int i = 0;
        while (i < mid) {
            temp.add(get(j));
            j++;
            i++;
        }
        return temp;
    }

    public E removeByIndex(int index) {
        if (!isEmpty()) {
            E value = null;
            if (index > size || index < 0) {
                System.out.print("unvalid removing index");
            } else {
                value = (E) Arr[index];
                if (index == size) {
                    removeLast();
                } else if (index == 0) {
                    removeFirst();
                } else {
                    for (int i = index; i < size; i++) {
                        Arr[i] = Arr[i + 1];
                    }
                    Arr[size] = null;
                    size--;
                }
            }
            return value;
        } else {
            return null;
        }
    }

    public void clear() {
        size = 0;
    }

    public int indexOf(E e) {
        if (!isEmpty()) {
            int value = -1;
            for (int i = 0; i <= size; i++) {
                if (e.equals(Arr[i])) {
                    value = i;
                    break;
                }
            }
            return value;
        } else {
            return -1;
        }
    }

    public void removelastRecursive() {// function to make calling the removeLastRecursive function
        // a parameterLess (overloading it)
        int base = 0;//make the start always from 0
        boolean remove = false;// a flag to active the break of recursive or not
        removelastRecursive(base, remove);// calling the overLoading orginal recursive function
    }

    public void removelastRecursive(int base, boolean remove) {
        if (base == size - 1) {// the condition to break or not (reaching the last index of the arrayList)
            remove = true;// make the breaking flag true (end the recursive)
        }
        if (remove == true) {
            removeLast(); // active the removing last index of the arrayList
        } else {

            removelastRecursive(base + 1, remove);//applying recursive every time increase the base by one until reach the last index
        }
    }

    public double compleatSerious(int i) {
        if (i == 1) {// condition of break the rule of recursive function
            return i;
        } else {
            return (double) (1.0 / i) + compleatSerious(i - 1);// apply recursive everytime until we reach the last case we need
        }
    }

    public void rvereseArrayList() {
        ArraListO<E> copy = this.copyArray();
        int counter = copy.size;
        for (int i = 0; i < this.size; i++) {
            copy.SetElement(counter, this.get(i));
            counter--;
        }
        this.Arr = copy.Arr;
        this.size = copy.size;
    }

    public void InsertionSort() {
        int j, k;
        int c = 0;
        for (int i = 1; i < size; i++) {
            k = (Integer) Arr[i];
            j = i - 1;
            while (j >= 0 && (Integer) Arr[j] > k) {
                Arr[j + 1] = Arr[j];
                j--;
            }
            Arr[j + 1] = k;
            c++;
            if (c == 3) {
                break;
            }
        }
    }

    public void merge(int F, int L) {
        int M = F + (L - F) / 2;
        int i, j, k;
        int n1 = M - F + 1;
        int n2 = L - M;
        int arr1[] = new int[n1];
        int arr2[] = new int[n1];
        for (i = 0; i < n1; i++) {
            arr1[i] = (Integer) Arr[i + F];
        }
        for (i = 0; i < n2; i++) {
            arr2[i] = (Integer) Arr[M + 1 + i];
        }
        i = j = 0;
        k = F;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                Arr[k] = arr1[i];
                i++;
            } else {
                Arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            Arr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n2) {
            Arr[k] = arr2[j];
            j++;
            k++;
        }
    }

    public void MaregeSort(int F, int L) {
        if (F < L) {
            int M = F + (L - F) / 2;
            MaregeSort(F, M);
            MaregeSort(1 + M, L);
            merge(F, L);
        }

    }

    public void heapSort() {
        buildheab();
        for (int i = size - 1; i >= 0; i--) {
            swap(0, i);
            heapify(i, 0);
        }
    }

    public void buildheab() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(size, i);
        }

    }

    public void heapify(int n, int i) {
        int L = 2 * i + 1;
        int R = 2 * i + 2;
        int max = i;
        if (L < n && (Integer) Arr[L] > (Integer) Arr[max]) {
            max = L;
        }
        if (R < n && (Integer) Arr[R] > (Integer) Arr[max]) {
            max = R;
        }
        if (max != i) {
            swap(i, max);
            heapify(n, max);
        }
    }

    public void swap(int y, int m) {

        E t = (E) Arr[y];
        Arr[y] = Arr[m];
        Arr[m] = t;

    }

    public int partition(int y, int x) {
        int i = y;
        int j = x;
        int Loc = i;
        while (true) {
            while ((int) Arr[Loc] <= (int) Arr[j] && Loc != j) {
                j--;
            }
            if (Loc == j) {
                break;
            } else if ((int) Arr[Loc] > (int) Arr[j]) {
                this.swap(j, Loc);
                Loc = j;
            }
            while ((int) Arr[Loc] >= (int) Arr[i] && Loc != i) {
                i++;
            }
            if (Loc == i) {
                break;
            } else if ((int) Arr[Loc] < (int) Arr[i]) {
                this.swap(i, Loc);
                Loc = i;
            }
        }
        return Loc;
    }
//   public int Partition(int x,int y){
//       int p=(int)Arr[x];
//       int i=x;
//       int j=y;
//       while(i<j){
//           do{ i++;
//           }while((int)Arr[i]<=p);
//          do{ j--;
//           }while((int)Arr[j]>p);
//               if(i<j)
//                   this.swap(i,j);
//       }
//       this.swap(x, j);
//       return j;
//   }
//      public void QuiqSort(int First,int Last){
//       if(First<Last){
//           int p=this.Partition(First, Last);
//           QuiqSort(First,p);
//            QuiqSort(p+1,Last);
//       }
//   }
    int s = 0;

    public int yosefparsh(int p, int r) {

        int x = (int) Arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if ((int) Arr[j] <= x) {
                i++;
                this.swap(i, j);
            }
        }
        this.swap(i + 1, r);
        return i + 1;
    }

    public void quiqSort(int First, int Last) {
        if (First < Last) {
            int p = yosefparsh(First, Last);
            quiqSort(First, p - 1);
            quiqSort(p + 1, Last);
        }
    }

    public void spiltID(int Id) {
        while (Id != 0) {
            Integer r = Id % 10;
            this.addFirst((E) r);
            Id /= 10;
        }
    }

    public int sum_Of_non_prime_even() {
        int s = 0;
        for (int i = 0; i < this.size(); i++) {
            if ((int) Arr[i] % 2 == 0 && (int) Arr[i] != 2) { //لا اقوم بالفحص على الاعداد هل هي اولية او لا 
                s += (int) Arr[i];               //لان كل الاعداد الزوجية غير اولية من عدا الرقم اثنان
            }
        }
        return s;
    }

}
