package sort;
import java.util.Random;
/** 
 * @author  WuPing
 * @date 2016年4月2日 下午10:27:00 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 100;
		int[] arrayA = new int[N];
		int[] arrayB = new int[N];
	   	for (int i = 0; i < N; i++) {
	         Random radomNum = new Random();
	         arrayB[i] = radomNum.nextInt(90);
	   	}
	   	
	   	System.out.println("冒泡排序前的整形数组：");
	   	for (int i = 0; i < N; i++) {
	   		arrayA[i]=arrayB[i];
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	long bubbleSortStartTime=System.nanoTime();   //获取开始时间
	   	BubbleSort.bubbleSort(arrayA);
        long bubbleSortEndTime=System.nanoTime();     //获取结束时间
        System.out.println("冒泡排序执行时间： "+(bubbleSortEndTime-bubbleSortStartTime)+"ns");
	   	System.out.println("冒泡排序后的整形数组：");
	   	for (int i = 0; i < arrayA.length; i++) {
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	
	   	System.out.println();
	    System.out.println("选择排序前的整形数组：");
	   	for (int i = 0; i < N; i++) {
	   		arrayA[i]=arrayB[i];
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	long selectSortStartTime=System.nanoTime();   //获取开始时间
	    SelectSort.selectSort(arrayA);
        long selectSortEndTime=System.nanoTime();     //获取结束时间
        System.out.println("选择排序执行时间： "+(selectSortEndTime-selectSortStartTime)+"ns");
	   	System.out.println("选择排序后的整形数组：");
	   	for (int i = 0; i < arrayA.length; i++) {
	        System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	
	   	System.out.println();
	    System.out.println("插入排序前的整形数组：");
	   	for (int i = 0; i < N; i++) {
	   		arrayA[i]=arrayB[i];
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	long insertSortStartTime=System.nanoTime();   //获取开始时间
	    InsertSort.insertSort(arrayA);
        long insertSortEndTime=System.nanoTime();     //获取结束时间
        System.out.println("插入排序执行时间： "+(insertSortEndTime-insertSortStartTime)+"ns");
	   	System.out.println("插入排序后的整形数组：");
	   	for (int i = 0; i < arrayA.length; i++) {
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	
	   	System.out.println();
	    System.out.println("快速排序前的整形数组：");
	   	for (int i = 0; i < N; i++) {
	   		arrayA[i]=arrayB[i];
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	long quickSortStartTime=System.nanoTime();   //获取开始时间
	   	QuickSort.sort(arrayA);
        long quickSortEndTime=System.nanoTime();     //获取结束时间
        System.out.println("快速排序执行时间： "+(quickSortEndTime-quickSortStartTime)+"ns");
	   	System.out.println("快速排序后的整形数组：");
	   	for (int i = 0; i < arrayA.length; i++) {
	        System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	
	   	System.out.println();
	    System.out.println("堆排序前的整形数组：");
	   	for (int i = 0; i < N; i++) {
	   		arrayA[i]=arrayB[i];
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	long heapSortStartTime=System.nanoTime();   //获取开始时间
	   	HeapSort.heapSort(arrayA);
        long heapSortEndTime=System.nanoTime();     //获取结束时间
        System.out.println("堆排序执行时间： "+(heapSortEndTime-heapSortStartTime)+"ns");
	   	System.out.println("堆排序后的整形数组：");
	   	for (int i = 0; i < arrayA.length; i++) {
	        System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	
		System.out.println();
	    System.out.println("希尔排序前的整形数组：");
	   	for (int i = 0; i < N; i++) {
	   		arrayA[i]=arrayB[i];
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	long shellSortStartTime=System.nanoTime();   //获取开始时间
	   	ShellSort.shellSort(arrayA);
        long shellSortEndTime=System.nanoTime();     //获取结束时间
        System.out.println("希尔排序执行时间： "+(shellSortEndTime-shellSortStartTime)+"ns");
	   	System.out.println("希尔排序后的整形数组：");
	   	for (int i = 0; i < arrayA.length; i++) {
	        System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	
	   	System.out.println();
	    System.out.println("归并排序前的整形数组：");
	   	for (int i = 0; i < N; i++) {
	   		arrayA[i]=arrayB[i];
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	long mergeSortStartTime=System.nanoTime();   //获取开始时间
	   	MergeSort.mergeSort(arrayA);
        long mergeSortEndTime=System.nanoTime();     //获取结束时间
        System.out.println("归并排序执行时间： "+(mergeSortEndTime-mergeSortStartTime)+"ns");
	   	System.out.println("归并排序后的整形数组：");
	   	for (int i = 0; i < arrayA.length; i++) {
	        System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	
	   	System.out.println();
	    System.out.println("计数排序前的整形数组：");
	   	for (int i = 0; i < N; i++) {
	   		arrayA[i]=arrayB[i];
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	long countSortStartTime=System.nanoTime();   //获取开始时间
	   	CountSort.countSort(arrayA);
        long countSortEndTime=System.nanoTime();     //获取结束时间
        System.out.println("计数排序执行时间： "+(countSortEndTime-countSortStartTime)+"ns");
	   	System.out.println("计数排序后的整形数组：");
	   	for (int i = 0; i < arrayA.length; i++) {
	        System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	
	   	System.out.println();
	    System.out.println("桶排序前的整形数组：");
	   	for (int i = 0; i < N; i++) {
	   		arrayA[i]=arrayB[i];
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	long bucketSortStartTime=System.nanoTime();   //获取开始时间
	   	BucketSort.bucketSort(arrayA);
        long bucketSortEndTime=System.nanoTime();     //获取结束时间
        System.out.println("桶排序执行时间： "+(bucketSortEndTime-bucketSortStartTime)+"ns");
	   	System.out.println("桶排序后的整形数组：");
	   	for (int i = 0; i < arrayA.length; i++) {
	        System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	
	   	System.out.println();
	    System.out.println("基数排序前的整形数组：");
	   	for (int i = 0; i < N; i++) {
	   		arrayA[i]=arrayB[i];
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	long radixSortStartTime=System.nanoTime();   //获取开始时间
	   	RadixSort.radixSort(arrayA);
        long radixSortEndTime=System.nanoTime();     //获取结束时间
        System.out.println("基数排序执行时间： "+(radixSortEndTime-radixSortStartTime)+"ns");
	   	System.out.println("基数排序后的整形数组：");
	   	for (int i = 0; i < arrayA.length; i++) {
	        System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	
	   	System.out.println();
	    System.out.println("折半插入排序前的整形数组：");
	   	for (int i = 0; i < N; i++) {
	   		arrayA[i]=arrayB[i];
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	long binaiSortStartTime=System.nanoTime();   //获取开始时间
	   	BinaiSort.binaiSort(arrayA);
        long binaiSortEndTime=System.nanoTime();     //获取结束时间
        System.out.println("折半插入排序执行时间： "+(binaiSortEndTime-binaiSortStartTime)+"ns");
	   	System.out.println("折半插入排序后的整形数组：");
	   	for (int i = 0; i < arrayA.length; i++) {
	        System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	
		System.out.println();
	    System.out.println("2路插入排序前的整形数组：");
	   	for (int i = 0; i < N; i++) {
	   		arrayA[i]=arrayB[i];
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	long twoSortStartTime=System.nanoTime();   //获取开始时间
	   	TwoSort.twoSort(arrayA);
        long twoSortEndTime=System.nanoTime();     //获取结束时间
        System.out.println("2路插入排序执行时间： "+(twoSortEndTime-twoSortStartTime)+"ns");
	   	System.out.println("2路插入排序后的整形数组：");
	   	for (int i = 0; i < arrayA.length; i++) {
	        System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	
	   	System.out.println();
	    System.out.println("树形选择排序前的整形数组：");
	   	for (int i = 0; i < N; i++) {
	   		arrayA[i]=arrayB[i];
	   		System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	   	long treeSelectSortStartTime=System.nanoTime();   //获取开始时间
	   	TreeSelectSort.treeSelectSort(arrayA);
        long treeSelectSortEndTime=System.nanoTime();     //获取结束时间
        System.out.println("树形选择排序执行时间： "+(treeSelectSortEndTime-treeSelectSortStartTime)+"ns");
	   	System.out.println("树形选择排序后的整形数组：");
	   	for (int i = 0; i < arrayA.length; i++) {
	        System.out.print(arrayA[i] + " ");
	   	}
	   	System.out.println();
	}

}
