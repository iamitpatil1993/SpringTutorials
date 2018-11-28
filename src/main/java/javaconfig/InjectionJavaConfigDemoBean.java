package javaconfig;

/**
 * 
 * @author amit This bean, is created to demonstrate dependency injection using
 *         explicit javaConfig.
 */

public class InjectionJavaConfigDemoBean {

	// Assume this has dependency on SimpleJavaConfigDemoBean;
	private SimpleJavaConfigDemoBean bean;

	// We are using constructor injection, but we can use setter injection as well,
	// since code in javaConfig can do
	// anything to inject dependency into bean. But we should always follow
	// conventions and should
	// inject dependencies via constructor or java bean setters and not via any
	// random method call.
	public InjectionJavaConfigDemoBean(SimpleJavaConfigDemoBean bean) {
		this.bean = bean;
	}

	public SimpleJavaConfigDemoBean getBean() {
		return bean;
	}
}
