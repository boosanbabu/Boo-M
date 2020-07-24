package dsa.leetcode.medium.design;

import java.util.*;

class FirstUnique {

	class Node {
		int val;
		Node prev, next;

		Node(int k) {
			val = k;
		}

		public String toString() {
			return val + "";
		}
	}

	Set<Integer> visited;
	Map<Integer, Node> uniqueNumbersCache;
	Node head, tail;

	void remove(Node n) {
		n.next.prev = n.prev;
		n.prev.next = n.next;
	}

	void addLast(Node n) {
		Node temp = tail.prev;
		temp.next = n;
		n.next = tail;
		n.prev = temp;
		tail.prev = n;
	}

	void initDoublyLL() {
		head = new Node(-1);
		tail = new Node(-1);
		head.next = tail;
		tail.prev = head;
	}

	public FirstUnique(int[] nums) {
		visited = new HashSet<>();
		uniqueNumbersCache = new HashMap<>();
		initDoublyLL();
		for (int i : nums) {
			add(i);
		}
	}

	public int showFirstUnique() {
		System.out.print(head.next.val);
		return head.next.val;
	}

	public void add(int value) {
		if (uniqueNumbersCache.containsKey(value)) {
			Node del = uniqueNumbersCache.get(value);
			remove(del);
			uniqueNumbersCache.remove(value);
		} else if (!visited.contains(value)) {
			Node node = new Node(value);
			addLast(node);
			uniqueNumbersCache.put(value, node);
		}
		visited.add(value);
	}

	/**
	 * Your FirstUnique object will be instantiated and called as such: FirstUnique
	 * obj = new FirstUnique(nums); int param_1 = obj.showFirstUnique();
	 * obj.add(value);
	 */

	public static void main(String[] args) {
		int[] nums = { 2, 3, 5 };
		FirstUnique fu = new FirstUnique(nums);
		fu.showFirstUnique();
		fu.add(2);
		fu.showFirstUnique();
		fu.add(3);
		fu.showFirstUnique();
		fu.add(5);
		fu.showFirstUnique();

	}

}
