/**
 * 
 */
package aop.annotatiobased.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author amit
 * This is an aspect, which will introduce Encoreable interface implementation to joinpoints matched by pointcut expression.
 * This aspect, will add Encoreable interface implementation to all Performance interface implementing beans.
 *
 */

@Aspect
@Component // Aspect needs to be delcared as a normal bean
public class AnnotationBasedEncoreableIntroducer {

	// this annotation declares pointcut and implementation class of interface to which request will be delegated.
	@DeclareParents(value = "aop.annotatiobased.Performance+", defaultImpl = AnnotationBasedDefaultEncoreable.class)
	public static Encoreable encoreable; // This is interface we want to introduce, this attribute need not to be static

}
