package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import autocomponentscanning.usingbasepackageclasses.AutoScanningComponentResolver;
import autowiring.AutoWiringComponentResolver;
import autowiring.ComponentScanFilterDemoBean;
import soundsystem.CDPlayerConfiguration;

/**
 * 
 * @author amit This is top level config class and we will include other low
 *         level config classes in here.
 */

//NOTE: we are required to specify type (FilterType)here, otherwise container will throw exception, so type is not optional it is required. 
@Configuration
@ComponentScan(basePackageClasses = { AutoScanningComponentResolver.class,
		AutoWiringComponentResolver.class }, excludeFilters = {
				@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
						ComponentScanFilterDemoBean.class }) }) // Note we are listing marker interface here
@Import(value = { CDPlayerConfiguration.class })
public class ProjectConfiguration {

}
