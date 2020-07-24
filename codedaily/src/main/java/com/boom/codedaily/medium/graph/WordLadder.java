package com.boom.codedaily.medium.graph;

import java.util.*;

public class WordLadder {
	class Node {
		String str;
		int level;

		public Node(String beginWord, int i) {
			str = beginWord;
			level = i;
		}
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Map<String, Set<String>> graph = preProcessToBuildGraph(wordList, beginWord.length());
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(beginWord, 1));
		Set<String> visited = new HashSet<>();
		while (!q.isEmpty() && !visited.contains(endWord)) {
			Node curr = q.remove();
			int l = curr.level;
			for (String currWordVariant : getAllNextWordTemplates(curr.str)) {
				Set<String> matchingWords = graph.getOrDefault(currWordVariant, new HashSet<>());
				if (matchingWords.contains(endWord))
					return l + 1;
				for (String nextWord : matchingWords) {
					if (!visited.contains(nextWord)) {
						q.add(new Node(nextWord, l + 1));
						visited.add(nextWord);
					}
				}
			}
		}
		return 0;
	}

	private Map<String, Set<String>> preProcessToBuildGraph(List<String> wordList, int len) {
		Map<String, Set<String>> graph = new HashMap<>();
		for (String str : wordList) {
			for (String key : getAllNextWordTemplates(str)) {
				Set<String> words = graph.getOrDefault(key, new HashSet<>());
				words.add(str);
				graph.put(key, words);
			}
		}
		return graph;
	}

	private Set<String> getAllNextWordTemplates(String str) {
		Set<String> neighbours = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			String newStr = (i == 0 ? "" : str.substring(0, i)) + "*" + str.substring(i + 1);
			neighbours.add(newStr);
		}
		return neighbours;
	}

	public static void main(String[] args) {
		WordLadder w = new WordLadder();
		int r = w.ladderLength("dog", "map", Arrays.asList("fog", "fot", "dog", "lot", "hot", "hom", "rom", "com",
				"map", "fap", "fam", "cam", "cog"));
		System.out.println(r);
	}

}
