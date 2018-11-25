package soundsystem;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;
/**
 * @author amit
 * Declares first spring bean using Annotation configuration. 
 */

// Default bean name/is is : unqualified class name with first character in small case.
@Component("customNameForThisBean") // Used so that spring discovers this class as spring bean/component.
public class SgtPeppers implements CompactDisk, BeanNameAware {

	private String myName;
	
	@Override
	public void play() {
		System.out.println("Playing music from compact disc, bean Name :: " + myName);
	}

	/*
	 * We are implementing BeanNameAware interface because we want bean's name to display in play().
	 */
	@Override
	public void setBeanName(String name) {
		this.myName = name;
	}
}
