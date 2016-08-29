package interview.youDao;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author WuPing
 * @date 2016年8月18日 下午10:26:25
 * @version 1.0
 */
public class ConstructQueue {
    public static LinkedList<Integer> constructQueue(int n){
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=n; i>=1; i--){
            list.addFirst(i);
            list.addFirst(list.removeLast());
        }
        return list;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
	int t = scan.nextInt();
        int n;
        LinkedList<Integer> result;
        while(t > 0){
            t--;
            n = scan.nextInt();
            result = constructQueue(n);
            for(int i=0; i<n-1; i++){
                System.out.print(result.removeFirst() + " ");
            }
            System.out.println(result.removeFirst());
        }
        scan.close();
    }
}
