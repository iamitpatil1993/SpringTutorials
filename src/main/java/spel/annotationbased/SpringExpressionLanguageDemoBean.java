/**
 * 
 */
package spel.annotationbased;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author amit 
 * This class/bean demonstrate use of SpEL for auto-wiring in auto
 *         discovered components in spring.
 *
 */

@Component
public class SpringExpressionLanguageDemoBean {

	@Value("#{20}")
	private Integer staticNumericValue;

	@Value("#{'amipatil'}")
	private String staticStringValue;

	@Value("#{T(System).currentTimeMillis()}") // in case of classes from java.lang, we do not need to specify fully qualified class names
	private Long staticFunctionCallValue;

	@Value("#{user.name}")
	private String otherBeanPropertyValue;

	@Value("#{systemProperties['foo']}") // 'systemProperties' is spring implicit object to access jvm properties via
											// SpEL
	private String systemPropertyValue;

	@Value("#{systemEnvironment['username']}") // 'systemEnvironment' is spring implicit object to access environment
												// properties via SpEL
	private String environmentPropertyValue;

	@Value("#{user}") // Watch, we can inject beans as well usng @value annotation and SpEL as
						// alternative to @Autowired. Drawback of this is, we need to use bean id for
						// this, which adds tight coupling between beans and using interface becomes
						// pointless
	private User user;
	
	@Value("#{T(spel.annotationbased.User).staticProperty}") // all classes other than java.lang needs to be specific fully-qualified.
	private String staticPropertyClass;
	
	@Value("#{user.getName()}")
	private String instanceFunctionCallValue;
	
	@Value("#{user.getName().toUpperCase()}")
	private String nestedInstanceFunctionCallValue;
	
	@Value("#{user.getNickName()?.toUpperCase()}") // ?. check if left side is null or not, if it is not null only then it calls right hand side otherwise returns null.
	private String nullCheckBeforeNestedValueAccess;
	
	@Value("#{2 * T(Math).PI * 3}") // This expression evaluates circumference of circle with radious 3. 2PIr
	private Double arithmaticoperationValue;
	
	@Value("#{T(Math).PI * 3 ^ 2}") // This expression evaluates area of circle with radious 3. PIR^2
	private Double arithmaticoperationValue2;
	
	@Value("#{'Mr ' + user.name}") // when + operator used on string, it concatenates them
	private String stringConcatenation;
	
	@Value("#{'Amit Patil' eq user.name}") // comparison operatos always results into boolean result, so target type must be of type boolean
	private boolean comparisonResultValue;
	
	@Value("#{user.nickName eq null ? 'amty' : user.nickName}") // syntax of ternary operator is exactly similar to java syntax
	private String ternaryOperatorResultValue;
	
	@Value("#{user.nickName ?: 'amty'}") // elvis operator is short cut for ternary operator where we primary use for null check and default value assign if null.
	private String elvisOperatorResultValue;
	
	@Value("#{user.email matches '[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.com'}")
	private String regExMacherResultValue;
	
	@Value("#{user.placesLivedIn[1]}")
	private Address collectionElementValue;
	
	@Value("#{user.placesLivedIn[1].city}")
	private String collectionElementPropertyValue;
	
	@Value("#{user.placesLivedIn[1].city.toUpperCase()}")
	private String collectionElementPropertyFunctionValue;
	
	@Value("#{user.placesLivedIn.?[city eq 'Pune']}")
	private List<Address> filteredCollectionValue;
	
	@Value("#{user.placesLivedIn.?[city eq 'Pune'].![area]}") // This is projection, i.e fetching property from object of collection
	private List<String> filteredCollectionFunctionCallValue;
	
	@Value("#{user.placesLivedIn.^[city eq 'Pune']}") // this filters the collection and finds first element in collection which matches expression
	private Address firstMatchingElementInCollectionValue;
	
	@Value("#{user.placesLivedIn.$[city eq 'Pune']}") // this filters the collection and finds last element in collection which matches expression
	private Address lastMatchingElementInCollectionValue;

	@Override
	public String toString() {
		return "SpringExpressionLanguageDemoBean [staticNumericValue=" + staticNumericValue + ", staticStringValue="
				+ staticStringValue + ", staticFunctionCallValue=" + staticFunctionCallValue
				+ ", otherBeanPropertyValue=" + otherBeanPropertyValue + ", systemPropertyValue=" + systemPropertyValue
				+ ", environmentPropertyValue=" + environmentPropertyValue + ", user=" + user + ", staticPropertyClass="
				+ staticPropertyClass + ", instanceFunctionCallValue=" + instanceFunctionCallValue
				+ ", nestedInstanceFunctionCallValue=" + nestedInstanceFunctionCallValue
				+ ", nullCheckBeforeNestedValueAccess=" + nullCheckBeforeNestedValueAccess
				+ ", arithmaticoperationValue=" + arithmaticoperationValue + ", arithmaticoperationValue2="
				+ arithmaticoperationValue2 + ", stringConcatenation=" + stringConcatenation
				+ ", comparisonResultValue=" + comparisonResultValue + ", ternaryOperatorResultValue="
				+ ternaryOperatorResultValue + ", elvisOperatorResultValue=" + elvisOperatorResultValue
				+ ", regExMacherResultValue=" + regExMacherResultValue + ", collectionElementValue="
				+ collectionElementValue + ", collectionElementPropertyValue=" + collectionElementPropertyValue
				+ ", collectionElementPropertyFunctionValue=" + collectionElementPropertyFunctionValue
				+ ", filteredCollectionValue=" + filteredCollectionValue + ", filteredCollectionFunctionCallValue="
				+ filteredCollectionFunctionCallValue + ", firstMatchingElementInCollectionValue="
				+ firstMatchingElementInCollectionValue + ", lastMatchingElementInCollectionValue="
				+ lastMatchingElementInCollectionValue + "]";
	}
	
	
	
	
	
	

}
