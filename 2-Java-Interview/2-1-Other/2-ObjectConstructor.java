package interview;

/**
 * @author WuPing
 * @version 2016年8月4日 上午9:42:10
 */

class A {
    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
    }
}

class B extends A{

    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
    }
}

public class ObjectConstructor {

    public static void main(String[] args) {
	@SuppressWarnings("unused")
	A ab = new B();
	ab = new B();
    }

}
