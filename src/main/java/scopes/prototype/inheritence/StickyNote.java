/**
 * 
 */
package scopes.prototype.inheritence;

import org.springframework.stereotype.Component;

import scopes.prototype.NotePad;

/**
 * @author amit
 * this bean is to demonstrate, whether scope of parent bean get inherited to chile bean or not.
 * Here parent class is of Prototype scope.
 */

@Component
public class StickyNote extends NotePad {

}
