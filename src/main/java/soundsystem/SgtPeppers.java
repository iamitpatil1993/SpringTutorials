package soundsystem;

import org.springframework.stereotype.Component;
/**
 * @author amit
 * Declares first spring bean using Annotation configuration. 
 */

@Component // Used so that spring discovers this class as spring bean/component.
public class SgtPeppers implements CompactDisk {

	@Override
	public void play() {
		System.out.println("Playing music from compact disc");
	}
}
