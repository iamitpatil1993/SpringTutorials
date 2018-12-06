package beanlifecycle;

/**
 * 
 * @author amit 
 * This bea is to demonstrate bean init and destroy callbacks using
 *         custom init and destroy methods, and not having dependency op spring
 *         APIs
 */
public class BeanLifeCycleMyEmployeeService {

	public void init() {
		System.out.println("Inside BeanLifeCycleMyEmployeeService.init() callback");
	}

	public void destroy() {
		System.out.println("Inside BeanLifeCycleMyEmployeeService.destroy() callback");

	}
}
