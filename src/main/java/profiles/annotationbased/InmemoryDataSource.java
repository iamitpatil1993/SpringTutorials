/**
 * 
 */
package profiles.annotationbased;

import java.sql.Connection;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import profiles.MyDataSource;

/**
 * @author amit This is a data source implementation representing in-memory
 *         database. So, we will use this implementation/bean for 'dev' profile.
 */

@Component
@Profile("dev") 
//@Profile(value = {"!qa", "!prod"}) this will discover this bean for any profile other than qa/prod
public class InmemoryDataSource implements MyDataSource {

	@Override
	public Connection getConnection() {
		System.out.println("Getting connection from InmemoryDataSource");
		return null;
	}
}
