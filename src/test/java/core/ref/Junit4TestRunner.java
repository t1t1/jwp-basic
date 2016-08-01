package core.ref;

import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Junit4TestRunner {
	private static final Logger log = LoggerFactory.getLogger(Junit4TestRunner.class);
	
	@Test
	public void run() throws Exception {
		Class<Junit4Test> clazz = Junit4Test.class;
		
//		Method[] methods = clazz.getMethods();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			log.debug("method.getName(): {}", method.getName()); // TODO; delete
			log.debug("method.isAnnotationPresent(MyTest.class): {}", method.isAnnotationPresent(MyTest.class)); // TODO; delete;
			if (method.isAnnotationPresent(MyTest.class)) {
//				method.invoke(clazz);
//				method.invoke(Junit4Test.class);
				method.invoke(Junit4Test.class.newInstance());
			}
		}
		
		

	}
}
