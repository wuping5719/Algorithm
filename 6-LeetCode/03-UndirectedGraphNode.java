package leetcode;

import java.util.ArrayList;

/**
 * @author WuPing
 * @version 2016年10月26日 下午9:07:50
 */

public class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
	label = x;
	neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
