package scopes.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SingletonScopedBean {

    public void doSomething(UUID id) {
        System.out.println("getPrototypeScopedBean().hashCode() = " + getPrototypeScopedBean(id).hashCode());
    }

    /**
     * {@link Lookup} annotations, ask spring to create proxy of this bean, spring create subclass of this bean and
     * create proxy using CGLIB. Spring overrides this method and adds implementation, to get bean from application context.
     * BeanFactory will return new bean of {@link PrototypeScopedBean} every time asked as it is prototype scoped bean.
     * Spring uses return type of this stub to determine type of bean to look into beanFactory.
     * So, it saves us from, implementing {@link org.springframework.context.ApplicationContextAware}
     * interface, getting application context and getting bean from application context everytime needed in this bean.
     * <p>
     * NOTE: We can pass arguments to method, which spring will pass to constructor of underlying bean.
     *
     * Read : https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Lookup.html
     *
     * @return scopes.lookup.PrototypeScopedBean
     */
    @Lookup
    //@Lookup(value = "beanId") // we can ask for bean using bean Id by passing bean id as a attribute to lookup annotation.
    public PrototypeScopedBean getPrototypeScopedBean(UUID id) {
        // Nothing to do here (stub implementation)
        // Spring overrides this
        return null;
    }
}
