package xmlconfig.collectioninjection;

import java.util.Set;

import soundsystem.CompactDisk;

/**
 * 
 * @author amit This bean is to demonstrate, DI of collection of reference (not
 *         a value)
 */

public class Discography {

	private String artist;
	private Set<CompactDisk> albums;

	// Will inject set using XML config
	public Discography(String artist, Set<CompactDisk> albums) {
		super();
		this.artist = artist;
		this.albums = albums;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Set<CompactDisk> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<CompactDisk> albums) {
		this.albums = albums;
	}

}