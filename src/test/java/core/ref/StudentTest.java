package core.ref;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentTest {
	private static final Logger log = LoggerFactory.getLogger(StudentTest.class); 

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			
			Class<Student> clazz = Student.class;
			Student student = Student.class.newInstance();
//			Field targetField = clazz.getField("name");
			Field targetField = clazz.getDeclaredField("name");
			targetField.setAccessible(true);
			targetField.set(student, "ㅎㅎ");
			log.debug("student.getName(): {}", student.getName()); // TODO; delete;
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	}

}
