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
	// Bean Id : method name is a default bean Id for SimpleJavaConfigDemoBean bean.
	@Bean()
	public SimpleJavaConfigDemoBean simpleJavaConfigDemoBean() {
		// Any logic to instantiate, configure and return bean goes here.
		// We can do anything to  instantiate, configure, in any way as possiblei in java.
		return new SimpleJavaConfigDemoBean();
	}
}
