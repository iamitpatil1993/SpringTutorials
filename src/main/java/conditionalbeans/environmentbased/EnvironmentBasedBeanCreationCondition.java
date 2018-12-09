package conditionalbeans.environmentbased;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 
 * @author amit
 * This is conditional bean creation demo, we will create condition using Environment object in spring.
 * We will check of 'condtional_bean_creation_flag' env variable is set, and if set we will all bean creation otherwise no
 */
public class EnvironmentBasedBeanCreationCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment springEnvironment = context.getEnvironment();
		return springEnvironment.containsProperty("condtional_bean_creation_flag");
	}

}
