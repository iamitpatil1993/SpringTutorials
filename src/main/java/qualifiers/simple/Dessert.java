/**
 * 
 */
package qualifiers.simple;

/**
 * @author amit
 * This interface is a contract which multiple beans will implement. And while injecting bean this will create
 * an ambiguity, so we will use Qualifiers to narrow down the ambiguity.
 */

public interface Dessert {
	// Consider it as a marker interface
}
