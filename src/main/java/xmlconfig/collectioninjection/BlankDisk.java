package xmlconfig.collectioninjection;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import soundsystem.CompactDisk;

/**
 * 
 * @author amit This class is to demonstrate NULL value injection using XML
 *         config and also list/set/array value injection using XML
 *         configuration
 */

public class BlankDisk implements CompactDisk, InitializingBean {

	private String diskName;
	private String musicCompanyName;
	private List<String> tracks;

	// Constructor injection using XML config with collection (List) as dependency to inject
	public BlankDisk(String diskName, String musicCompanyName, List<String> tracks) {
		this.diskName = diskName;
		this.musicCompanyName = musicCompanyName;
		this.tracks = tracks;
	}

	@Override
	public void play() {
		if (tracks != null && tracks.size() > 0) {
			System.out.println("Disk is filled with songs");
		} else {
			System.out.println("Disk is empty, Re-write the disk to add songs");
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (diskName != null && musicCompanyName != null && tracks != null && tracks.size() > 0) {
			System.out.println("Disk is filled with songs, with diskName :: " + diskName + " musicCompany :: " + musicCompanyName);
			System.out.println("Track List as below:");
			tracks.stream().forEach(System.out::println);
		} else {
			System.out.println("Disk is empty, Re-write the disk to add songs");
		}
	}
}
