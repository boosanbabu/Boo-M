package dsa.leetcode.medium.common;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {

	public static TreeNode sampleTree() {
		return constructTreeFromLevelOrder(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
	}

	/**
	 * 6, 3, 9, 2, 5, 8, 10, 1
	 * 
	 * @return
	 */
	public static TreeNode sampleBST() {
		return constructTreeFromLevelOrder(new Integer[] { 6, 3, 9, 2, 5, 8, 10, 1 });
	}

	public static boolean isBST(TreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBST(TreeNode root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}

		if (root.val < minValue || root.val > maxValue) {
			return false;
		}

		boolean isLeftNodeBST = isBST(root.left, minValue, root.val);
		boolean isRightNodeBST = isBST(root.right, root.val, maxValue);
		return isLeftNodeBST && isRightNodeBST;
	}

	public static TreeNode constructTreeFromLevelOrder(Integer... integers) {
		if (integers.length == 0)
			return null;

		TreeNode root = new TreeNode(integers[0]);
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int i = 0;
		while (!q.isEmpty()) {
			TreeNode curr = q.peek();
			if (i + 1 < integers.length) {
				TreeNode left = new TreeNode(integers[++i]);
				curr.left = left;
				q.offer(left);
			}
			if (i + 1 < integers.length) {
				TreeNode right = new TreeNode(integers[++i]);
				curr.right = right;
				q.offer(right);
			}
			q.remove();
		}
		return root;
	}

	public static void main(String a[]) {
		TreeNode root = TreeUtil.constructTreeFromLevelOrder(1, 1);
		BFS(root);
		System.out.println(isBST(root));
		System.out.println(isValidBST(root));
		TreeNode sampleBST = sampleBST();
		BFS(sampleBST);
		System.out.println(isBST(sampleBST));
		System.out.println("Inorder");
		TreeUtil.inOrder(root);
	}

	public static boolean isValidBST(TreeNode root) {
		return isVBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isVBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (root.val < min || root.val > max) {
			return false;
		}
		return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
	}

	public static void BFS(TreeNode root) {

		Deque<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode curr = q.poll();

			if (curr.left != null || curr.right != null) {

				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
			}
			System.out.print(curr.val + " ");
		}
	}

	public static void levelOrder(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode c = q.remove();

			if (c.left != null)
				q.add(c.left);
			if (c.right != null)
				q.add(c.right);
			System.out.print(c.val + " ");
		}
	}

	public static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

}
