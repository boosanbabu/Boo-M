package com.boom.codedaily.medium.graph;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

    Map<Integer, Node> map;

    static class Node {
        Node parent;
        int rank;
        int data;
    }

    UnionFind() {
        map = new HashMap<>();
    }

    public void makeSet(int val) {
        Node newNode = new Node();
        newNode.parent = newNode;
        newNode.data = val;
        newNode.rank = 0;
        map.put(val, newNode);
    }

    public boolean union(int a, int b) {
        Node aParent = findSet(map.get(a));
        Node bParent = findSet(map.get(b));
        if (aParent == bParent)
            return false;
        if (aParent.rank >= bParent.rank) {
            aParent.rank = (aParent.rank == bParent.rank) ? aParent.rank + 1 : aParent.rank;
            bParent.parent = aParent;
        } else {
            aParent.parent = bParent;
        }
        return true;
    }

    public int findSet(int val) {
        return findSet(map.get(val)).data;
    }

    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node)
            return parent;
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public static void main(String[] args) {
        UnionFind ds = new UnionFind();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }

}
