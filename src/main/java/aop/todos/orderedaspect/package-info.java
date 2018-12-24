/**
 * @author amit
 * This package demonstrates, use of @Order and org.springframework.core.Ordered interface to define
 * order in which aspect should get invoked.
 * If advised method has two or more advised, then by default order in which two advises will get invoked is 
 * unknown, so we can explicitly specify order in which Aspect should be applied on target.
 * 
 * there are two ways to define order
 * 1. @Order annotation
 * 2. Ordered interface. (Aspect needs to implement this interface to define order)
 */

/**
 * Order of aspect invocation is 
 * 
 * Highest -> Lowest - before calling advised method
 * Lowest -> Highest - after calling advised method (after, afterReturning, afterThrowing advises of Aspect)
 * 
 * So, before calling method, aspects get called in order we specify and,
 * after calling method, aspects get called exactly reversed order (Irrespective of type of advise is after/afterReturning/afterThrowing).
 */
package aop.todos.orderedaspect;