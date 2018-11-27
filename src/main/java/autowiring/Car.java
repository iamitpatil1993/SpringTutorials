package autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author amit
 * This bean is created to demonstrate bean auto-wiring using setter based injection.
 */

@Component
public class Car implements Vehical {

	// Car has dependnecy on oil, driver and fuel to move or work
	private Driver driver;
	private Fuel fuel;
	private EngineOil engineOil;

	// Since car can work or used without music system, we will mark music system as a optional dependency.
	// How spring handle this is, it tries to auto-wire the dependency but if, it does not finds the dependency
	// it will throw exception, but if we declare dependency as optional dependency in that case it will not throw 
	// exception rather will inject with null value.
	// In this case MusicSystem is a interface, and there is no implementation for this interface, so container will
	// fail to resolve this dependency, but it will not throw exception rather it will inject null value.
	@Autowired(required = false)
	private MusicSystem musicSystem;

	// We can use @Autowired annotation at field level also to inject dependency.
	@Autowired
	private Battery battery;
	
	// Constructor based injection
	@Autowired
	public Car(Fuel fuel) {
		this.fuel = fuel;
	}
	
	// setter based injection
	@Autowired
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	// to use setter based innection, method does not need to be a java bean setter it can be any method.
	// spring will resolve it's parameter by auto-wiring
	@Autowired
	public void pourOil(EngineOil engineOil) {
		this.engineOil = engineOil;
	}

	@Override
	public void drive() {
		if (musicSystem == null) {
			System.out.println("Music player not available in case");
		} else {
			System.out.println("You can play music while driving.");
		}
		if (driver != null && fuel != null && engineOil != null && battery != null) {
			System.out.println("All needs satisfied, car is ready to move");
		} else {
			System.out.println("Somethig missing ...");
		}
	}
}
