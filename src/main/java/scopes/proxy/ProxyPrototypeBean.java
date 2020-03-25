package scopes.proxy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
// Enabling proxy, will create NEW instance of this prototype bean every time method is called on proxy bean instance. (NOT STATIC METHOD)
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProxyPrototypeBean {

    public static final AtomicInteger INSTANCE_COUNTER = new AtomicInteger();

    public ProxyPrototypeBean() {
        INSTANCE_COUNTER.incrementAndGet();
    }

    public static Integer getCount() {
        return INSTANCE_COUNTER.get();
    }

    public void fooMethod() {
        System.out.println("ProxyPrototypeBean.fooMethod");
    }
}
