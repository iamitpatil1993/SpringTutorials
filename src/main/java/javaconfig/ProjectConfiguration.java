package javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import autocomponentscanning.usingbasepackageclasses.AutoScanningComponentResolver;
import soundsystem.CDPlayerConfiguration;

/**
 * 
 * @author amit
 * This is top level config class and we will include other low level config classes in here.
 */

@Configuration
@ComponentScan(basePackageClasses = {AutoScanningComponentResolver.class}) // Note we are listing marker interface here
@Import(value = {CDPlayerConfiguration.class})
public class ProjectConfiguration {
	
	

}
