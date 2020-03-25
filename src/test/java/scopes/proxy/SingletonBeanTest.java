package scopes.proxy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PrototypeProxyDemoConfig.class})
public class SingletonBeanTest {

    @Autowired
    private SingletonBean singletonBean;

    @Test
    public void accessPrototype() {

        singletonBean.accessPrototype();
        singletonBean.accessPrototype();

        Assert.assertEquals(Integer.valueOf(2), ProxyPrototypeBean.getCount());
    }
}