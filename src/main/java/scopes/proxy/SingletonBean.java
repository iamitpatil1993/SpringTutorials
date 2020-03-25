package scopes.proxy;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    private ProxyPrototypeBean proxyPrototypeBean;

    public SingletonBean(ProxyPrototypeBean proxyPrototypeBean) {
        this.proxyPrototypeBean = proxyPrototypeBean;
    }

    public void accessPrototype() {
        // calling method on this proxy of PrototypeProxyBean will create new instance on each call.
        proxyPrototypeBean.fooMethod();
    }
}
