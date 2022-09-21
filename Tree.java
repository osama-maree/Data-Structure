package tree;

import java.util.*;
import java.util.Queue;

public class Tree<E extends Comparable<E>> {

    Node<E> Root;

    Tree() {
        Root = null;
    }
    int s = 0;

    public void Add(E Value) {
        s++;
        if (this.Root == null) {
            this.Root = new Node<E>(Value);
        } else {
            Node<E> T = Root;
            Node<E> NewNode = new Node<E>(Value);
            while (T != null) {
                if (Integer.parseInt((String) Value) >= (Integer) T.Value) {
                    if (T.Right == null) {
                        T.Right = NewNode;
                        break;
                    } else {
                        T = T.Right;
                    }
                } else {
                    if (T.Left == null) {
                        T.Left = NewNode;
                        break;
                    } else {
                        T = T.Left;
                    }
                }
            }
        }
    }

    public void PreOrder() {
        PreOrder(this.Root);
    }

    public void PreOrder(Node Now) {
        if (Now == null) {
            return;
        }
        System.out.print(Now.Value + " ");
        PreOrder(Now.Left);

        PreOrder(Now.Right);
    }

    public void InOrder() {
        InOrder(this.Root);
    }

    public void InOrder(Node Now) {
        if (Now == null) {
            return;
        }
        InOrder(Now.Left);
        System.out.print(Now.Value + " ");
        InOrder(Now.Right);
    }

    public void PostOrder() {
        PostOrder(this.Root);
    }

    public void PostOrder(Node Now) {
        if (Now == null) {
            return;
        }

        PostOrder(Now.Left);
        PostOrder(Now.Right);
        System.out.print(Now.Value + " ");
    }

    public void PrintLeaves() {
        PrintLeaves(this.Root);
    }

    public void PrintLeaves(Node Now) {
        if (Now == null) {
            return;
        }
        if (Now.Left == null && Now.Right == null) {
            System.out.print(Now.Value + " ");
        }
        PrintLeaves(Now.Left);
        PrintLeaves(Now.Right);
    }

    public int maxLeafNodesSum(Node Now) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(Now);
        Q.add(null);
        int Sum = 0;
        int Ans = -10000;
        while (!Q.isEmpty()) {
            Node<E> X = Q.remove();
            if (X.Left == null && X.Right == null) {
                Sum += (Integer) X.Value;
            }

            if (X.Left != null) {
                Q.add(X.Left);
            }
            if (X.Right != null) {
                Q.add(X.Right);
            }

            if (Q.peek() == null) {
                Ans = Math.max(Ans, Sum);
                Sum = 0;
                Q.remove();
                if (!Q.isEmpty()) {
                    Q.add(null);
                }
            }
        }

