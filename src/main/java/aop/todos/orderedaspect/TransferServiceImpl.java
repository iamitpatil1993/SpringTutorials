/**
 * 
 */
package aop.todos.orderedaspect;

import org.springframework.stereotype.Component;

/**
 * @author amit
 * This bean implements TransferService whose transfer method will be advised by more than one aspect.
 */

@Component
public class TransferServiceImpl implements TransferService {

	@Override
	public Boolean transfer() {
		System.out.println("Transfering money ...");
		return false;
	}

}
