package acmCoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月19日 下午4:51:51
 */

public class DigitalGame {

    /*
            数字游戏:
                 时间限制：C/C++语言 1000MS；其他语言 3000MS
                 内存限制：C/C++语言 65536KB；其他语言 589824KB
           题目描述：
                 真是一个无聊的夜晚啊，小B和小C在宿舍中实在无聊之极，因此决定玩一个数字游戏打发时间。小B首先开始，她给小C的问题是：
                 给定任意一个整数，小C可以交换该数中任意的不同位，能够得到的最小数值是多少？前提是不能有前导0。
                 小C很快就给出了一个答案，小B希望你来帮她检验答案的正确性，你能帮忙吗？
            输入:
                 输入中有多组测试数据。每组测试数据的第一行为一个没有前导0的整数n（0=< n =< 10^9），第二行为另一个整数m（0=<m=<10^9），小C给出的问题答案。
            输出:
                 对每组测试数据，在单独的行中输出结果，若小C的答案是正确的，输出YES，否则输出NO。
            样例输入:
      3310
      1033
      4
      5
           样例输出:
      YES
      NO
    */
    
    public static String MIsMinNumOfN(long n, long m) {
	char[] tempArrayN = String.valueOf(n).toCharArray();
	
	Arrays.sort(tempArrayN);
	StringBuffer sb = new StringBuffer();
	char first = tempArrayN[0];
	int currentIndex = 0;
	while(currentIndex<tempArrayN.length) {
	    if(tempArrayN[currentIndex]=='0') {
		currentIndex++;
	    }else {
		break;
	    }
	}
	first = tempArrayN[currentIndex];
	
	sb.append(first);
	for(int i=1; i<tempArrayN.length; i++) {
	    if(i==currentIndex) {
		sb.append(0);
	    }else {
		sb.append(tempArrayN[i]);
	    }
	}
	
	String res;
	if(sb.toString().equals(String.valueOf(m))) {
	    res = "YES";
	}else {
	    res = "NO";
	}
	
	return res;
    }
     
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()) {
	    long n = sc.nextLong();
	    long m = sc.nextLong();
	    String result = MIsMinNumOfN(n, m);
	    System.out.println(result);
	}
	sc.close();
    }

}
