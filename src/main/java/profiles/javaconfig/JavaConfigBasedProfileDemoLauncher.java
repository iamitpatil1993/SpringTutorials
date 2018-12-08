package profiles.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import profiles.MyDataSource;

/**
 * 
 * @author amit 
 * java config class to demonstrate profiles in spring using java config way
 * 
 */

public class JavaConfigBasedProfileDemoLauncher {

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "qa");
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				JavaConfigBasedprofileDemoConfig.class);
		
		MyDataSource myDataSource = applicationContext.getBean(MyDataSource.class);
		myDataSource.getConnection();
		
		applicationContext.close();

	}

}
