package com.boom.codedaily.tree.leetcode.medium;

import com.boom.codedaily.common.TreeNode;
import com.boom.codedaily.common.TreeUtil;

/**
 * Leetcode 617 : https://leetcode.com/problems/merge-two-binary-trees/
 * 
 * Given two binary trees and imagine that when you put one of them to cover the
 * other, some nodes of the two trees are overlapped while the others are not.
 * 
 * You need to merge them into a new binary tree. The merge rule is that if two
 * nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 */
public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;
		t1.val += t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}

	public static void main(String[] args) {
		TreeNode t1 = TreeUtil.constructTreeFromLevelOrder(1, 2, 3, 4, 5, 6);
		TreeNode t2 = TreeUtil.constructTreeFromLevelOrder(3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		MergeTwoBinaryTrees o = new MergeTwoBinaryTrees();
		TreeUtil.levelOrder(o.mergeTrees(t1, t2));
	}
}
