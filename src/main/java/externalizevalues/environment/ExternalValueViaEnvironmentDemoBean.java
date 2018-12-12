package externalizevalues.environment;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 
 * @author amit 
 * This class is used to demonstrate use external values via
 *         Environment object into auto-scanned spring components.
 */


// Another way to get Environment is, simple inject it using @Inject or @Autowired, I used EnvironmentAware to just try new way of getting it.
@Component
public class ExternalValueViaEnvironmentDemoBean implements EnvironmentAware {

	private String propertyFromPropertyFile;
	private Integer numericPropertyFromPropertyFile;
	private String propertyFromSystemEnvironmentVariable; // Will be from env variables
	private String propertyFromSystemJvmVariable; // Will be from JVM properties

	/**
	 * This will get called with Spring env object in which application running
	 * All properties in property files, jvm, environment are get combined to flat structure and can be access using env.getProperty(). Spring creates flat map of 
	 * all these properties (From different property sources)
	 * NOTE: So, if two property sources has one or more properties with same name, then the source which get loaded last will override similar name property from source
	 * loaded before it. So, we need to make sure, we decide correct property naming convention, which will contain source details as well in order to avoid conflicts.
	 * For example, properties in env should prefix with  env.*
	 * properties from app.properties should prefix with app.*
	 * etc.
	 */
	@Override
	public void setEnvironment(Environment environment) {
		propertyFromPropertyFile = environment.getProperty("app.name");
		numericPropertyFromPropertyFile = environment.getProperty("datasource.poolSize", Integer.class);
		propertyFromSystemEnvironmentVariable = environment.getProperty("username");
		propertyFromSystemJvmVariable = environment.getProperty("sysProperty");
	}

	public String getPropertyFromPropertyFile() {
		return propertyFromPropertyFile;
	}

	public void setPropertyFromPropertyFile(String propertyFromPropertyFile) {
		this.propertyFromPropertyFile = propertyFromPropertyFile;
	}

	public Integer getNumericPropertyFromPropertyFile() {
		return numericPropertyFromPropertyFile;
	}

	public void setNumericPropertyFromPropertyFile(Integer numericPropertyFromPropertyFile) {
		this.numericPropertyFromPropertyFile = numericPropertyFromPropertyFile;
	}

	public String getPropertyFromSystemEnvironmentVariable() {
		return propertyFromSystemEnvironmentVariable;
	}

	public void setPropertyFromSystemEnvironmentVariable(String propertyFromSystemEnvironmentVariable) {
		this.propertyFromSystemEnvironmentVariable = propertyFromSystemEnvironmentVariable;
	}

	public String getPropertyFromSystemJvmVariable() {
		return propertyFromSystemJvmVariable;
	}

	public void setPropertyFromSystemJvmVariable(String propertyFromSystemJvmVariable) {
		this.propertyFromSystemJvmVariable = propertyFromSystemJvmVariable;
	}

}
