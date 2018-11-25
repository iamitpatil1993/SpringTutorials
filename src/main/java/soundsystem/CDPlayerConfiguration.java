package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author amit
 * Enables component scaning for Component declared for CD player application.
 */

@Configuration
@ComponentScan // We need to manually enable componentScan, it is disabled by default
public class CDPlayerConfiguration {

}
