package crackingCodingInterview;

import java.util.ArrayList;

/** 
 * @author  WuPing
 * @date 2016年8月30日 下午8:51:18 
 * @version 1.0 
 */
public class UndirectedGraphNode {
	int label = 0;
    UndirectedGraphNode left = null;
    UndirectedGraphNode right = null;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}
