/**
 * 
 */
package aop.todos.librarytargetobject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author amit 
 * This java config aims to delcare library class as a Spring bean,
 *         so that it can be advised. Remeber that, only spring beans can be
 *         advised using spring AOP aspects.
 *
 */

@Configuration
@ComponentScan // To scan Aspect.
@EnableAspectJAutoProxy // to enable processing of AspectJ annotations and weaving of advise into target
						// bean class and create it's runtime proxy using 1. Dynamic JDK proxy or 2.
						// CGLib
public class LibraryTargetAopDemoJavaConfig {

	/**
	 * This will declare Throwable as a Sping bean class, so that it can be advised by aspect
	 * We Chose to use Throwable class as our target object because
	 * 1. It is not a final class (Remember spring can not create proxy of Final classes)
	 * 2. We will advise it's getMessage() method because, it is non-final, non-static, public method. (Remember, spring AOP can advise only instance, non-final, public methods from non-final class.)
	 * @return 
	 */
	@Bean
	public Throwable throwable() {
		return new Throwable();
	}
}
