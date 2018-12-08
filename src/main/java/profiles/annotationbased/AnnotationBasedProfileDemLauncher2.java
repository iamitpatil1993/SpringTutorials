package profiles.annotationbased;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import profiles.AnnotationBasedProfileJavaConfig;
import profiles.MyDataSource;

/**
 * 
 * @author amit main/launcher class to test profiles using annotation based bean
 *         declaration. We will use foud different ways to enable profiles in
 *         here (Java SE spring) 
 *	      3. Setting JVM system property usiing STS/eclipse jvm
 *         		argument i.e external to program code (Run Configuration -> Arguments
 *         		-> Second box) 
 *        4. Setting environment property usiing STS/eclipse jvm
 *         		argument i.e external to program code (Run Configuration ->
 *         		Environment -> Second box),
 */
public class AnnotationBasedProfileDemLauncher2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationBasedProfileJavaConfig.class);
	
		MyDataSource dataSource = applicationContext.getBean(MyDataSource.class); 
		dataSource.getConnection();
		applicationContext.close();
	}
}
