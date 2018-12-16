/**
 * 
 */
package externalizevalues.profilespecificproperties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author amit
 * This class demonstrates, how to inject profile specific properties into application.
 * This is a normal bean which needs few property values to be injected in, but it does not care about,
 * which profile is active and which property file needs to be used to read property. 
 * It works completely environment agnostic.
 *
 */

@Component
public class ProfileSpecificPropertiesDemoBean implements InitializingBean {

	@Value("${db.username}")
	private String dbUserName;
	
	@Value("${db.password}")
	private String dbPassword;
	
	@Value("${db.host}")
	private String dbHost;
	
	@Value("${db.port:5432}") // this is how we can give default value as well of value is not available.
	private int port;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "ProfileSpecificPropertiesDemoBean [dbUserName=" + dbUserName + ", dbPassword=" + dbPassword
				+ ", dbHost=" + dbHost + ", port=" + port + "]";
	}
}
