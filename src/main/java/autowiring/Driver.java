package autowiring;

import javax.inject.Inject;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

// Implementing InitializingBean interface to validate all beans injected correctly. Since this method get called
// after initialization.
@Component
public class Driver implements InitializingBean {
	
	// We can use @inject annotation from javax.inject in place of @Autowired to inject beans in a
	// same as we can use @Named in place of @Component
	@Inject
	private DrivingLicence drivingLicence;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Driving licence available ? -> " + drivingLicence != null);
	}
}
