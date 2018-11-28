package javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author amit
 * This is java config class, created to demonstrate bean declaretion, injection using explicit java config.
 */

@Configuration // Required annotation at class level.
public class JavaConfiguration {

	// @Bean enables discovery of this bean.
	// Bean type is always return type of method, so it can be interface as well.
	// Bean Id : method name is a default bean Id for SimpleJavaConfigDemoBean bean. We can override default name by providing name list/single name to @Bean annotation
	@Bean(value = {"javaConfigDemoBean", "javaConfigDemoBean2"}) // Note, I provided two names, so bean has one ID and one alias/name. But when I use BeanNameAware to get bean Id it gives me first string as a ID in list.
	public SimpleJavaConfigDemoBean simpleJavaConfigDemoBean() {
		// Any logic to instantiate, configure and return bean goes here.
		// We can do anything to  instantiate, configure, in any way as possiblei in java.
		return new SimpleJavaConfigDemoBean();
	}
	
	@Bean
	public InjectionJavaConfigDemoBean injectionJavaConfigDemoBean() {
		// This is not simple method call to simpleJavaConfigDemoBean(), spring intercept every method call to method 
		// annoted with @Bean. If bean is already created it returns existing bean from bean Factory (Since default scope is singleton) 
		return new InjectionJavaConfigDemoBean(simpleJavaConfigDemoBean());
	}
}
