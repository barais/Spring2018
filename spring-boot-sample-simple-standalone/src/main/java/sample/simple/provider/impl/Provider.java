package sample.simple.provider.impl;

import org.springframework.stereotype.Component;
import sample.simple.provider.IProvider;

@Component
public class Provider implements IProvider {
    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void order(Object article) {

    }
}
