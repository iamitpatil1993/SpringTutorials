package scopes.objectfactory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ScopeConfig.class})
public class SingletonScopedBeanTest {

    @Autowired
    private SingletonScopedBean singletonScopedBean;


    @Test
    public void doSomething() {
        singletonScopedBean.doSomething();
        singletonScopedBean.doSomething();

        Assert.assertEquals(Integer.valueOf(2), PrototypeScopedBean.getCount());
    }
}