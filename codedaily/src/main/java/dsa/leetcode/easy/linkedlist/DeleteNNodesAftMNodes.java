package dsa.leetcode.easy.linkedlist;

import dsa.leetcode.structures.ListNode;

/* 1474. Delete N Nodes After M Nodes of a Linked List

 * https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/
 * 
	Given the head of a linked list and two integers m and n. Traverse the linked list and remove some nodes in the following way:
	Start with the head as the current node.
	Keep the first m nodes starting with the current node.
	Remove the next n nodes
	Keep repeating steps 2 and 3 until you reach the end of the list.
	Return the head of the modified list after removing the mentioned nodes.
	
	Follow up question: How can you solve this problem by modifying the list in-place?
	
	Input: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3
	Output: [1,2,6,7,11,12]
	Explanation: Keep the first (m = 2) nodes starting from the head of the linked List  (1 ->2) show in black nodes.
	Delete the next (n = 3) nodes (3 -> 4 -> 5) show in read nodes.
	Continue with the same procedure until reaching the tail of the Linked List.
	Head of linked list after removing nodes is returned.
 */
public class DeleteNNodesAftMNodes {
	public ListNode deleteNodes(ListNode head, int m, int n) {
		ListNode ptr = head;
		while (ptr != null) {
			int i = 1;
			while (ptr.next != null && i < m) {
				ptr = ptr.next;
				i++;
			}
			int j = 0;
			ListNode jPtr = ptr.next;
			while (jPtr != null && j < n) {
				jPtr = jPtr.next;
				j++;
			}
			ptr.next = jPtr;
			ptr = ptr.next;
		}
		return head;
	}

	public static void main(String args[]) {
		DeleteNNodesAftMNodes rev = new DeleteNNodesAftMNodes();
		ListNode head = ListNode.arrayToList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		int m = 3;
		int n = 1;
		ListNode result = rev.deleteNodes(head, m, n);
		System.out.println(result);
	}
}
