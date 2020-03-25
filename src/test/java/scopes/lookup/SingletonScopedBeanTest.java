package scopes.lookup;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ScopeConfig.class}, loader = AnnotationConfigContextLoader.class)
public class SingletonScopedBeanTest {

    @Autowired
    private SingletonScopedBean singletonScopedBean;

    /**
     * Since {@link org.springframework.beans.factory.annotation.Lookup} method uses ApplicationContext/BeanFactory
     * to lookup bean, it will return new {@link PrototypeScopedBean} every time asked/called.
     */
    @Test
    public void testGetPrototypeScopedBean() {
        UUID uuid1 = UUID.randomUUID();
        final PrototypeScopedBean prototypeBean1 = singletonScopedBean.getPrototypeScopedBean(uuid1);

        UUID uuid2 = UUID.randomUUID();
        final PrototypeScopedBean prototypeBean2 = singletonScopedBean.getPrototypeScopedBean(uuid2);
        // BOTH will be different object as scope in prototype
        Assert.assertFalse(prototypeBean2.equals(prototypeBean1));

        Assert.assertFalse(prototypeBean1.getId().equals(prototypeBean2.getId()));

    }
}