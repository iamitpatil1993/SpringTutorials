/**
 * 
 */
package aop.xmlbased;

/**
 * @author amit
 * This is an aspect, which will advice Performance interface. It will be configured purely in xml.
 * So, this class will be normal Pojo
 *
 */

/**
 * NOTE: This is simply an POJO.
 */
public class XmlBasedAudiance {

	public void switchOffPhones() {
		System.out.println("Switcing off the phones from XmlBasedAudiance...");
	}

	public void takeSeat() {
		System.out.println("Taking seats from XmlBasedAudiance...");
	}

	public void applause() {
		System.out.println("CLAP CLAP CLAP!!! from XmlBasedAudiance ...");
	}

	public void demandRefund() {
		System.out.println("Demanding a refund from XmlBasedAudiance ...");
	}
}
