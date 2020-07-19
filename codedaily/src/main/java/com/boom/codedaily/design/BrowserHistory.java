package com.boom.codedaily.design;

import java.util.*;

class BrowserHistory {

	class DLNode {
		String url;
		DLNode next, prev;

		public DLNode(String site) {
			url = site;
		}

		public String toString() {
			return url;
		}
	}

	Map<String, DLNode> urlMap;

	DLNode head, tail;
	DLNode curr;

	public BrowserHistory(String homepage) {
		head = new DLNode(homepage);
		urlMap = new HashMap<>();
		urlMap.put(homepage, head);
		curr = head;
		tail = head;
	}

	public void visit(String url) {

		DLNode head = new DLNode(url);
		if (curr != tail) {
			curr.next = head;
			head.prev = curr;
		} else {
			head.prev = tail;
			tail.next = head;
		}
		curr = head;
		tail = head;
	}

	public String back(int steps) {
		while (curr.prev != null && steps != 0) {
			steps--;
			curr = curr.prev;
		}
		System.out.println(curr.url);
		return curr.url;
	}

	public String forward(int steps) {
		while (curr.next != null && steps != 0) {
			steps--;
			curr = curr.next;
		}
		System.out.println(curr.url);
		return curr.url;
	}

	/**
	 * Your BrowserHistory object will be instantiated and called as such:
	 * BrowserHistory obj = new BrowserHistory(homepage); obj.visit(url); String
	 * param_2 = obj.back(steps); String param_3 = obj.forward(steps);
	 */
	public static void main(String[] args) {
		BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
		browserHistory.visit("google.com"); // You are in "leetcode.com". Visit "google.com"
		browserHistory.visit("facebook.com"); // You are in "google.com". Visit "facebook.com"
		browserHistory.visit("youtube.com"); // You are in "facebook.com". Visit "youtube.com"
		browserHistory.back(1); // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
		browserHistory.back(1); // You are in "facebook.com", move back to "google.com" return "google.com"
		browserHistory.forward(1); // You are in "google.com", move forward to "facebook.com" return "facebook.com"
		browserHistory.visit("linkedin.com"); // You are in "facebook.com". Visit "linkedin.com"
		browserHistory.forward(2); // You are in "linkedin.com", you cannot move forward any steps.
		browserHistory.back(2); // You are in "linkedin.com", move back two steps to "facebook.com" then to
								// "google.com". return "google.com"
		browserHistory.back(7); // You are in "google.com", you can move back only one step to "leetcode.com".
								// return "leetcode.com"
	}

}
