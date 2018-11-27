package autocomponentscanning.usingbasepackageclasses;

/**
 * 
 * @author amit
 * This is a marker interface. This marker interface created to enable component scanning for this package (autocomponentscanning).
 * Instead of listing actual business beans in bacsePackaeClasses attribute, We should create marker interfaces in packages, 
 * which we want to consider for component scanning. This is because, we may change package of business bean listed their and hence
 * this package will not be considered for component scanning.
 * So, creating markter interface solves this, anything changes in package but marker interface will remain here and hence can
 * be used without worry in @ComponentScan annotation attribute.
 */
public interface AutoScanningComponentResolver {
	// Nothing to do here
}
