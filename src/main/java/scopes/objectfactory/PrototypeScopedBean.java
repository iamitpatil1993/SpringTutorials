package scopes.objectfactory;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeScopedBean {

    public static final AtomicInteger INSTANCE_COUNTER = new AtomicInteger();

    public PrototypeScopedBean() {
        INSTANCE_COUNTER.incrementAndGet();
    }

    public static Integer getCount() {
        return INSTANCE_COUNTER.get();
    }
}
