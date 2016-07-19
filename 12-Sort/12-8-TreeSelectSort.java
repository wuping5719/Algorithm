package sort;
/** 
 * @author  WuPing
 * @date 2016年4月10日 下午11:32:35 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class TreeSelectSort {
    public static void treeSelectSort(int[] array){    
       int length = array.length;  
       int treeSize = 2 * length - 1;  //完全二叉树的节点数  
       int low = 0;  
       int[] tree = new int[treeSize];     //临时的树存储空间  
       //由后向前填充此树，索引从0开始  
       for(int i=length-1,j=0; i>=0; --i,j++){   //填充叶子节点  
           tree[treeSize-1-j] = array[i];  
       }  
         
       for(int i = treeSize-1;i>0;i-=2){ //填充非终端节点  
           tree[(i-1)/2] = tree[i-1] < tree[i] ? tree[i-1]:tree[i];  
       }  
         
       //不断移走最小节点  
       int minIndex;  
       while(low < length){  
           int min = tree[0];    //最小值  
           array[low++] = min;  
           minIndex = treeSize-1;         
           //找到最小值的索引  
           while(tree[minIndex]!=min){  
               minIndex--;  
           }  
           tree[minIndex] = Integer.MAX_VALUE;  //设置一个最大值标志  
           //找到其兄弟节点  
           while(minIndex > 0){      //如果其还有父节点  
               if(minIndex % 2 == 0){   //如果是右节点  
                   tree[(minIndex-1)/2] = tree[minIndex-1] < tree[minIndex] ? tree[minIndex-1]:tree[minIndex];  
                   minIndex = (minIndex-1)/2;  
               }else{                   //如果是左节点  
                    tree[minIndex/2] = tree[minIndex] < tree[minIndex+1] ? tree[minIndex]:tree[minIndex+1];  
                    minIndex = minIndex/2;  
               }  
           }    
       }  
    }  
}
