/**
 * 
 */
package aop.xmlbased;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

import aop.annotatiobased.Performance;

/**
 * @author amit
 *
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:aop/xmlbased/XmlBasedAopConfig.xml"}, loader = GenericXmlContextLoader.class)
public class XmlBasedAudianceTest {

	@Autowired
	@Qualifier(value = "xmlBasedRockBand") // Using default qualifier (bean id) of bean to resolve ambiguity
	private Performance rockBandPerformance;
	
	@Autowired
	@Qualifier(value = "xmlBasedElectronicDigitalMusicPerformance") // Using default qualifier (bean id) of bean to resolve ambiguity
	private Performance edmPerformance;
	
	@Test
	public void rockBandTest() {
		assertNotNull(rockBandPerformance);
		rockBandPerformance.perform();
	}
	
	@Test
	public void edmTest() {
		assertNotNull(edmPerformance);
		edmPerformance.perform();
	}
}
