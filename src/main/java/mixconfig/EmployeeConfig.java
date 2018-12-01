package mixconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// Even though this import is added here and not in parent config class, it becomes avaialbe to all other beans as well
// for example, manager bean has dependnecy on Designation bean, and Designation bean is not delcared in managerConfig class 
// and also not in EmployeeManagerConfig class. Still Designation bean can be used in manager config class for DI
@Import(DesignationConfig.class) // We can import config class manually as well (in nodes at same level), but it
									// is not best way, we should declare DesignationConfig at top level config
									// class and it will become available to all config classes below it
									// automatically.
public class EmployeeConfig {

	@Bean
	public Employee employee(Qualification qualification, Manager manager, Address address, Designation designation) {
		return new Employee(qualification, address, manager, designation);
	}

}
