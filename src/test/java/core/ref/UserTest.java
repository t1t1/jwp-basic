package core.ref;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

import next.model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserTest {
	private static final Logger log = LoggerFactory.getLogger(UserTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Class<User> clazz = User.class;
		
		Constructor[] constructors = clazz.getConstructors();
//		Constructor[] constructors = clazz.getDeclaredConstructors();
		
		for (Constructor constructor : constructors) {
			log.debug("constructor.getName(): {}", constructor.getName()); // TODO; delete;
			log.debug("constructor.getParameterCount(): {}", constructor.getParameterCount()); // TODO; delete;
			
/*			
			ArrayList<Object> parameterList = new ArrayList<Object>();
			
			Class[] parameterTypes = constructor.getParameterTypes();
*/			
			
			Parameter[] parameters = constructor.getParameters();
			for (Parameter parameter : parameters) {
				log.debug("parameter.getType(): {}", parameter.getType()); // TODO; delete;
				log.debug("parameter.getName(): {}", parameter.getName()); // TODO; delete;
//				Class type = parameter.getType();
//				parameter.getName();
				
			}
			
			if (constructor.getParameterCount() == 4) {
				try {
					User user = (User) constructor.newInstance("arg0", "arg1", "arg2", "arg3");
					log.debug("user.toString(): {}", user.toString()); // TODO; delete;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
