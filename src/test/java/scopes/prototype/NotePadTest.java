package scopes.prototype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import scopes.prototype.inheritence.StickyNote;

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
	
	@Test
	public void scopeInheritenceTest() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PrototypeScopeDemoJavaConfig.class);
		StickyNote stickyNote = applicationContext.getBean(StickyNote.class);
		StickyNote stickyNote1 = applicationContext.getBean(StickyNote.class);
		
		// Below assertions shows that Prototype scope of parent bean Notepad did not inherited and 
		// StickyNote bean is Singleton in scope as default.
		assertTrue(stickyNote instanceof StickyNote);
		assertTrue(stickyNote1 instanceof StickyNote);
		assertTrue(stickyNote == stickyNote1);
		assertEquals(stickyNote.hashCode(), stickyNote1.hashCode());
		
		applicationContext.close();
	}

}
