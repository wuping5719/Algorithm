package acmCoder;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年9月20日 下午8:06:32
 */

public class CombinationLock {

    /* 密码锁
     * 时间限制：C/C++语言 1000MS；其他语言 3000MS
                   内存限制：C/C++语言 65536KB；其他语言 589824KB
             题目描述：
                    作为一名新手特工，小B接受了大量的秘密间谍训练。检验她学业成就的时刻到了，她被派到一个基地去执行一项秘密任务，窃取该基地中一个尖端工艺的设计流程。
                    经过一系列惊险的过程，小B已经成功的抵达了目标区域。遗憾的是，目标区域高墙围挡，墙上还有电网和红外安保机制，她发现只能通过大门进入。
                    好在她已经成功的接近了大门，成功正在向她招手。大门是无人值守的，由电子密码组合锁控制。
                    几分钟前，她发现一名工作人员在终端上输入过密码，并打开了门进入其中。电子密码锁是一个方形的3x3数字键盘，上面有从1到9的数字按键。
                    小B推测密码是由不同的字符构成，且是沿按键中心对称的。她的热传感器能够探测上次按键的余温。
                   她希望验证一下密码是否是沿按键中心对称，这样就可以极大的减少她尝试的次数，你能帮她吗？
             输入:
                     输入中有多组测试数据。每组测试数据由3x3的矩阵构成，其中“X”表示按下的按键，“.” 表示未按下的按键。
                     矩阵中可能不包含“X”，也可能没有“.”。
             输出:
                     对每组测试数据，在单独的行中输出结果，若密码是沿中心对称的，输出YES，否则输出NO。
            样例输入:
       XX.
       ...
       .XX
       X.X
       X..
       ...
            样例输出:
       YES
       NO
    */

    public static String isCenterOfSymmetry(char[][] cipher) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<cipher.length; i++) {
            for(int j=0; j<cipher[0].length; j++) {
        	stack.push(cipher[i][j]);
            }
        }
        
        for(int i=0; i<cipher.length; i++) {
            for(int j=0; j<cipher[0].length; j++) {
        	if(cipher[i][j]!=stack.pop()) {
        	    return "No";
        	}
            }
        }
        if(stack.isEmpty()) {
            return "YES";
        }else {
            return "No";
        }
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	while(sc.hasNext()) {
	    int count = 0;
	    if(count==0) {
		char[][] cipher = new char[3][3];
		while(count<3) {
		    String str = sc.nextLine();
		    cipher[count] = str.toCharArray();
		    count++;  
		}
		String result = isCenterOfSymmetry(cipher);
		System.out.println(result);
		count = 0;
	    }
	}
	
	sc.close();
    }

}
