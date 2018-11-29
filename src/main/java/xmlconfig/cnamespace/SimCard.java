package xmlconfig.cnamespace;

import org.springframework.beans.factory.InitializingBean;

/**
 * 
 * @author amit
 * Bean created to demonstrate c-namepsace in xml configuration
 */

public class SimCard implements InitializingBean {
	
	private String brad;
	
	public SimCard(String brad) {
		this.brad = brad;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (brad != null) {
			System.out.println("Sim is activated for use with network : " + brad);
		}
	}
}
