package scopes.lookup;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeScopedBean {

    private UUID id;

    public PrototypeScopedBean(final UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
