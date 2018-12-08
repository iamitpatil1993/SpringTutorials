package profiles;
/**
 * 
 * @author amit
 *This interface is to demostrate spring profiles. This interface will be implemented by multiple beans.
 * We will create two implementation classes one for dev environment and another for qa env.
 * we will not mark any of the implementation to be @Primary in order to resolve ambiguity generated due to 
 * multiple beans in container implenenting same this interface, rather there shouldn't be ambiguity at all if 
 * we are declaring bean to be part of particular profile and as long as there is only one profile (dev/qa) is 
 * active at any given time.
 */

import java.sql.Connection;

public interface MyDataSource {

	Connection getConnection();
}
