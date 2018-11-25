package soundsystem;

import javax.inject.Named;

import org.springframework.beans.factory.BeanNameAware;

/**
 * 
 * @author amit
 * Bean created to demo use of @Named annotation to declare class as spring component and give it a custom bean Id.
 * We can use @named annotation as replacement of @Component annotation
 */

@Named("customBeanNameUsingNamedAnnotation")
public class NamedAnnotationDemoBean implements BeanNameAware {

	private String name;
	
	@Override
	public void setBeanName(String name) {
		this.name = name;
	}
	
	public void displayMyName() {
		System.out.println("My name is :: " + name);
	}
}
