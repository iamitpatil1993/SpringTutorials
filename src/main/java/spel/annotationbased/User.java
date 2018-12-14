package spel.annotationbased;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class User {

	/*
	 * In oredr to use this property via SpEL in other bean's @Value annotation, we
	 * need either need to make this property public or need to java proper javaBean
	 * // stype gette and setters. Otherwise, spring will give error name property
	 * not found or accessible on bean user. 
	 * In short, SpEL do not get bean
	 * properties via reflection, it access it via standard ways.
	 */
	private String name = "Amit Patil";
	
	private String nickName;
	
	private String email = "iamitpatil1993@gmail.com";
	
	private List<Address> placesLivedIn = new ArrayList<>();
	
	private List<String> hobbies = new ArrayList<>(); 
	
	public User() {
		placesLivedIn.add(new Address("Pune", "Nigdi"));
		placesLivedIn.add(new Address("Pune", "Shivaji Nagar"));
		placesLivedIn.add(new Address("Sangli", "sangli"));
		
		hobbies.add("reading");
		hobbies.add("gaming");
		hobbies.add("coding");
		hobbies.add("wathcing movies");
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public static String staticProperty = "static value";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Address> getPlacesLivedIn() {
		return placesLivedIn;
	}

	public void setPlacesLivedIn(List<Address> placesLivedIn) {
		this.placesLivedIn = placesLivedIn;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

}
