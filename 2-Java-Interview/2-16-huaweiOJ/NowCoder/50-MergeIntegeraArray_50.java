package huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author WuPing
 * @version 2016年10月3日 下午10:03:00
 */

public class MergeIntegeraArray_50 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n1 = cin.nextInt();
            TreeSet<Integer> set = new TreeSet<Integer>();
            for(int i=0; i<n1; i++) {
        	set.add(cin.nextInt());
            }
            int n2 = cin.nextInt();
            for(int i=0; i<n2; i++) {
        	set.add(cin.nextInt());
            }
            
            for(Integer num : set) {
        	System.out.print(num + " ");
            }
            System.out.println();
        }
        cin.close();
    }

}
