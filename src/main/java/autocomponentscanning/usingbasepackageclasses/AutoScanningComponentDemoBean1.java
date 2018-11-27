package autocomponentscanning.usingbasepackageclasses;

import org.springframework.stereotype.Component;

/**
 * 
 * @author amit
 * This bean is to demonstrate use of basePackageClasses attribute of @ComponentScan annotation.
 * We will create marker interface in this package and will use that marker interface to enable 
 * component scanning for this package.
 */

@Component
public class AutoScanningComponentDemoBean1 {

	public void greet() {
		System.out.println("This bean is discovered using  basePackageClasses attribute of @ComponentScan annotation and marker interface");
	}
}
