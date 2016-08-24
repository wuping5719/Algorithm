package swordOffer;
/** 
 * @author  WuPing
 * @date 2016年8月24日 下午11:05:14 
 * @version 1.0 
 */
public class CopyComplextList_26 {

	public static RandomListNode Clone(RandomListNode pHead)
    {
		CloneNodes(pHead);
		ConnectRandomNodes(pHead);
		return ReconnectNodes(pHead);
    }
	
	public static void CloneNodes (RandomListNode pHead)
    {
		RandomListNode pNode = pHead;
		while(pNode != null){
			RandomListNode pCloned = new RandomListNode(pNode.val);
			pCloned.next = pNode.next;
			pCloned.random = null;
			
			pNode.next = pCloned;
			pNode = pCloned.next;
		}
    }
	
	public static void ConnectRandomNodes (RandomListNode pHead)
    {
		RandomListNode pNode = pHead;
		while(pNode != null){
			RandomListNode pCloned = pNode.next;
			if(pNode.random !=null){
				pCloned.random = pNode.random.next;
			}
			pNode = pCloned.next;
		}
    }
	
	public static RandomListNode ReconnectNodes (RandomListNode pHead)
    {
		RandomListNode pNode = pHead;
		RandomListNode pClonedHead = null;
		RandomListNode pClonedNode = null;
		
		if(pNode != null){
			pClonedHead = pClonedNode = pNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		
		while(pNode != null){
			pClonedNode.next = pNode.next;
			pClonedNode = pClonedNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		
		return pClonedHead;
    }
	
	public static void main(String[] args) {
		RandomListNode randomListNode1 = new RandomListNode(1);
		RandomListNode randomListNode2 = new RandomListNode(2);
		RandomListNode randomListNode3 = new RandomListNode(3);
		RandomListNode randomListNode4 = new RandomListNode(4);
		RandomListNode randomListNode5 = new RandomListNode(5);

		randomListNode1.next = randomListNode2;
		randomListNode1.random = randomListNode3;
		randomListNode2.next = randomListNode3;
		randomListNode2.random = randomListNode5;
		randomListNode3.next = randomListNode4;
		randomListNode4.next = randomListNode5;
		randomListNode4.random = randomListNode2;
		
		RandomListNode pClonedHead = Clone(randomListNode1);
		System.out.println(pClonedHead.val);
		System.out.println(pClonedHead.next.random.val);
	}

}
