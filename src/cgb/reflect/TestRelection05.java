package cgb.reflect;
import java.lang.reflect.Field;

import cgb.annotation.Autowired;
interface IContainer{}
class ArrayContainer implements IContainer{}
class LinkedContainer implements IContainer{}
class Producer{
	@Autowired
	private IContainer container;
}
class Consumer{
	@Autowired
	private ArrayContainer container;
}
public class TestRelection05 {
    public static void main(String[] args)
    throws Exception{
		Class<?> c=Class.forName("cgb.reflect.Producer");
		//获取类中所有属性
		Field[] fs=c.getDeclaredFields();
		for(Field f:fs){
			if(f.isAnnotationPresent(Autowired.class)){
				//获取spring容器
				//从spring容器中依据类型查找对象
				Class<?> fcls=f.getType();
				System.out.println(fcls);
				//然后将对象的值赋值给此属性
			}
		}
	}
}
