/**
 * 
 */
package primarybean;

/**
 * @author amit
 * This interface will be used at injection point to declare the dependency. There will be multiple impplementations 
 * of this interface, which will cause ambiguity at injection point while resolving bean dependency, and we will use 
 * @primary annotation to declare on of the implementation as a primary choice, which will resolve ambiguity.
 */
public interface CacheManager {

}
