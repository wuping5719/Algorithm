package interview;
/** 
 * @author  WuPing
 * @date 2016年8月3日 下午9:17:02 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class CloneTest {

	public static void main(String[] args) {
		try {
            Person p1 = new Person("Ping Wu", 33, new Car("BMW", 300));
            Person p2 = MyUtil.clone(p1);   // 深度克隆
            p2.getCar().setBrand("Ferrari");
            // 修改克隆的Person对象p2关联的汽车对象的品牌属性
            // 原来的Person对象p1关联的汽车不会受到任何影响
            // 因为在克隆Person对象时其关联的汽车对象也被克隆了
            System.out.println(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
