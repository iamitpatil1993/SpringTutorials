/**
 * 
 */
package externalizevalues.propertyplaceholder.annotationbased;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author amit 
 * This bean is to demonstrate use of property place holders to
 *         read/inject value(not a object ref.) from external value sources This
 *         beans is targeting how to do it in auto-scanned component.
 */
/*
NOTE: I have added @Value or @Autowired annotations to demonstrate different places where we can use this annotation to
add property placeholder, but we should use it at field level to inject values as a better practice. No need at constructor or property method level.
Because, if we add another construtor as a default constructor, spring will start calling default constructor so, our another constructor annoted with @Value will not get called, so
those values will never get injected. So, better use injection annotations like @Inject, @Autowired and @Value at field level, because field level injection always works, no matter which
constructor get called.*/
@Component
public class ExternalValueViaProepertyPlaceholderDemoBean implements InitializingBean {

	@Value("${app.name}")
	private String valueFromPropertyFile;
	private Integer numericValueFromPropertyFile;

	private String valueFromSystemEnvironmentVariables;
	private String valueFromJvmSystemProperties;

	public ExternalValueViaProepertyPlaceholderDemoBean(@Value("${username}") String valueFromSystemEnvironmentVariables,
			@Value("${foo}") String valueFromJvmSystemProperties) {
		this.valueFromSystemEnvironmentVariables = valueFromSystemEnvironmentVariables;
		this.valueFromJvmSystemProperties = valueFromJvmSystemProperties;
	}

	public Integer getNumericValueFromPropertyFile() {
		return numericValueFromPropertyFile;
	}

	@Value("${datasource.poolSize}")
	// Below comment line will not work, in case of setters/methods we need to add @Value annotation at method level and not at argument level.
	// adding it at argument level, spring won't identify that it will have to call this method as well, so spring will only call constructors and methods/setters
	//public void setNumericValueFromPropertyFile(@Value("${datasource.poolSize}") Integer numericValueFromPropertyFile) { 
	public void setNumericValueFromPropertyFile(Integer numericValueFromPropertyFile) {
		this.numericValueFromPropertyFile = numericValueFromPropertyFile;
	}

	public String getValueFromPropertyFile() {
		return valueFromPropertyFile;
	}

	public void setValueFromPropertyFile(String valueFromPropertyFile) {
		this.valueFromPropertyFile = valueFromPropertyFile;
	}

	public String getValueFromSystemEnvironmentVariables() {
		return valueFromSystemEnvironmentVariables;
	}

	public void setValueFromSystemEnvironmentVariables(String valueFromSystemEnvironmentVariables) {
		this.valueFromSystemEnvironmentVariables = valueFromSystemEnvironmentVariables;
	}

	public String getValueFromJvmSystemProperties() {
		return valueFromJvmSystemProperties;
	}

	public void setValueFromJvmSystemProperties(String valueFromJvmSystemProperties) {
		this.valueFromJvmSystemProperties = valueFromJvmSystemProperties;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if ("Core technologies".equals(valueFromPropertyFile) && 20 == numericValueFromPropertyFile
				&& "amipatil".equals(valueFromSystemEnvironmentVariables)
				&& "foo".equals(valueFromJvmSystemProperties)) {
			System.out.println("Bean initilized successfully");
		} else {
			System.out.println("Bean initlization error, bean :: " + this);
			
		}
	}

	@Override
	public String toString() {
		return "ExternalValueViaProepertyPlaceholderDemoBean [valueFromPropertyFile=" + valueFromPropertyFile
				+ ", numericValueFromPropertyFile=" + numericValueFromPropertyFile
				+ ", valueFromSystemEnvironmentVariables=" + valueFromSystemEnvironmentVariables
				+ ", valueFromJvmSystemProperties=" + valueFromJvmSystemProperties + "]";
	}
	

}
