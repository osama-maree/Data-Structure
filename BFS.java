package test;

import java.util.*;

public class BFS {

    ArrayList<Integer> adj[];
    int Ver;

    BFS(int V) {
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList();
        }
        Ver = V;
    }

    void add(int x, int y) {
        adj[x].add(y);
//        adj[y].add(x);   to undirected graph
    }

    void print() {
        for (int i = 0; i < adj.length; i++) {
            System.out.print(adj[i].size() > 0 ? "[" + i + "] :" + adj[i].toString() + "\n" : "");
        }
    }

    void bfs(int v) {
        Queue<Integer> q = new LinkedList();
        boolean arr[] = new boolean[Ver];
        boolean arr2[] = new boolean[Ver];
        q.add(v);
        arr2[v] = true;
        int c = 0;
        while (!q.isEmpty()) {
            for (int j = 0; j < adj[v].size(); j++) {
                if (!arr2[adj[v].get(j)]) {
                    q.add(adj[v].get(j));
                }
                arr2[adj[v].get(j)] = true;
            }
            arr[q.peek()] = true;

            System.out.println(q.poll());

            if (!q.isEmpty()) {
                v = q.peek();
            } else { //dircted graph
                for (int i = 0; i < Ver; i++) {
                    if (!arr[i]) {
                        v = i;
                        arr2[i] = true;
                        q.add(v);
                        break;
                    }

                }
            }
        }

    }

    void DFS(int v) {
        Stack<Integer> S = new Stack();
        boolean visited[] = new boolean[Ver];
        S.push(v);

        visited[v] = true;

        while (!S.isEmpty()) {
            for (int i = 0; i < adj[v].size(); i++) {
                if (!visited[adj[v].get(i)]) {
                    visited[adj[v].get(i)] = true;
                    v = adj[v].get(i);
                    S.push(v);

                    i = Ver + 1;
                    if (adj[v].size() > 0) {
                        i = 0;
                    }
                }

            }

            System.out.println(S.pop());
            if (!S.isEmpty()) {
                v = S.peek();
            } else { //dircted graph
                for (int i = 0; i < Ver; i++) {
                    if (!visited[i]) {
                        v = i;
                        visited[i] = true;
                        S.push(v);
                        break;
                    }

                }
            }
        }

    }

}
