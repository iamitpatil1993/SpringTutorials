package javaconfig;

import org.springframework.beans.factory.BeanNameAware;

/**
 * 
 * @author amit
 * This class/bean is just to demo bean declaration using javaConfig
 */

public class SimpleJavaConfigDemoBean implements BeanNameAware {

	@Override
	public void setBeanName(String name) {
		System.out.println("Bean Id for SimpleJavaConfigDemoBean is :: " + name);
	}
}
