/**
 * 
 */
package scopes.scopedproxy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author amit
 * This bean has smaller scope and will be injected into larger scope. [Singleton]
 *
 */

@Component
// @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) -> If used this, if this bean is injected in singleton bean, only one instance of this bean will be created.
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS) // -> proxyMode causes bean creation every time before calling method on bean.
public class PrototypeBean {
	
	public PrototypeBean() {
		System.out.println("PrototypeBean created");
	}
	
	public void syaHello() {
		System.out.println("Hello...");
	}
}
