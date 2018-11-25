package soundsystem;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @author amit
 * Demo using xml config to tell spring to enable component scan, we are still using component autoscan, but using xml instead of
 * 	javaConfig to enable component scan which is disabled by default. Using <context:component-scan> element
 */
public class CDPlayerMainUsingXMlConfig {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("soundsystem/cdPlayerConfiguration.xml");
		CompactDisk compactDisk = applicationContext.getBean(CompactDisk.class);
		compactDisk.play();
		applicationContext.close();
	}
}
