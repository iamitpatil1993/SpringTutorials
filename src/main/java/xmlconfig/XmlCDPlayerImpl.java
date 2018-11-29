/**
 * 
 */
package xmlconfig;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author amit This bean is used to demonstrate dependency injection using
 *         explicit xml config and assigning custom id to bean in XML config
 */
public class XmlCDPlayerImpl implements XmlCDPlayer, BeanNameAware, InitializingBean {

	private String id;
	private XmlConfigCompactDisk compactDisk;

	public XmlCDPlayerImpl(XmlConfigCompactDisk compactDisk) {
		this.compactDisk = compactDisk;
	}

	@Override
	public void setBeanName(String name) {
		this.id = name;
	}

	@Override
	public void play() {
		System.out.println("Playing music from XmlCDPlayerImpl with bean ID :: " + id);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (compactDisk != null) {
			System.out.println("XmlCDPlayerImpl is ready to play music");
			compactDisk.play();
		} else {
			System.out.println("Insert compactDisc to play music.");
		}
	}
}
