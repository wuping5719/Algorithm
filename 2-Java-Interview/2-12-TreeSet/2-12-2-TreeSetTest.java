package interview.treeSet;

import java.util.Set;
import java.util.TreeSet;

/** 
 * @author  WuPing
 * @date 2016年8月4日 下午9:13:02 
 * @version 1.0 
 */
public class TreeSetTest {

	public static void main(String[] args) {
		Set<Student> set = new TreeSet<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        set.add(new Student("Ping Wu", 26));
        set.add(new Student("Yuan Liu", 25));
        set.add(new Student("Xiao Wang", 32));
        set.add(new Student("Maya Yin", 24));

        for(Student stu : set) {
            System.out.println(stu);
        }
	}

}
