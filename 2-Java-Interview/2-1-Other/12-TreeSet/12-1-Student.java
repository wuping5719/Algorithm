package interview.treeSet;
/** 
 * @author  WuPing
 * @date 2016年8月4日 下午9:07:49 
 * @version 1.0 
 */
public class Student implements Comparable<Student> {
	private String name;        // 姓名
    private int age;            // 年龄

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;  // 比较年龄(年龄的升序)
    }
}
