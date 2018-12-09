package conditionalbeans.environmentbased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author amit
 * Condtional bean using environment based condtion
 */
@Configuration
public class EnvironmentBasedConditionBeanDemoJavaConfig2 {
	
	@Bean
	@Conditional(EnvironmentBasedBeanCreationCondition2.class)
	public EnviromentBasedConditionalBeanDemoBean enviromentBasedConditionalBeanDemoBean2() {
		return new EnviromentBasedConditionalBeanDemoBean();
	}

}
