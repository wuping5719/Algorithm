package swordOffer;
/** 
 * @author  WuPing
 * @date 2016年8月28日 下午3:37:10 
 * @version 1.0 
 */
public class NextNodeInBinaryTrees_58 {

	public static class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	
	public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
        	return null;
        }
        
        TreeLinkNode pNext = null;
        if(pNode.right != null){
        	TreeLinkNode pRight = pNode.right;
        	while(pRight.left != null){
        		pRight = pRight.left;
        	}
        	pNext = pRight;
        }else if(pNode.next != null){
        	TreeLinkNode pCurrent = pNode;
        	TreeLinkNode pParent = pNode.next;
        	while(pParent != null && pCurrent == pParent.right){
        		pCurrent = pParent;
        		pParent = pParent.next;
        	}
        	pNext = pParent;
        }
        return pNext;
    }
	
	public static void main(String[] args) {
		TreeLinkNode treeLinkNode1 = new TreeLinkNode(1);
		TreeLinkNode treeLinkNode2 = new TreeLinkNode(2);
		TreeLinkNode treeLinkNode3 = new TreeLinkNode(3);
		TreeLinkNode treeLinkNode4 = new TreeLinkNode(4);
		TreeLinkNode treeLinkNode5 = new TreeLinkNode(5);
		TreeLinkNode treeLinkNode6 = new TreeLinkNode(6);
		TreeLinkNode treeLinkNode7 = new TreeLinkNode(7);
		TreeLinkNode treeLinkNode8 = new TreeLinkNode(8);
		TreeLinkNode treeLinkNode9 = new TreeLinkNode(9);
		
		treeLinkNode1.left = treeLinkNode2;
		treeLinkNode1.right = treeLinkNode3;
		
		treeLinkNode2.left = treeLinkNode4;
		treeLinkNode2.right = treeLinkNode5;
		treeLinkNode2.next = treeLinkNode1;
		
		treeLinkNode3.left = treeLinkNode6;
		treeLinkNode3.right = treeLinkNode7;
		treeLinkNode3.next = treeLinkNode1;
		
		treeLinkNode4.next = treeLinkNode2;
		
		treeLinkNode5.left = treeLinkNode8;
		treeLinkNode5.right = treeLinkNode9;
		treeLinkNode5.next = treeLinkNode2;
		
		treeLinkNode6.next = treeLinkNode3;
		
		treeLinkNode7.next = treeLinkNode3;
		
		treeLinkNode8.next = treeLinkNode5;
		
		treeLinkNode9.next = treeLinkNode5;
		
		TreeLinkNode pNode = treeLinkNode1;
		TreeLinkNode pNext = GetNext(pNode);
		if(pNext != null){
			System.out.print(pNode.val + "'s next treeLinkNode is " + pNext.val);
		}else{
			System.out.print(pNode.val + "'s next treeLinkNode is null.");
		}
	}

}
