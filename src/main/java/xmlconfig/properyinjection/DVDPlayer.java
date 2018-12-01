/**
 * 
 */
package xmlconfig.properyinjection;

import org.springframework.beans.factory.InitializingBean;

import soundsystem.CDPlayer;
import soundsystem.CompactDisk;
import xmlconfig.collectioninjection.BlankDisk;

/**
 * @author amit
 * This bean is to demonstrate, Property based DI using XML config
 */
public class DVDPlayer implements CDPlayer, InitializingBean {

	private CompactDisk compactDisc;
	
	@Override
	public void play() {
		// TODO Auto-generated method stub

	}

	// NOTE: For property injection we need proper java bean style getter-setters for bean property
	public CompactDisk getCompactDisc() {
		return compactDisc;
	}

	public void setCompactDisc(CompactDisk compactDisc) {
		this.compactDisc = compactDisc;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (compactDisc != null) {
			System.out.println("DVDPlayer is ready to play, compactDisc instanceOf BalankDis? " + (compactDisc instanceof BlankDisk));
		} else {
			System.out.println("Please insert CD to plat DVDPlayer");
		}
	}
}
