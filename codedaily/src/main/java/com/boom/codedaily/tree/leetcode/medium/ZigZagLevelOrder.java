package com.boom.codedaily.tree.leetcode.medium;

import java.util.*;

import com.boom.codedaily.common.TreeNode;

public class ZigZagLevelOrder {
	/**
	 * BFS solution using Linkedlist.Each level switch between addFirst and add
	 * methods. <br>
	 * It will be tempting to think, in add left child to queue first and add right
	 * next and vice versa each level, but it won't work. <br>
	 * Instead it is cleaner and easier to use the same USUAL level order, with
	 * LinkedList by changing addLast and addFirst depending on direction.
	 * LinkedList serves as reverse order list (using addLast, addFirst)
	 * 
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) return new ArrayList<List<Integer>>(0);

		boolean isReversedOrder = true;
		List<List<Integer>> result = new ArrayList<>();
		Deque<TreeNode> dq = new LinkedList<TreeNode>();
		dq.add(root);
		while (!dq.isEmpty()) {
			LinkedList<Integer> nodes = new LinkedList<>();
			int size = dq.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = dq.remove();

				if (!isReversedOrder) nodes.addFirst(curr.val);
				else nodes.addLast(curr.val);

				if (curr.left != null) dq.addLast(curr.left);
				if (curr.right != null) dq.addLast(curr.right);
			}
			result.add(nodes);
			isReversedOrder = !isReversedOrder;
		}
		return result;
	}
}
