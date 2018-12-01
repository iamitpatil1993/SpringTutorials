package mixconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagerConfig {

	@Bean
	public Manager manager(Designation designation) {
		return new Manager(designation);
	}
}
