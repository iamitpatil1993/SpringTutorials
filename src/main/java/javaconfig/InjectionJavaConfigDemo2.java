package javaconfig;

import org.springframework.beans.factory.InitializingBean;

import autowiring.Car;

/**
 * 
 * @author amit This bean is to demonstrate the DI in javaConfig (Different ways
 *         than manually calling method annoted with @Bean)
 */

public class InjectionJavaConfigDemo2 implements InitializingBean {

	private SimpleJavaConfigDemoBean simpleJavaConfigDemoBean;
	private Car car;

	public InjectionJavaConfigDemo2(SimpleJavaConfigDemoBean simpleJavaConfigDemoBean) {
		this.simpleJavaConfigDemoBean = simpleJavaConfigDemoBean;
	}

	// this will be used for setter based injection in javaConfig
	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (car != null && simpleJavaConfigDemoBean != null) {
			System.out.println("Bean initialized completely");
		} else {
			System.out.println("Something missed while bean initialization");
		}
	}
}
