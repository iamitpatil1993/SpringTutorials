/**
 * 
 */
package aop.annotatiobased.introduction;

/**
 * @author amit
 * This is a class/bean which actually provides implementation of Encoreable interface.
 * When any method in Encoreable interface is called on traget bean, all those method calls will be delegated to this class/bean.
 * So, we it's like target bean's (adviced) functionality is divided into multiple classes(bean and one/more aspects).
 *
 */

/** NOTE: THis class is not delcared as a bean. So, it will never injected via Encoreable.
 *  So, where Encoreable is injected, it won't be instance of AnnotationBasedDefaultEncoreable, rather it will be target bean
 *  of aspect into which we are introducing  Encoreable implementation.
 *  
 *  This class will only come into picture, when any method from Encoreable is called on PROXY, in that case that call will not 
 *  go to actual bean, rather it will be delegated to this implementatin class.
 */
public class AnnotationBasedDefaultEncoreable implements Encoreable {

	@Override
	public void performEncore() {
		System.out.println("Performing encore from delegate...");
	}
}
