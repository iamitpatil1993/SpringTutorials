package conditionalbeans.environmentbased;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EnvironmentBasedBeanCreationCondition2 implements Condition {

	/**
	 * This will allow creation of bean only if dev profile is active otherwise no.
	 * THis can be a manual way to create profile based beans
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment environment = context.getEnvironment();	
		return environment.acceptsProfiles("dev");
	}

}
