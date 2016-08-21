package interview.huawei;
import java.util.*;
/** 
 * @author  WuPing
 * @date 2016年8月21日 下午9:02:42 
 * @version 1.0 
 */
public class AddTime {
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String[] strArr = in.nextLine().split(" ");
            int[] a = strToArr(strArr[0]);
            int[] b = strToArr(strArr[1]);
            String add = addTime(a,b);
            System.out.println(add);
        }
        in.close();
    }
    public static int[] strToArr(String str){
        String[] strA = str.split(":");
        int[] a = new int[strA.length];
        for(int i=0;i<strA.length;i++){
            a[i] = Integer.parseInt(strA[i]);
        }
        return a;
    }
    public static String addTime(int[] a,int[] b ){
        int sum = 0;
        String str="";
        sum += a[2] + b[2]; // 秒
        
        str = (sum%60<=9?("0"+sum%60): (sum%60) )+"";
        sum=sum/60;
        sum += a[1] + b[1]; // 分 
        str = (sum%60<=9?("0"+sum%60): (sum%60) )+":"+str;
        sum=sum/60;
        sum += a[0] + b[0]; // 时
        
        str = (sum%24<=9?("0"+sum%24): (sum%24) )+":"+str;
        sum =sum/24;
        return str;
    }
}
