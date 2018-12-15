/**
 * 
 */
package scopes.scopedproxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author amit
 * This is bean with larger bean scope i.e singleton, wherein we will inject bean with smaller scope. [Proptotyp]
 *
 */

/**
Conclusion:
	for each method call on prototype bean from singleton bean, new prototype bean will be created before method call and method will be called on new instance.
	if no method called on prototype bean, then not a single instance of prototype bean will be created.
**/	
@Component
public class SingletonBean {

	
	// 1. For each invocation of below bean, new instance will be created. If we this singleton bean calls two methods of prototype bean inside it's method it will create two prototype beans
	// 2. If method is called on this singleton bean which does not uses or call any method of this prototype bean, then no instance will be created.
	@Autowired
	private PrototypeBean bean;
	
	/**
	 * this method calls PrototypeBean 3 times, so before each invocation new bean created, so three instances of PrototypeBean will be created for single call of this method.
	 */
	public void sayHello() {
		bean.syaHello();
		bean.syaHello();
		bean.syaHello();
		System.out.println("----------------");
	}
	
	/**
	 * this method calls PrototypeBean 1 times, so before invocation new bean created, so only one new instances of PrototypeBean will be created for single call of this method.
	 */
	public void sayHello1() {
		bean.syaHello();
	}
	
	
	/**
	 * this method does not calls Prototype bean, so no instance of PrototypeBean will be created if this method of singleton bean is called.
	 */
	public void sayHello2() {
		System.out.println("hello from here, prototype bean not accessed here");
	}
	
}
