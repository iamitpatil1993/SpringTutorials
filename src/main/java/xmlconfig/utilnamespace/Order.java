/**
 * 
 */
package xmlconfig.utilnamespace;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author amit Bean to demonstrate util:namepace
 */

public class Order implements InitializingBean {

	private List<String> items;

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (items != null) {
			System.out.println("Order contains :: ");
			items.stream().forEach(System.out::println);
		} else {
			System.out.println("Null items in Order bean");
		}
	}

}
