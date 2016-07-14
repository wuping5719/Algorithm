package array;

/**
 * @author WuPing
 * @version 2016年4月8日 上午11:05:59
 */

public class ReplaceBlank {

    public static void replaceBlank(char strings[], int length) {
	// length为字符数组string的总容量
	if (strings != null && length > 0) {
	    int originalLength = 0; // 字符数组实际长度
	    int numberOfBlank = 0; // 字符数组中的空格数
	    int i = 0;
	    while (strings[i] != '\0') {
		++originalLength;

		if (strings[i] == ' ')
		    ++numberOfBlank;

		++i;
	    }

	    // newLength为把空格替换成'%20'之后的长度
	    int newLength = originalLength + numberOfBlank * 2;
	    if (newLength > length)
		return;

	    int indexOfOriginal = originalLength; // 字符数组起始扫描索引
	    int indexOfNew = newLength; // 替换空格后的字符数组起始扫描索引
	    while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
		// 从后向前扫描，遇到空格则替换成'%20'，否则直接复制字符
		if (strings[indexOfOriginal] == ' ') {
		    strings[indexOfNew--] = '0';
		    strings[indexOfNew--] = '2';
		    strings[indexOfNew--] = '%';
		} else {
		    strings[indexOfNew--] = strings[indexOfOriginal];
		}

		--indexOfOriginal;
	    }
	}
    }

    //空格在字符串中间
    public static void Test1(int length) {
	char[] test1Strings = new char[length];
	test1Strings[0] = 'h';
	test1Strings[1] = 'e';
	test1Strings[2] = 'l';
	test1Strings[3] = 'l';
	test1Strings[4] = 'o';
	test1Strings[5] = ' ';
	test1Strings[6] = 'w';
	test1Strings[7] = 'o';
	test1Strings[8] = 'r';
	test1Strings[9] = 'l';
	test1Strings[10] = 'd';
	test1Strings[11] = '\0'; // 模拟字符串结束符

	System.out.println("Test1 begin: ");
	System.out.print("替换空格前的字符数组：");
	for (int i = 0; i < test1Strings.length; i++) {
	    if (test1Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test1Strings[i]);
	}
	System.out.println();

	replaceBlank(test1Strings, length);

	System.out.print("替换空格后的字符数组：");
	for (int i = 0; i < test1Strings.length; i++) {
	    if (test1Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test1Strings[i]);
	}
	System.out.println();
    }

    //空格在字符串开头
    public static void Test2(int length) {
	char[] test2Strings = new char[length];
	test2Strings[0] = ' ';
	test2Strings[1] = 'h';
	test2Strings[2] = 'e';
	test2Strings[3] = 'l';
	test2Strings[4] = 'l';
	test2Strings[5] = 'o';
	test2Strings[6] = 'w';
	test2Strings[7] = 'o';
	test2Strings[8] = 'r';
	test2Strings[9] = 'l';
	test2Strings[10] = 'd';
	test2Strings[11] = '\0';  // 模拟字符串结束符

	System.out.println("Test2 begin: ");
	System.out.print("替换空格前的字符数组：");
	for (int i = 0; i < test2Strings.length; i++) {
	    if (test2Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test2Strings[i]);
	}
	System.out.println();

	replaceBlank(test2Strings, length);

	System.out.print("替换空格后的字符数组：");
	for (int i = 0; i < test2Strings.length; i++) {
	    if (test2Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test2Strings[i]);
	}
	System.out.println();
    }
    
    //空格在字符串末尾
    public static void Test3(int length) {
	char[] test3Strings = new char[length];
	test3Strings[0] = 'h';
	test3Strings[1] = 'e';
	test3Strings[2] = 'l';
	test3Strings[3] = 'l';
	test3Strings[4] = 'o';
	test3Strings[5] = 'w';
	test3Strings[6] = 'o';
	test3Strings[7] = 'r';
	test3Strings[8] = 'l';
	test3Strings[9] = 'd';
	test3Strings[10] = ' ';
	test3Strings[11] = '\0';  // 模拟字符串结束符

	System.out.println("Test3 begin: ");
	System.out.print("替换空格前的字符数组：");
	for (int i = 0; i < test3Strings.length; i++) {
	    if (test3Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test3Strings[i]);
	}
	System.out.println();

	replaceBlank(test3Strings, length);

	System.out.print("替换空格后的字符数组：");
	for (int i = 0; i < test3Strings.length; i++) {
	    if (test3Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test3Strings[i]);
	}
	System.out.println();
    }
    
    //字符串中有连续两个空格
    public static void Test4(int length) {
	char[] test4Strings = new char[length];
	test4Strings[0] = 'h';
	test4Strings[1] = 'e';
	test4Strings[2] = 'l';
	test4Strings[3] = 'l';
	test4Strings[4] = 'o';
	test4Strings[5] = ' ';
	test4Strings[6] = ' ';
	test4Strings[7] = 'w';
	test4Strings[8] = 'o';
	test4Strings[9] = 'r';
	test4Strings[10] = 'l';
	test4Strings[11] = 'd';
	test4Strings[12] = '\0';  // 模拟字符串结束符

	System.out.println("Test4 begin: ");
	System.out.print("替换空格前的字符数组：");
	for (int i = 0; i < test4Strings.length; i++) {
	    if (test4Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test4Strings[i]);
	}
	System.out.println();

	replaceBlank(test4Strings, length);

	System.out.print("替换空格后的字符数组：");
	for (int i = 0; i < test4Strings.length; i++) {
	    if (test4Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test4Strings[i]);
	}
	System.out.println();
    }
    
    //字符数组为null
    public static void Test5() {
	System.out.print("Test5 begin: ");
	replaceBlank(null, 0);
	System.out.println("passed!");
    }
    
    //字符串为空串
    public static void Test6(int length) {
	char[] test6Strings = new char[length];
	test6Strings[0] = '\0';  // 模拟字符串结束符

	System.out.println("Test6 begin: ");
	System.out.print("替换空格前的字符数组：");
	for (int i = 0; i < test6Strings.length; i++) {
	    if (test6Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test6Strings[i]);
	}
	System.out.println();

	replaceBlank(test6Strings, length);

	System.out.print("替换空格后的字符数组：");
	for (int i = 0; i < test6Strings.length; i++) {
	    if (test6Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test6Strings[i]);
	}
	System.out.println();
    }
    
    //字符串为一个空格
    public static void Test7(int length) {
	char[] test7Strings = new char[length];
	test7Strings[0] = ' ';  
	test7Strings[1] = '\0';  // 模拟字符串结束符

	System.out.println("Test7 begin: ");
	System.out.print("替换空格前的字符数组：");
	for (int i = 0; i < test7Strings.length; i++) {
	    if (test7Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test7Strings[i]);
	}
	System.out.println();

	replaceBlank(test7Strings, length);

	System.out.print("替换空格后的字符数组：");
	for (int i = 0; i < test7Strings.length; i++) {
	    if (test7Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test7Strings[i]);
	}
	System.out.println();
    }
    
    //字符串中没有空格
    public static void Test8(int length) {
	char[] test8Strings = new char[length];
	test8Strings[0] = 'h';
	test8Strings[1] = 'e';
	test8Strings[2] = 'l';
	test8Strings[3] = 'l';
	test8Strings[4] = 'o';
	test8Strings[5] = 'w';
	test8Strings[6] = 'o';
	test8Strings[7] = 'r';
	test8Strings[8] = 'l';
	test8Strings[9] = 'd';
	test8Strings[10] = '\0'; // 模拟字符串结束符

	System.out.println("Test8 begin: ");
	System.out.print("替换空格前的字符数组：");
	for (int i = 0; i < test8Strings.length; i++) {
	    if (test8Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test8Strings[i]);
	}
	System.out.println();

	replaceBlank(test8Strings, length);

	System.out.print("替换空格后的字符数组：");
	for (int i = 0; i < test8Strings.length; i++) {
	    if (test8Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test8Strings[i]);
	}
	System.out.println();
    }
    
    //字符串中全是空格
    public static void Test9(int length) {
	char[] test9Strings = new char[length];
	test9Strings[0] = ' ';
	test9Strings[1] = ' ';
	test9Strings[2] = ' ';
	test9Strings[3] = ' ';
	test9Strings[4] = '\0'; // 模拟字符串结束符

	System.out.println("Test9 begin: ");
	System.out.print("替换空格前的字符数组：");
	for (int i = 0; i < test9Strings.length; i++) {
	    if (test9Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test9Strings[i]);
	}
	System.out.println();

	replaceBlank(test9Strings, length);

	System.out.print("替换空格后的字符数组：");
	for (int i = 0; i < test9Strings.length; i++) {
	    if (test9Strings[i] == '\0') {
		break;
	    }
	    System.out.print(test9Strings[i]);
	}
	System.out.println();
    }
    
    public static void main(String[] args) {
	int length = 100;
	Test1(length);
	Test2(length);
	Test3(length);
	Test4(length);
	Test5();
	Test6(length);
	Test7(length);
	Test8(length);
	Test9(length);
    }

}
