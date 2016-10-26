package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年10月26日 下午9:17:24
 */

public class CloneGraph_19 {
  
    // 广度优先搜索
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	if (node == null) {
	    return null;
	}
	Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<>();
	Stack<UndirectedGraphNode> nodeSearched = new Stack<>();
	UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
	newNode.neighbors = node.neighbors;
	nodeSearched.push(newNode);
	nodeMap.put(newNode.label, newNode);
	while (!nodeSearched.empty()) {
	    UndirectedGraphNode curNode = nodeSearched.pop();
	    for (UndirectedGraphNode curNeighbor : curNode.neighbors) {
		if (nodeMap.get(curNeighbor.label) == null) {
		    UndirectedGraphNode copyNeighbor = new UndirectedGraphNode(
			    curNeighbor.label);
		    copyNeighbor.neighbors = curNeighbor.neighbors;
		    nodeSearched.push(copyNeighbor);
		    nodeMap.put(copyNeighbor.label, copyNeighbor);
		}
	    }
	}
	return newNode;
    }

    public static void main(String[] args) {
	UndirectedGraphNode node0 = new UndirectedGraphNode(0);
	UndirectedGraphNode node1 = new UndirectedGraphNode(1);
	UndirectedGraphNode node2 = new UndirectedGraphNode(2);
	
	ArrayList<UndirectedGraphNode> neighbors0 = new ArrayList<>();
	neighbors0.add(node1);
	neighbors0.add(node2);
	node0.neighbors = neighbors0;
	
	ArrayList<UndirectedGraphNode> neighbors1 = new ArrayList<>();
	neighbors1.add(node2);
	node1.neighbors = neighbors1;
	
	ArrayList<UndirectedGraphNode> neighbors2 = new ArrayList<>();
	neighbors2.add(node2);
	node2.neighbors = neighbors2;
	
	UndirectedGraphNode node = cloneGraph(node0);
	System.out.println(node.label);
    }

}
