package interview;

/**
 * @author WuPing
 * @version 2016年8月4日 上午10:57:06
 */

@SuppressWarnings("serial")
class Annoyance extends Exception {
    
}

@SuppressWarnings("serial")
class Sneeze extends Annoyance {
    
}

public class ExceptionTest {

    public static void main(String[] args) throws Exception {
	try {
	    try {
		throw new Sneeze();
	    } catch (Annoyance a) {
		System.out.println("Caught Annoyance");
		throw a;
	    }
	} catch (Sneeze s) {
	    System.out.println("Caught Sneeze");
	    return;
	} finally {
	    System.out.println("Hello World!");
	}
    }
}
