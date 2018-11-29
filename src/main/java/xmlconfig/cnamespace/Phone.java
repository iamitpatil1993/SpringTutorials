package xmlconfig.cnamespace;

import org.springframework.beans.factory.InitializingBean;

/**
 * 
 * @author amit Bean created to demonstrate c-namepsace in xml configuration
 */

public class Phone implements InitializingBean {

	private SimCard simCard;
	private Battery battery;
	private String imeiNumber;

	public Phone(SimCard simCard, Battery battery, String imeiNumber) {
		this.simCard = simCard;
		this.battery = battery;
		this.imeiNumber = imeiNumber;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (simCard != null && battery != null && imeiNumber != null) {
			System.out.println("Phone is ready to use ...");
		} else {
			System.out.println("Phone not ready to use");
		}
	}
}
