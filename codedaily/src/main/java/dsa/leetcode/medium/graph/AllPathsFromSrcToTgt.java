package dsa.leetcode.medium.graph;

import java.util.*;

/**
	Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
	
	The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
	
	Example:
	Input: [[1,2], [3], [3], []] 
	Output: [[0,1,3],[0,2,3]] 
	Explanation: The graph looks like this:
	0--->1
	|    |
	v    v
	2--->3
	There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
	Note:
	
	The number of nodes in the graph will be in the range [2, 15].
	You can print different paths in any order, but you should keep the order of nodes inside one path.

 * @author boosanbabu
 *
 */
public class AllPathsFromSrcToTgt {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        backTrack(graph, res, temp, 0);
        return res;
    }
     /*
    * We are not using visited set - as it is mentioned to be D-Acyclic-G
    */
    public void backTrack(int[][] graph, List<List<Integer>> res, List<Integer> temp, int currNode ){
        if(currNode == graph.length - 1){//When last node is met.
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int node: graph[currNode]){
            temp.add(node);
            backTrack(graph,res,temp,node);
            temp.remove(temp.size()-1);
        }
    }
}
