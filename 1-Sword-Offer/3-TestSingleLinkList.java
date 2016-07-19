package list;

import list.SingleLinkList;
import list.SingleLinkList.Value;

import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年4月11日 上午10:53:00
 */

public class TestSingleLinkList {

    public static void Test1() {
	System.out.println("1.链表有多个结点：");
	SingleLinkList list = new SingleLinkList();
        Value value1 = list.new Value(1, "Java");
        Value value2 = list.new Value(2, "JavaScript");
        Value value3 = list.new Value(3, "PHP");
        Value value4 = list.new Value(4, "C++");
        Value value5 = list.new Value(5, "Python");
        Value value6 = list.new Value(6, "Swift");
        //头插法插入链表
        list.add(value1);
        list.add(value2);
        list.add(value3);
        list.add(value4);
        list.add(value5);
        list.add(value6);
        
        //用栈保存链表的结点值信息
        System.out.print("正序打印链表结点的值:");
        Stack<String> stack = new Stack<String>();
        for(int i=0; i<list.size(); i++) {
            System.out.print(" " + list.getValueName(i));
            stack.push(list.getValueName(i));
        }
        System.out.println();
        
        //逆序打印链表结点的值
        System.out.print("逆序打印链表结点的值:");
        while(!stack.empty()) {
            String str = stack.pop();
            System.out.print(" " + str);
        }
        System.out.println();
       
        System.out.println("Remove Swift ? " + list.remove(value6));
        System.out.println("Have C++ ? " + list.contains(value4));
        System.out.println("List is emptry ? " + list.isEmpty());
        System.out.println(list);
        list.clear();
        System.out.println("List is emptry ? " + list.isEmpty());
    }
    
    public static void Test2() {
	System.out.println("2.链表只有一个结点：");
	SingleLinkList list = new SingleLinkList();
        Value value1 = list.new Value(1, "Java");
        //头插法插入链表
        list.add(value1);
        
        //用栈保存链表的结点值信息
        System.out.print("正序打印链表结点的值:");
        Stack<String> stack = new Stack<String>();
        for(int i=0; i<list.size(); i++) {
            System.out.print(" " + list.getValueName(i));
            stack.push(list.getValueName(i));
        }
        System.out.println();
        
        //逆序打印链表结点的值
        System.out.print("逆序打印链表结点的值:");
        while(!stack.empty()) {
            String str = stack.pop();
            System.out.print(" " + str);
        }
        System.out.println();
    }
    
    public static void Test3() {
	System.out.println("3.链表为空: ");
	SingleLinkList list = new SingleLinkList();
        
        //用栈保存链表的结点值信息
        System.out.print("正序打印链表结点的值:");
        Stack<String> stack = new Stack<String>();
        for(int i=0; i<list.size(); i++) {
            System.out.print(" " + list.getValueName(i));
            stack.push(list.getValueName(i));
        }
        System.out.println();
        
        //逆序打印链表结点的值
        System.out.print("逆序打印链表结点的值:");
        while(!stack.empty()) {
            String str = stack.pop();
            System.out.print(" " + str);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
	Test1();
	Test2();
	Test3();
    }
    
}
