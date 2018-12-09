package conditionalbeans.simple;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * 
 * @author amit
 * Bean to demostrate conditional bean creation in spring, with simple hard coded condition.
 */

@Component
@Conditional(SimpleBeanCreationCondition.class)
public class SimpleConditionalBenaDemoBean {

	// Nothing to do here
}
