package dsa.leetcode.medium.linkedlist;

import dsa.leetcode.structures.ListNode;

/*
 * 369. Plus One Linked List
 * https://leetcode.com/problems/plus-one-linked-list/
 *  Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
	You may assume the integer do not contain any leading zero, except the number 0 itself.
	The digits are stored such that the most significant digit is at the head of the list.
	
	Example :
	Input: [1,2,3]
	Output: [1,2,4]
 */
public class PlusOne {
	public ListNode plusOne(ListNode head) {
		if (head == null) {
			return head;
		}
		int c = plusOneDFS(head);
		if (c == 0)
			return head;
		ListNode n = new ListNode(1);
		n.next = head;
		return n;
	}

	public int plusOneDFS(ListNode head) {
		if (head == null) {
			return 1;
		}
		int c = plusOneDFS(head.next);
		if (c == 0) {
			return 0;
		}
		int s = head.val + 1;
		head.val = s % 10;
		return s / 10;
	}

	public static void main(String a[]) {
		ListNode head = ListNode.arrayToList(1, 3, 3, 4);
		PlusOne p = new PlusOne();
		ListNode res = p.plusOne(head);
		System.out.println(res);
	}
}
