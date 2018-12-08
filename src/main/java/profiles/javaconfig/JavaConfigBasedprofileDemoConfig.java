package profiles.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import profiles.MyDataSource;

/**
 * 
 * @author amit
 * java config class to demonstrate profiles in spring using java config way 
 */

@Configuration
public class JavaConfigBasedprofileDemoConfig {

	@Bean
	@Profile("dev")
	public MyDataSource inMemoryDataSource() {
		return new InMemoryDataSource();
	}

	@Bean
	@Profile(value = {"prod", "qa"})
	public MyDataSource realDataSource() {
		return new RealDataSource();
	}
}
