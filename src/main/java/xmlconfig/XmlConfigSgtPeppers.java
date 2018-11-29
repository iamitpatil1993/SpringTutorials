/**
 * 
 */
package xmlconfig;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author amit
 * This class is to demonstrate bean declaration/configuration using explicit XML configuration
 *
 */
public class XmlConfigSgtPeppers implements XmlConfigCompactDisk, BeanNameAware {
	
	private String id;
	
	@Override
	public void play() {
		System.out.println("Playing music from XmlConfigSgtPeppers disc. ID :: " + id);
	}

	@Override
	public void setBeanName(String name) {
		this.id = name;
	}
}
