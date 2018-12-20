/**
 * 
 */
package aop.annotatiobased;

/**
 * @author amit
 * Interface to be implemented by beans, this interface's perform() method is adviced by aspects.
 */

@FunctionalInterface
public interface Performance {

	/**
	 * This method invocation will be advised
	 */
	void perform();
}
