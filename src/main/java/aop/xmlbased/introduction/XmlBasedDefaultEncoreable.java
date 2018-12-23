/**
 * 
 */
package aop.xmlbased.introduction;

import aop.annotatiobased.introduction.Encoreable;

/**
 * @author amit
 * This class provides implementation of Encoreable interface. We will use this class to declare parents.
 * When method from Encoreable interface will ger called on target proxy (of bean), spring will delegate that
 * call to this class.
 */

/*
 * Using XML we cal use this class in parent declaration in two ways
 * 1. Specify this class as a full-qualified class in default-impl attribute. OR
 * 2. Delcare this class as a Spring bean, and specify this class as a bean reference in declare parent definition using
 * deletate-ref attribute.
 */
public class XmlBasedDefaultEncoreable implements Encoreable {

	@Override
	public void performEncore() {
		System.out.println("Encorearing from XmlBasedDefaultEncoreable ...Call delegated to XmlBasedDefaultEncoreable");
	}
 }
