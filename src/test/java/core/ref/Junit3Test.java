package core.ref;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Junit3Test {
	private static final Logger log = LoggerFactory.getLogger(Junit3Test.class);
	
	public void test1() throws Exception {
		System.out.println("Running Test1");
	}
	
	public void test2() throws Exception {
		System.out.println("Running Test2");
	}
	
	public void three() throws Exception {
		System.out.println("Running Test3");
	}
	
	public Junit3Test() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testTestMethods() throws Exception {
		Class<Junit3Test> clazz = Junit3Test.class;
		clazz.newInstance();
		
//		Method[] methods = clazz.getMethods();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			log.debug("method.getName(): {}", method.getName()); // TODO; delete;
			String methodName = method.getName();
			if (methodName.startsWith("test")) {
				if (methodName.startsWith("testTest")) {
					continue;
				}
				log.debug("method.getName(): {}: invoke", method.getName()); // TODO; delete;
				method.invoke(clazz.newInstance());
			}
		}
		
	}
}
