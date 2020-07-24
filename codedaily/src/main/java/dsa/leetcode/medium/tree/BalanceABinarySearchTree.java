package dsa.leetcode.medium.tree;

import java.util.*;

import dsa.leetcode.medium.common.TreeNode;
import dsa.leetcode.medium.common.TreeUtil;

/*
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 * 
 * Given a binary search tree, return a balanced binary search tree with the same node values.
 * A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.
 * If there is more than one answer, return any of them.
 */
public class BalanceABinarySearchTree {

	public static void main(String[] args) {
		BalanceABinarySearchTree s = new BalanceABinarySearchTree();
		TreeNode bt = TreeUtil.sampleBST();
		TreeNode r = s.balanceBST(bt);
		TreeUtil.levelOrder(r);
		System.out.println();
		TreeUtil.inOrder(r);
	}

	public TreeNode balanceBST(TreeNode root) {
		List<Integer> elements = new ArrayList<>();
		inOrder(root, elements);
		return constructBST(elements, 0, elements.size() - 1);
	}

	private TreeNode constructBST(List<Integer> elements, int s, int e) {
		if (s > e)
			return null;
		int mid = (s + e) / 2;
		TreeNode root = new TreeNode(elements.get(mid));
		root.left = constructBST(elements, s, mid - 1);
		root.right = constructBST(elements, mid + 1, e);
		return root;
	}

	private void inOrder(TreeNode root, List<Integer> elements) {
		if (root == null)
			return;
		inOrder(root.left, elements);
		elements.add(root.val);
		inOrder(root.right, elements);
	}
}
