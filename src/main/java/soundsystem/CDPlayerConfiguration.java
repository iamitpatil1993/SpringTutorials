package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author amit
 * Enables component scaning for Component declared for CD player application.
 */

@Configuration
@ComponentScan(basePackages = {"autocomponentscanning", "soundsystem"}) // We need to manually enable componentScan, it is disabled by default
// Note, we have added 'soundsystem' package as well. Because when we use basePackages it does not consider it's own package for 
// component scanning rather it use basePackages list and do not consider any default package.
public class CDPlayerConfiguration {

}
