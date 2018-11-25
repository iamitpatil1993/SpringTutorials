package soundsystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CDPlayerMain {

	public static void main(String[] args) {
		// Using annotation config application context, because we have used javaConfig to enable componentScaning
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
				CDPlayerConfiguration.class);
		
		CompactDisk compactDisk = annotationConfigApplicationContext.getBean(CompactDisk.class);
		compactDisk.play();
		annotationConfigApplicationContext.close();
	}
}
