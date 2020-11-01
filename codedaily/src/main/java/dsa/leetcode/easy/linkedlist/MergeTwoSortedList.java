package dsa.leetcode.easy.linkedlist;

import dsa.leetcode.structures.ListNode;
//jaswanth
public class MergeTwoSortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		return mergeTwoListsRecurse(l1, l2);
	}

	/**
	 * Not preferable as this could easily introduce stack overflow error in case of
	 * larger linked list, in real time
	 * 
	 */
	public ListNode mergeTwoListsRecurse(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode res;
		if (l1.val < l2.val) {
			res = l1;
			res.next = mergeTwoLists(l1.next, l2);
		} else {
			res = l2;
			res.next = mergeTwoLists(l1, l2.next);
		}
		return res;
	}

	public static void main(String args[]) {
		MergeTwoSortedList rev = new MergeTwoSortedList();
		ListNode l1 = ListNode.arrayToList(1, 3, 4);
		ListNode l2 = ListNode.arrayToList(1, 2, 5, 6);
		System.out.println("Input");
		ListNode.listAsString(l1);
		ListNode.listAsString(l2);

		System.out.println("\nOutput");
		ListNode newHead = rev.mergeTwoLists(l1, l2);
		ListNode.listAsString(newHead);
	}
}
