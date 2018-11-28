package javaconfig;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import config.ProjectConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
// We need to include ProjectConfiguration as well because our bean InjectionJavaConfigDemo2 has dependcy on 
// bean declared in ProjectConfiguration.
@ContextConfiguration(classes = {ProjectConfiguration.class, JavaConfiguration.class}, loader = AnnotationConfigContextLoader.class)
public class InjectionJavaConfigDemo2Test {

	@Autowired
	private InjectionJavaConfigDemo2 injectionJavaConfigDemo2;

	@Test
	public void test() {
		assertNotNull(injectionJavaConfigDemo2);
	}
}
