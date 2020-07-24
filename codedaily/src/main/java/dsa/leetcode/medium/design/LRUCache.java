package dsa.leetcode.medium.design;

import java.util.*;

class LRUCache {

	int maxCapacity, currentCapacity;
	Map<Integer, Node> map;
	DoublyLinkedList dll;

	class Node {
		int val, key;

		Node(int k, int v) {
			key = k;
			val = v;
		}

		Node prev, next;
	}

	class DoublyLinkedList {
		Node head, tail;

		DoublyLinkedList() {
			head = new Node(-1, -1);
			tail = new Node(-1, -1);
			head.next = tail;
			tail.prev = head;
		}

		void addFirst(Node n) {
			Node temp = head.next;
			temp.prev = n;
			n.next = temp;
			head.next = n;
			n.prev = head;
		}

		void remove(Node n) {
			n.prev.next = n.next;
			n.next.prev = n.prev;
		}

		void removeTail() {
			Node temp = tail.prev;
			temp.prev.next = tail;
			tail.prev = temp.prev;
		}
	}

	public LRUCache(int capacity) {
		maxCapacity = capacity;
		map = new HashMap<>();
		dll = new DoublyLinkedList();
	}

	public int get(int key) {
		if (null == map.get(key)) {
			return -1;
		}
		Node n = map.get(key);
		dll.remove(n);
		dll.addFirst(n);
		return n.val;
	}

	public void put(int key, int value) {
		Node n = map.get(key);
		if (n != null) {
			dll.remove(n);
			n.val = value;
		} else {
			n = new Node(key, value);
			if (map.size() == maxCapacity) {
				map.remove(dll.tail.key);
				dll.removeTail();
			}
		}

		dll.addFirst(n);
		map.put(key, n);
	}

	public static void main(String ar[]) {
		LRUCache lru = new LRUCache(5);
		lru.put(1, 4);
		lru.put(1, 5);
		lru.put(2, 3);
		lru.put(3, 4);
		lru.put(4, 5);
		lru.put(5, 6);
		lru.put(6, 6);
		System.out.println(lru.get(5));
		System.out.println(lru.get(1));
		System.out.println(lru.get(2));
		System.out.println(lru.get(3));
		System.out.println(lru.get(4));
	}
}
