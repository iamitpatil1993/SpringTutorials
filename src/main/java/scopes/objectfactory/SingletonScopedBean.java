package scopes.objectfactory;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingletonScopedBean {

    /**
     * {@link ObjectFactory} does all all heavy lifting of creating instance of type we specified. We just need to call
     * {@link ObjectFactory#getObject()} whenever we need instance of provided bean type. Everything else is managed by
     * {@link ObjectFactory}. Spring provided implementation of this interface at runtime.
     * <p>
     * This is another solution to inject Prototype beans into singleton beans. And saves us from creating Lookup method.
     * <p>
     * BUT NOTE: We can not pass any argument for object creation as we could do in case of lookup method. We do not have
     * control of constructor argument here.
     */
    @Autowired
    private ObjectFactory<PrototypeScopedBean> prototypeScopedBeanObjectFactory;

    public void doSomething() {
        System.out.println("getPrototypeScopedBean().hashCode() = " + prototypeScopedBeanObjectFactory.getObject().hashCode());
    }

}
