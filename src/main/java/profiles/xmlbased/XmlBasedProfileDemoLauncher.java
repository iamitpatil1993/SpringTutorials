package profiles.xmlbased;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import profiles.MyDataSource;

public class XmlBasedProfileDemoLauncher {

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:profiles/profileDemoXmlConfig.xml", "classpath:profiles/profileDemoXmlConfig2.xml");

		MyDataSource dataSource = applicationContext.getBean(MyDataSource.class);
		dataSource.getConnection();

		// if prod/qa profile will active, this will log false, because bean is not
		// initialized by container and completely ignored due to scope mismatch
		System.out.println("applicationContext.containsBean(\"inMemoryDataSource\") :: "
				+ applicationContext.containsBean("inMemoryDataSource"));
		applicationContext.close();

	}

}
