package beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 
 * @author amit Bean init and destroy life cycle callback using
 *         InitializingBean, DisposableBean interfaces
 */
// This approach to provide init and destroy handlers for bean is not recommended, because it adds tight coupling with spring
// apis. We should avoid this to keep our bean classes minimally invasive.
public class BeanLifeCycleEmployeeService implements InitializingBean, DisposableBean {

	private BeanLifeCycleEmployee employee;

	public BeanLifeCycleEmployeeService(BeanLifeCycleEmployee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Inisde BeanLifeCycleEmployeeService.afterPropertiesSet");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Inisde BeanLifeCycleEmployeeService.destroy");
	}

}
