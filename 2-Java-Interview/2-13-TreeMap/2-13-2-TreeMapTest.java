package interview.treeMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** 
 * @author  WuPing
 * @date 2016年8月4日 下午9:18:32 
 * @version 1.0 
 */
public class TreeMapTest {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        list.add(new Student("Ping Wu", 26));
        list.add(new Student("Yuan Liu", 25));
        list.add(new Student("Xiao Wang", 32));
        list.add(new Student("Maya Yin", 24));

        // 通过sort方法的第二个参数传入一个Comparator接口对象
        // 相当于是传入一个比较对象大小的算法到sort方法中
        // 由于Java中没有函数指针、仿函数、委托这样的概念
        // 因此要将一个算法传入一个方法中唯一的选择就是通过接口回调
        Collections.sort(list, new Comparator<Student> () {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());    // 比较学生姓名
            }
        });

        for(Student stu : list) {
            System.out.println(stu);
        }
	}

}
