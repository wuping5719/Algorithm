package crackingCodingInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * @author  WuPing
 * @date 2016年8月30日 下午8:27:31 
 * @version 1.0 
 */
public class CheckPathUndirectedGraph_17 {

	 /* 根据邻接矩阵遍历
     *  利用栈, 首先a自身入栈以及其临街矩阵所有节点入栈, 入栈前都进行判断
     *  若该点邻居都不是b, 则该点出栈, 继续上述遍历
     *  为了防止环的产生, 已经入栈过的点不再入栈, 用map管理
     */
	public static boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
		return check(a,b) || check(b,a);
    }
	
	public static boolean check(UndirectedGraphNode a, UndirectedGraphNode b) {
	    if(a == null || b == null){
	        return false;
	    }
	    if(a == b){
	        return true;
	    }
	    HashMap<UndirectedGraphNode, Boolean> checkedMap = new HashMap<UndirectedGraphNode, Boolean>();
	    LinkedList<UndirectedGraphNode> searchQueue = new LinkedList<UndirectedGraphNode>();
	    searchQueue.push(a);
	    checkedMap.put(a, true);
	    while(!searchQueue.isEmpty()){
	        UndirectedGraphNode currentNode = searchQueue.pop();
	        if(currentNode.neighbors != null){
	            for(int i = 0; i < currentNode.neighbors.size(); i++){
	                UndirectedGraphNode neighbor = currentNode.neighbors.get(i);
	                if(neighbor != null){
	                    if(neighbor == b){
	                        return true;
	                    }
	                    if(checkedMap.get(neighbor) == null || !checkedMap.get(neighbor)){
	                        searchQueue.push(neighbor);
	                        checkedMap.put(neighbor, true);
	                    }      
	                }
	            }
	        }
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		UndirectedGraphNode a = new UndirectedGraphNode(1);
		UndirectedGraphNode b = new UndirectedGraphNode(2);
		UndirectedGraphNode c = new UndirectedGraphNode(3);
		UndirectedGraphNode d = new UndirectedGraphNode(4);
		
		ArrayList<UndirectedGraphNode> a_neighbors = new ArrayList<UndirectedGraphNode>();
		a_neighbors.add(c);
		a_neighbors.add(d);
		a.left = c;
		a.right = d;
		
		ArrayList<UndirectedGraphNode> b_neighbors = new ArrayList<UndirectedGraphNode>();
		b_neighbors.add(c);
		
		ArrayList<UndirectedGraphNode> c_neighbors = new ArrayList<UndirectedGraphNode>();
		c_neighbors.add(a);
		c_neighbors.add(b);
		c.right = b;
		
		ArrayList<UndirectedGraphNode> d_neighbors = new ArrayList<UndirectedGraphNode>();
		d_neighbors.add(a);
		
		boolean result = checkPath(a, b);
		System.out.println(result);
	}

}
