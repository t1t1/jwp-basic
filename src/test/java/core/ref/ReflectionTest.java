package core.ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.model.Question;

public class ReflectionTest {
	private static final Logger log = LoggerFactory.getLogger(ReflectionTest.class);
	
	@Test
	public void showClass() {
		Class<Question> clazz = Question.class;
		log.debug(clazz.getName());
		
//		Field[] fields = clazz.getFields();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			log.debug("field.getName(): {}", field.getName()); // TODO; delete;
		}
		
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			log.debug("method.getName(): {}", method.getName()); // TODO; delete;
		}
		
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			log.debug("constructor.getName(): {}", constructor.getName()); // TODO; delete;
		}
		
	}
}
