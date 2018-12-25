/**
 * 
 */
package aop.todos.librarytargetobject.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import aop.annotatiobased.Performance;
import aop.xmlbased.XmlBasedRockBand;

/**
 * @author amit
 * This is an aspect, which tries to Introduce Performance interface into Throwable java library class.
 *
 */
@Aspect
@Component
public class ThrowableIntroductionAspect {

	@DeclareParents(value = "java.lang.Throwable", defaultImpl = XmlBasedRockBand.class)
	public Performance performance;
}
