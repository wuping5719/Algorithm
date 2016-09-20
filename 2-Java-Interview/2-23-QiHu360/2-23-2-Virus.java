package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月20日 下午8:48:34
 */

public class Virus {

    /* 病毒
               时间限制：C/C++语言 1000MS；其他语言 3000MS
               内存限制：C/C++语言 65536KB；其他语言 589824KB
               题目描述：
                       小B最近对破解和程序攻击产生了兴趣，她迷上了病毒，然后可怕的事情就发生了。
                       不知道什么原因，可能是小B的技术水平还不够高，小B编写的病毒程序在攻击一个服务器时出现了问题。
                       尽管成功的侵入了服务器，但并没有按照期望的方式发挥作用。
                       小B的目的很简单:控制服务器的内存区域，试图在内存中装入从1到n之间的n个自然数，以覆盖内存区域。
                       可能是小B对编程理解上的问题，病毒似乎没有完全成功。可能是由于保护机制的原因，内存写入只接受二进制的形式，
                       所以十进制表达中除0和1之外的其他值都没有成功写入内存。小B希望知道，究竟有多少数成功的写入了服务器的内存！
                输入:
                       输入中有多组测试数据。每组测试数据在单独的一行中，为整数n(1<=n <=10^9)。
                输出:
                        对每组测试数据，在单独的行中输出问题的答案。
                样例输入:
          10
          20
                样例输出:
          2
          3
      Hint:
                         对应n=10，成功写入的值为1和10。
    */

    public static long getNumOfToMemory(long n) {
	long count = 0;
	for(int i=1; i<=n; i++) {
	    if(isCanWriteMemory(i)) {
		count++;
	    }
	}
	return count;
    }
    
    public static boolean isCanWriteMemory(long n) {
	String str = String.valueOf(n);
	char[] array = str.toCharArray();
	for(int i=0; i<array.length; i++) {
	    if(array[i]>'1') {
		return false;
	    }
	}
	return true;
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while(sc.hasNext()) {
	   long n = sc.nextLong();
	   long result = getNumOfToMemory(n);
	   System.out.println(result);
	}
	sc.close();
    }

}
