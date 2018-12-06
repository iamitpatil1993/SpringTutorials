package beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 
 * @author amit 
 * This bean is to demonstrate bean init and destroy callbacks using Java EE @PostConstruct and @PreDestroy annotations
 *         
 */
public class BeanLifeCycleMyService {

	@PostConstruct
	public void init() {
		System.out.println("Inside beanLifeCycleMyService.init() callback");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Inside beanLifeCycleMyService.destroy() callback");

	}
}
