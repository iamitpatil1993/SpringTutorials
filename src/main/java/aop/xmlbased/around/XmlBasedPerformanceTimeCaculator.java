/**
 * 
 */
package aop.xmlbased.around;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author amit
 * This class is an aspect, which advices Performance's perform().
 * This advice is defined using XML configuration.
 * This advice calculates actual time take by performance. 
 *
 */


public class XmlBasedPerformanceTimeCaculator {
	
	/**
	 * If we need to achieve this functionality using separate before and after advice, then this aspect class will become statefull, because, we will have to
	 *  maintain startTime in before advice as a state i.e instance variable, which will make this aspect NON thread-safe, and we will have to change thee
	 *  scope of this aspect from SINGTON -> PROTOTYPE. (Which will be costly, due to object creation on each invocation.)
	 * @param proceedingJoinPoint
	 */
	public void calculatePerformanceTime(ProceedingJoinPoint proceedingJoinPoint) {
		try {
			// before (part of advice)
			System.out.println("Started timer ...");
			Long startTimeStamp = System.currentTimeMillis();
			
			proceedingJoinPoint.proceed();
			
			// After-returning (part of advice)
			Long endTimeStamp = System.currentTimeMillis();
			System.out.println("Time taken by performance is :: " + (endTimeStamp - startTimeStamp) / 1000);
		} catch (Throwable e) {
			// after-throwiing (part of advice)
			System.out.println("Something went wrong while performances from XmlBasedPerformanceTimeCaculator... ");
		}
		// after (part of advice) goes below
	}

}
