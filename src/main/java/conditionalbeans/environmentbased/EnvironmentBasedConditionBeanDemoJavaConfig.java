package conditionalbeans.environmentbased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvironmentBasedConditionBeanDemoJavaConfig {

	@Bean
	@Conditional(EnvironmentBasedBeanCreationCondition.class)
	public EnviromentBasedConditionalBeanDemoBean enviromentBasedConditionalBeanDemoBean() {
		return new EnviromentBasedConditionalBeanDemoBean();
	}

}
