package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author amit
 * Bean implements CD player interface.
 * This bean is used to demo constructor injection using @Autowired annotation (Using spring auto wiring)
 */

@Component
public class CDPlayerImpl implements CDPlayer {

	// This is interfacc, spring will find it's implementation and will inject.
	// If spring finds multiple implementations, then it will throw exception, in which we case we need to
	// narrow the bean scanning using concepts like primary bean and/or bean qualifier.
	private CompactDisk compactDisk;
	
	// Using @Autowired for constructor based injection and resolve CompactDisk dependency using spring auto wiring.
	@Autowired
	public CDPlayerImpl(CompactDisk compactDisk) {
		this.compactDisk = compactDisk;
	}
	
	@Override
	public void play() {
		compactDisk.play();
	}
}
