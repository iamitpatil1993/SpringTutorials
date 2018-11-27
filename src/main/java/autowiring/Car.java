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
		if (driver != null && fuel != null && engineOil != null) {
			System.out.println("All needs satisfied, car is ready to move");
		} else {
			System.out.println("Somethig missing ...");
		}
	}
}
