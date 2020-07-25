package dsa.leetcode.structures;

public class ListNode {
	public ListNode next;
	public int val;

	public ListNode() {
	}

	public ListNode(int i) {
		val = i;
	}

	public String toString() {
		return listAsString(this);
	}

	public static String listAsString(ListNode node) {
		if (node == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		while (node != null) {
			sb.append(node.val).append(" ");
			node = node.next;
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	public static ListNode arrayToList(int... a) {
		ListNode li = new ListNode(0);
		ListNode ptr = li;
		for (int i : a) {
			ptr.next = new ListNode(i);
			ptr = ptr.next;
		}
		return li.next;
	}
}
