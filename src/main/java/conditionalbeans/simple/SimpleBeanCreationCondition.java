/**
 * 
 */
package conditionalbeans.simple;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author amit
 * This class represents simple condition which we will pass to @Condtional annotation in bean declaration
 */

// We need to implement Condition interface from spring
public class SimpleBeanCreationCondition implements Condition {

	/**
	 * It's very simple, return value of this method determines whether or not to create a bean by container
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// this is hard coded false condition, this is why it i called Simple.
		// we can build advance condtions using two ConditionContext and
		// AnnotationTypeMetada interfaces objets sent as a argumends
		return false;
	}

}
