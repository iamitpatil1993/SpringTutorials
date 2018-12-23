/**
 * 
 */
package aop.xmlbased.introduction;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

import aop.annotatiobased.Performance;
import aop.annotatiobased.introduction.Encoreable;

/**
 * @author amit
 *
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:aop/xmlbased/XmlBasedAopConfig.xml"}, loader = GenericXmlContextLoader.class)
public class XmlBasedDefaultEncoreableTest {

	@Autowired
	@Qualifier("xmlBasedRockBand")
	private Encoreable xmlBasedRockBandEncoreable;
	
	@Autowired
	@Qualifier("xmlBasedElectronicDigitalMusicPerformance")
	private Encoreable xmlBasedElectronicDigitalMusicPerformanceEncoreable;
	
	@Test
	public void test() {
		assertNotNull(xmlBasedRockBandEncoreable);
		assertTrue(xmlBasedRockBandEncoreable instanceof Performance);
		xmlBasedRockBandEncoreable.performEncore();
	}
	
	@Test
	public void test1() {
		assertNotNull(xmlBasedElectronicDigitalMusicPerformanceEncoreable);
		assertTrue(xmlBasedElectronicDigitalMusicPerformanceEncoreable instanceof Performance);
		xmlBasedElectronicDigitalMusicPerformanceEncoreable.performEncore();
	}
	
	@Test
	public void test3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aop/xmlbased/XmlBasedAopConfig.xml");
		Encoreable encoreable = (Encoreable) context.getBean("xmlBasedRockBand");
		encoreable.performEncore();
		
		Performance performance = (Performance) encoreable;
		performance.perform();
	}

}
