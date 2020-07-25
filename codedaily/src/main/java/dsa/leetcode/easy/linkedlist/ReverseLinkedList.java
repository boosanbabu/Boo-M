package dsa.leetcode.easy.linkedlist;

import dsa.leetcode.structures.ListNode;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		return reverseListRecursive(head);
	}

	public ListNode reverseListIterative(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode ptr = head;
		ListNode prev = null;
		while (ptr != null) {
			ListNode next = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = next;
		}
		return prev;
	}

	/**
	 * 1. Recurse till the last node (head.next==null)<br>
	 * 2. Return the last node itself<br>
	 * 3. While returning one level up, set next.next to node itself<br>
	 * 4. Dereference its current next<br>
	 * 5. Return that last node
	 */
	public ListNode reverseListRecursive(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverseListRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	public static void main(String args[]) {
		ReverseLinkedList rev = new ReverseLinkedList();
		ListNode head = new ListNode();
		head.val = 1;

		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		two.next = three;
		three.next = four;
		head.next = two;
		ListNode.listAsString(head);
		ListNode reversedHd = rev.reverseList(head);
		ListNode.listAsString(reversedHd);
	}
}
