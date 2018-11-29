/**
 * 
 */
package xmlconfig;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author amit This bean is used to demonstrate dependency injection using
 *         explicit xml config and assigning custom id to bean in XML config
 */
public class XmlCDPlayerImpl implements XmlCDPlayer, BeanNameAware {

	private String id;

	@Override
	public void setBeanName(String name) {
		this.id = name;
	}

	@Override
	public void play() {
		System.out.println("Playing music from XmlCDPlayerImpl with bean ID :: " + id);
	}
}
