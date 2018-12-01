package mixconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DesignationConfig {

	@Bean
	public Designation designation() {
		return new Designation();
	}
}