        return Ans;
    }

    public int MaxDepth() {
        return MaxDepth(this.Root);
    }

    public int MaxDepth(Node Now) {
        if (Now == null) {
            return 0;
        }
        int Res1 = MaxDepth(Now.Left);
        int Res2 = MaxDepth(Now.Right);
        return Math.max(Res1, Res2) + 1;
    }

    public int GetLevel(E Element) {
        return GetLevel(this.Root, Element);
    }

    public int GetLevel(Node<E> Now, E Element) {
        if (Now == null) {
            return 0;
        }

        if (Element.compareTo(Now.Value) == 0) {
            return 1;
        }

        int Res1 = GetLevel(Now.Right, Element);
        if (Res1 > 0) {
            Res1++;
        }

        int Res2 = GetLevel(Now.Left, Element);
        if (Res2 > 0) {
            Res2++;
        }

        return Math.max(Res1, Res2);
    }

    public void PrintLevelByLevel() {
        PrintLevelByLevel(this.Root);
    }

    public void PrintLevelByLevel(Node Now) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(Now);
        Q.add(null);
        while (!Q.isEmpty()) {
            Node<E> X = Q.remove();
            System.out.print(X.Value + " ");
            if (X.Left != null) {
                Q.add(X.Left);
            }
            if (X.Right != null) {
                Q.add(X.Right);
            }
            if (Q.peek() == null) {
                System.out.println();
                Q.remove();
                if (!Q.isEmpty()) {
                    Q.add(null);
                }
            }
        }
    }

    public void sum(Node root, int sum) {
        if (root.Left != null && root.Right != null && root != null) {
            int s = (Integer) root.Value + (Integer) root.Right.Value + (Integer) root.Left.Value;
            if (s == sum) {
                System.out.println(root.Value + " " + root.Right.Value + " " + root.Left.Value);
            }
        }
        if (root.Left != null && root.Right != null) {
            sum(root.Left, sum);
            sum(root.Right, sum);
        } else if (root.Left != null && root.Right == null) {
            sum(root.Left, sum);
        } else if (root.Left == null && root.Right != null) {
            sum(root.Right, sum);
        }
    }
    static Queue<Node> L = new LinkedList<>();

    public static void pair(Node root) {
        if (root.Left != null && root.Right != null) {
            L.add(root);
            pair(root.Left);
            pair(root.Right);
        } else if (root.Left != null && root.Right == null) {
            L.add(root);
            pair(root.Left);
        } else if (root.Left == null && root.Right != null) {
            L.add(root);
            pair(root.Right);
        } else if (root.Left == null && root.Right == null) {
            L.add(root);
        }
    }

    public void print() {
        while (!L.isEmpty()) {
            System.out.print(L.poll().Value + " ");
        }
    }

    public void Max(Node root) {
        if (root.Right != null) {
            Max(root.Right);
        } else {
            System.out.println(root.Value);
        }

    }
    int c1 = 1, c2 = 1;

    public int maxD(Node root) {
        if (root.Left != null && root.Right != null) {
            c1++;
            maxD(root.Left);
            c2++;
            maxD(root.Right);
        } else if (root.Left != null && root.Right == null) {
            c1++;
            maxD(root.Left);
        } else if (root.Left == null && root.Right != null) {
            c2++;
            maxD(root.Right);
        }
        return Math.max(c1, c2);
    }
    int c = 0;

    public int getLevel(Node root, E y) {
        if (y.compareTo((E) root.Value) > 0) {
            c++;
            getLevel(root.Right, y);
        } else if (y.compareTo(y) < 0) {
            c++;
            getLevel(root.Left, y);
        }
        return c;
    }
    int h = 0;
    static ArrayList<Integer> J = new ArrayList<>();

    public void zer(int y) {
        for (int i = 0; i < y; i++) {
            J.add(0);
        }
    }

    public void OneChild(Node root) {
        if (root == null) {
            return;
        }
        if (root.Right == null && root.Left != null && root.Left.Left == null && root.Left.Right == null) {
            System.out.println("One Childe :" + (int) root.Value);
        }
        if (root.Left == null && root.Right != null && root.Right.Left == null && root.Right.Right == null) {
            System.out.println("One Childe :" + (int) root.Value);
        }
        OneChild(root.Left);
        OneChild(root.Right);
    }

    public void sumLevel(Node root) {
        if (root.Left != null && root.Right != null) {
            for (int i = 0; i <= J.size(); i++) {
                if (i == this.GetLevel((E) root.Value) - 1) {
                    J.set(i, J.get(i) + (Integer) root.Value);
                    break;
                }

            }
            sumLevel(root.Left);
            sumLevel(root.Right);
        } else if (root.Left != null && root.Right == null) {
            for (int i = 0; i <= J.size(); i++) {
                if (i == this.GetLevel((E) root.Value) - 1) {
                    J.set(i, J.get(i) + (Integer) root.Value);
                    break;
                }

            }
            sumLevel(root.Left);
        } else if (root.Left == null && root.Right != null) {
            for (int i = 0; i <= J.size(); i++) {
                if (i == this.GetLevel((E) root.Value) - 1) {
                    J.set(i, J.get(i) + (Integer) root.Value);
                    break;
                }
            }
            sumLevel(root.Right);
        } else {
            for (int i = 0; i <= J.size(); i++) {
                if (i == this.GetLevel((E) root.Value) - 1) {
                    J.set(i, J.get(i) + (Integer) root.Value);
                    break;
                }
            }

        }
    }

    public boolean searsh(Node r, int y) {
        if (r == null) {
            return false;
        }
        if ((Integer) r.Value == y) {
            return true;
        }
        if (y > (Integer) r.Value) {
            return searsh(r.Right, y);
        } else {
            return searsh(r.Left, y);
        }
    }

    public int countlevel(Node root) {
        return 1;
    }

}
