package mixconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(value = { AddressConfig.class, EmployeeConfig.class, ManagerConfig.class })
@ImportResource(locations = { "classpath:mixconfig/qualificationConfig.xml" }) // importing xml config so that we
																					// can use this top level java
																					// config file with
																					// AnnotationConfigApplicationContext
																					// container
public class EmployeeManagmentConfig {

}
