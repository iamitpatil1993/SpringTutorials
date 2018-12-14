package scopes.prototype;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author amit
 *
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PrototypeScopeDemoJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class NotePadTest {

	@Autowired
	private NotePad notePad;
	
	@Test
	public void test() {
		
		assertNotNull(notePad);
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PrototypeScopeDemoJavaConfig.class);
		NotePad notePad1 = applicationContext.getBean(NotePad.class);
		NotePad notePad2 = applicationContext.getBean(NotePad.class);
		
		assertNotEquals(notePad.hashCode(), notePad1.hashCode());
		assertNotEquals(notePad.hashCode(), notePad2.hashCode());
		assertNotEquals(notePad1.hashCode(), notePad2.hashCode());
		
		assertNotEquals(notePad.getCreatedDate(), notePad1.getCreatedDate());
		assertNotEquals(notePad.getCreatedDate(), notePad2.getCreatedDate());
		
		applicationContext.close();
		
	}

}
