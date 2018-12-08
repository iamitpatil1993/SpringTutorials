package profiles.annotationbased;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import profiles.AnnotationBasedProfileJavaConfig;
import profiles.MyDataSource;

/**
 * 
 * @author amit main/launcher class to test profiles using annotation based bean
 *         declaration. We will use foud different ways to enable profiles in
 *         here (Java SE spring) 
 *         1. setting system property programmatically
 *         		before creating container 
 *         2. setting environment property using
 *         		spring Environment class (which manages properties and environments
 *         		in spring) 
 *         3. Setting JVM system property usiing STS/eclipse jvm
 *         		argument i.e external to program code (Run Configuration -> Arguments
 *         		-> Second box) 
 *         4. Setting environment property usiing STS/eclipse jvm
 *         		argument i.e external to program code (Run Configuration ->
 *         		Environment -> Second box),
 */
public class AnnotationBasedProfileDemLauncher {

	public static void main(String[] args) {

		// Sol-1.
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AnnotationBasedProfileJavaConfig.class);
		MyDataSource dataSource = applicationContext.getBean(MyDataSource.class); // this should inject
		// InmemoryDataSource
		dataSource.getConnection();
		applicationContext.close();

		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "qa");
		applicationContext = new AnnotationConfigApplicationContext(AnnotationBasedProfileJavaConfig.class);
		dataSource = applicationContext.getBean(MyDataSource.class); // this should inject ReadDataSource
		dataSource.getConnection();
		applicationContext.close();

		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
		applicationContext = new AnnotationConfigApplicationContext(AnnotationBasedProfileJavaConfig.class);
		dataSource = applicationContext.getBean(MyDataSource.class); // this should inject ReadDataSource
		dataSource.getConnection();
		applicationContext.close();

		/*
		 * since both InMemory and Read are now in container implementing same interface
		 * so, it will create ambiguity here.
		 */
		try {
			System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod, dev");
			applicationContext = new AnnotationConfigApplicationContext(AnnotationBasedProfileJavaConfig.class);
			dataSource = applicationContext.getBean(MyDataSource.class);// this should two NoUnique bean exception,
			dataSource.getConnection();
		} catch (NoUniqueBeanDefinitionException e) {
			e.printStackTrace();
		} finally {
			if (applicationContext != null) {
				applicationContext.close();
			}
		}

		// Sol-2
		/**
		 * we can not do like this here, because we need to set profile before loading
		 * beans into container, so we need to first set active/default profile and then
		 * register javaConfig class and then we must call refresh()
		 */
		// applicationContext = new
		// AnnotationConfigApplicationContext(AnnotationBasedProfileJavaConfig.class);
		applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.getEnvironment().setActiveProfiles("dev");
		applicationContext.register(AnnotationBasedProfileJavaConfig.class);
		applicationContext.refresh(); // <- must required
		dataSource = applicationContext.getBean(MyDataSource.class); // this should inject InMemoryDataSource
		dataSource.getConnection();
		applicationContext.close();
	}

}
