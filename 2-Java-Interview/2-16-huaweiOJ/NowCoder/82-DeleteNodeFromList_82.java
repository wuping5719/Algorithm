package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午9:40:08
 */

class Node
{
    public int val;
    public Node next;
    public Node(int val)
    {
       this.val = val;
    }
}

public class DeleteNodeFromList_82 {
    // 参数: pHead: 头节点; preVal:上一节点值 ; nextVal: 插入节点值
   public static void insert(Node pHead, int preVal, int nextVal)
   {
       Node pNext = new Node(nextVal);
       Node pCurrent = pHead;
       while(pCurrent != null)
       {
           if(pCurrent.val == preVal)
           {
               pNext.next = pCurrent.next;
               pCurrent.next = pNext;
               break;
           }
           pCurrent = pCurrent.next;
       }
   }
   
   public static Node removeNode(Node pHead, int val)
   {
       if(pHead.val == val) {
	   pHead = pHead.next;
       }else {
	    Node pCurrent = pHead;
	    while (pCurrent != null) {
		if (pCurrent.next.val == val) {
		    pCurrent.next = pCurrent.next.next;
		    break;
		}
		pCurrent = pCurrent.next;
	    }
       }
       return pHead;
   }
   
   public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    //输入节点数
            int nodeNum = cin.nextInt();
            //输入头节点的值
            int headVal = cin.nextInt();
            //构造头节点
            Node pHead = new Node(headVal);
            for(int i=0; i<nodeNum-1; i++)
            {
                //插入节点值
                int nextVal = cin.nextInt();
                //前一节点值
                int preVal = cin.nextInt();
                //插入节点
                insert(pHead, preVal, nextVal);
            }
            
            int deleteVal = cin.nextInt();
            pHead = removeNode(pHead, deleteVal);
            Node pCurrent = pHead;
            while(pCurrent != null)
            {
        	System.out.print(pCurrent.val + " ");
        	pCurrent = pCurrent.next;
            }
            System.out.println();
	}
        cin.close();
    }

}
