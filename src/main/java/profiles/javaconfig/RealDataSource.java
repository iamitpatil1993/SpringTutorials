package profiles.javaconfig;

import java.sql.Connection;

import profiles.MyDataSource;


/**
 * @author amit 
 * Spring profile demo using javaConfig
 */

public class RealDataSource implements MyDataSource {

	@Override
	public Connection getConnection() {
		System.out.println("Getting connection using profiles.javaconfig.RealDataSource");
		return null;
	}
}
