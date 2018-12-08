/**
 * 
 */
package profiles.annotationbased;

import java.sql.Connection;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import profiles.MyDataSource;

/**
 * @author amit This is a data source implementation representing real on disc
 *         database. So, we will use this implementation/bean for 'qa' and
 *         'prod' profiles.
 */

@Component
@Profile(value = { "qa", "prod" }) // This component belongs to two profiles prod and qa
public class RealDataSource implements MyDataSource {

	@Override
	public Connection getConnection() {
		System.out.println("Getting connection from RealDataSource");
		return null;
	}

}
